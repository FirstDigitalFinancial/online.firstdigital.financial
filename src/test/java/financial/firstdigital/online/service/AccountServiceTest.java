package financial.firstdigital.online.service;

import financial.firstdigital.online.exceptions.AccountCreationException;
import financial.firstdigital.online.model.ApplicationUser;
import financial.firstdigital.online.model.security.RegistrationDetails;
import financial.firstdigital.online.service.database.UserDetailsService;
import financial.firstdigital.online.transformers.ApplicationUserTransformer;
import financial.firstdigital.online.validation.EmailValidation;
import financial.firstdigital.online.validation.PasswordValidation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class AccountServiceTest {

    @Mock
    private UserDetailsService userDetailsService;
    @Mock
    private ApplicationUserTransformer applicationUserTransformer;

    private AccountService accountService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        accountService = new AccountService(applicationUserTransformer,
                userDetailsService,
                new PasswordValidation(),
                new EmailValidation());
    }

    @Test
    public void should_create_user_account() throws Exception {
        ApplicationUser applicationUser = makeApplicationUser("Pa55word", "test@test.com");
        RegistrationDetails registrationDetails = makeRegistrationDetails("Pa55word", "test@test.com");

        when(applicationUserTransformer.transform(any(RegistrationDetails.class))).thenReturn(applicationUser);

        accountService.createAccount(registrationDetails);

        verify(userDetailsService, times(1)).saveUserDetails(applicationUser);
    }

    @Test(expected = AccountCreationException.class)
    public void should_return_USER_EXISTS_if_user_exists() throws Exception {
        ApplicationUser applicationUser = makeApplicationUser("Pa55word", "test@test.com");
        RegistrationDetails registrationDetails = makeRegistrationDetails("Pa55word", "test@test.com");

        when(applicationUserTransformer.transform(any(RegistrationDetails.class))).thenReturn(applicationUser);
        when(userDetailsService.usernameExists(applicationUser)).thenReturn(true);

        accountService.createAccount(registrationDetails);
    }

    @Test(expected = AccountCreationException.class)
    public void should_throw_exception_when_invalid_email_passed() throws Exception {
        ApplicationUser applicationUser = makeApplicationUser("Pa55word", "username");
        RegistrationDetails registrationDetails = makeRegistrationDetails("Pa55word", "username");

        when(applicationUserTransformer.transform(any(RegistrationDetails.class))).thenReturn(applicationUser);
        accountService.createAccount(registrationDetails);
    }

    @Test(expected = AccountCreationException.class)
    public void should_throw_exception_when_invalid_password_passed() throws Exception {
        ApplicationUser applicationUser = makeApplicationUser("nope", "test@test.com");
        RegistrationDetails registrationDetails = makeRegistrationDetails("nope", "test@test.com");

        when(applicationUserTransformer.transform(any(RegistrationDetails.class))).thenReturn(applicationUser);
        accountService.createAccount(registrationDetails);
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