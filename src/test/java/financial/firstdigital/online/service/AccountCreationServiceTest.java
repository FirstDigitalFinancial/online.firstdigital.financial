package financial.firstdigital.online.service;

import financial.firstdigital.online.exceptions.AccountCreationException;
import financial.firstdigital.online.model.ApplicationUser;
import financial.firstdigital.online.model.accounts.RegistrationDetails;
import financial.firstdigital.online.service.database.UserDetailsService;
import financial.firstdigital.online.transformers.ApplicationUserTransformer;
import financial.firstdigital.online.validation.EmailValidation;
import financial.firstdigital.online.validation.PasswordValidation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class AccountCreationServiceTest {

    @Mock
    private UserDetailsService userDetailsService;
    @Mock
    private ApplicationUserTransformer applicationUserTransformer;

    private AccountCreationService accountCreationService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        accountCreationService = new AccountCreationService(applicationUserTransformer,
                userDetailsService,
                new PasswordValidation(),
                new EmailValidation());
    }

    @Test
    public void should_create_user_account() throws Exception {
        ApplicationUser applicationUser = makeApplicationUser("Pa55word", "test@test.com");
        RegistrationDetails registrationDetails = makeRegistrationDetails("Pa55word", "test@test.com");

        when(applicationUserTransformer.transform(anyObject())).thenReturn(applicationUser);

        accountCreationService.createAccount(registrationDetails);

        verify(userDetailsService, times(1)).saveUserDetails(applicationUser);
    }

    @Test(expected = AccountCreationException.class)
    public void should_return_USER_EXISTS_if_user_exists() throws Exception {
        ApplicationUser applicationUser = makeApplicationUser("Pa55word", "test@test.com");
        RegistrationDetails registrationDetails = makeRegistrationDetails("Pa55word", "test@test.com");

        when(applicationUserTransformer.transform(anyObject())).thenReturn(applicationUser);
        when(userDetailsService.exists(applicationUser)).thenReturn(true);

        accountCreationService.createAccount(registrationDetails);
    }

    @Test(expected = AccountCreationException.class)
    public void should_throw_exception_when_invalid_email_passed() throws Exception {
        ApplicationUser applicationUser = makeApplicationUser("Pa55word", "username");
        RegistrationDetails registrationDetails = makeRegistrationDetails("Pa55word", "username");

        when(applicationUserTransformer.transform(anyObject())).thenReturn(applicationUser);
        accountCreationService.createAccount(registrationDetails);
    }

    @Test(expected = AccountCreationException.class)
    public void should_throw_exception_when_invalid_password_passed() throws Exception {
        ApplicationUser applicationUser = makeApplicationUser("nope", "test@test.com");
        RegistrationDetails registrationDetails = makeRegistrationDetails("nope", "test@test.com");

        when(applicationUserTransformer.transform(anyObject())).thenReturn(applicationUser);
        accountCreationService.createAccount(registrationDetails);
    }

    private ApplicationUser makeApplicationUser(String password, String username) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setPassword(password);
        applicationUser.setUsername(username);
        return applicationUser;
    }

    private RegistrationDetails makeRegistrationDetails(String password, String username) {
        RegistrationDetails registrationDetails = new RegistrationDetails();
        registrationDetails.setPassword(password);
        registrationDetails.setEmailAddress(username);
        return registrationDetails;
    }

}