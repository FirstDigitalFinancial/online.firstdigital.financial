package financial.firstdigital.online.service;

import financial.firstdigital.online.exceptions.AccountCreationException;
import financial.firstdigital.online.model.ApplicationUser;
import financial.firstdigital.online.model.security.LoginDetails;
import financial.firstdigital.online.model.security.RegistrationDetails;
import financial.firstdigital.online.service.database.UserDetailsService;
import financial.firstdigital.online.transformers.ApplicationUserTransformer;
import financial.firstdigital.online.validation.EmailValidation;
import financial.firstdigital.online.validation.PasswordValidation;
import org.springframework.stereotype.Component;

@Component
public class AccountService {

    private final ApplicationUserTransformer applicationUserTransformer;
    private final UserDetailsService userDetailsService;
    private final PasswordValidation passwordValidation;
    private final EmailValidation emailValidation;

    public AccountService(ApplicationUserTransformer applicationUserTransformer,
                          UserDetailsService userDetailsService,
                          PasswordValidation passwordValidation,
                          EmailValidation emailValidation) {
        this.applicationUserTransformer = applicationUserTransformer;
        this.userDetailsService = userDetailsService;
        this.passwordValidation = passwordValidation;
        this.emailValidation = emailValidation;
    }

    public ApplicationUser createAccount(RegistrationDetails registrationDetails) throws AccountCreationException {
        validate(registrationDetails);

        ApplicationUser applicationUser = applicationUserTransformer.transform(registrationDetails);

        if (userDetailsService.usernameExists(applicationUser)) {
            throw new AccountCreationException("User usernameExists", "User Already Exists");
        }

        userDetailsService.saveUserDetails(applicationUser);
        return applicationUser;
    }

    private void validate(RegistrationDetails registrationDetails) throws AccountCreationException {
        if (!emailValidation.validate(registrationDetails.getEmailAddress())) {
            throw new AccountCreationException("Invalid email", "Invalid Email Address");
        }

        if (!passwordValidation.validate(registrationDetails.getPassword())) {
            throw new AccountCreationException("Invalid password", "Invalid Password");
        }
    }

    public ApplicationUser authenticateUser(LoginDetails user) {
        ApplicationUser unauthenticatedUser = applicationUserTransformer.transform(user);
        ApplicationUser applicationUser = userDetailsService.findByUsernameAndPassword(unauthenticatedUser.getUsername(), unauthenticatedUser.getPassword());

        if (applicationUser.getVerified()) {
            return applicationUser;
        }

        return null;
    }
}
