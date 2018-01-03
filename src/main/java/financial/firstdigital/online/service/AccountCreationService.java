package financial.firstdigital.online.service;

import financial.firstdigital.online.exceptions.ValidationException;
import financial.firstdigital.online.model.ApplicationUser;
import financial.firstdigital.online.model.accounts.RegistrationDetails;
import financial.firstdigital.online.transformers.ApplicationUserTransformer;
import financial.firstdigital.online.validation.EmailValidation;
import financial.firstdigital.online.validation.PasswordValidation;
import org.springframework.stereotype.Component;

import static financial.firstdigital.online.service.AccountCreationStatus.CREATED;
import static financial.firstdigital.online.service.AccountCreationStatus.USER_EXISTS;

@Component
public class AccountCreationService {

    private final ApplicationUserTransformer applicationUserTransformer;
    private final UserDetailsService userDetailsService;
    private final PasswordValidation passwordValidation;
    private final EmailValidation emailValidation;

    public AccountCreationService(ApplicationUserTransformer applicationUserTransformer,
                                  UserDetailsService userDetailsService,
                                  PasswordValidation passwordValidation,
                                  EmailValidation emailValidation) {
        this.applicationUserTransformer = applicationUserTransformer;
        this.userDetailsService = userDetailsService;
        this.passwordValidation = passwordValidation;
        this.emailValidation = emailValidation;
    }

    public AccountCreationStatus createAccount(RegistrationDetails registrationDetails) throws ValidationException {
        ApplicationUser applicationUser = applicationUserTransformer.transform(registrationDetails);

        if (userDetailsService.exists(applicationUser)) {
            return USER_EXISTS;
        }

        validate(registrationDetails);

        userDetailsService.saveUserDetails(applicationUser);
        return CREATED;
    }

    private void validate(RegistrationDetails registrationDetails) throws ValidationException {
        if (!emailValidation.validate(registrationDetails.getEmailAddress())) {
            throw new ValidationException("Invalid email");
        }

        if (!passwordValidation.validate(registrationDetails.getPassword())) {
            throw new ValidationException("Invalid password");
        }
    }
}
