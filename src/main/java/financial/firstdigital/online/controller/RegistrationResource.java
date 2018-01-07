package financial.firstdigital.online.controller;

import financial.firstdigital.online.exceptions.AccountCreationException;
import financial.firstdigital.online.model.ApplicationUser;
import financial.firstdigital.online.model.accounts.RegistrationDetails;
import financial.firstdigital.online.service.*;
import financial.firstdigital.online.service.mailer.AccountCreationMailer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Component
@RestController
@RequestMapping("/registration")
public class RegistrationResource {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationResource.class);

    private final AccountCreationService accountCreationService;
    private final AccountCreationMailer accountCreationMailer;
    private final RecaptchaVerificationService recaptchaVerificationService;

    public RegistrationResource(AccountCreationService accountCreationService,
                                AccountCreationMailer accountCreationMailer,
                                RecaptchaVerificationService recaptchaVerificationService) {
        this.accountCreationService = accountCreationService;
        this.accountCreationMailer = accountCreationMailer;
        this.recaptchaVerificationService = recaptchaVerificationService;

    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<String> registerNewUser(@RequestBody RegistrationDetails user, HttpServletRequest request) throws Exception {

        recaptchaVerificationService.authenticate(user.getCaptchaResponse(), request.getRemoteAddr());
        ApplicationUser applicationUser = accountCreationService.createAccount(user);
        accountCreationMailer.sendVerificationEmail(applicationUser);

        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
