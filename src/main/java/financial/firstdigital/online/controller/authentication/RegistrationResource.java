package financial.firstdigital.online.controller.authentication;

import financial.firstdigital.online.model.accounts.RegistrationDetails;
import financial.firstdigital.online.service.AccountCreation;
import financial.firstdigital.online.validation.EmailValidation;
import financial.firstdigital.online.validation.PasswordValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/registration")
public class RegistrationResource {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationResource.class);

    private final PasswordValidation passwordValidation;
    private final EmailValidation emailValidation;
    private final AccountCreation accountCreation;

    public RegistrationResource(AccountCreation accountCreation,
                                EmailValidation emailValidation,
                                PasswordValidation passwordValidation) {
        this.accountCreation = accountCreation;
        this.emailValidation = emailValidation;
        this.passwordValidation = passwordValidation;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<String> registerNewUser(@RequestBody RegistrationDetails user) {

        if (!emailValidation.validate(user.getEmailAddress())) {
            return new ResponseEntity<>("A valid e-mail address", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (!passwordValidation.validate(user.getPassword())) {
            return new ResponseEntity<>("4 to 8 character password requiring numbers and both lowercase and uppercase letters", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (accountCreation.createAccount(user)) {
            return new ResponseEntity<String>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error. Account not created", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
