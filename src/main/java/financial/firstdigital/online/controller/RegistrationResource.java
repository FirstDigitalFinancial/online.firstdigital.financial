package financial.firstdigital.online.controller;

import financial.firstdigital.online.exceptions.AccountCreationException;
import financial.firstdigital.online.model.ApplicationUser;
import financial.firstdigital.online.model.accounts.RegistrationDetails;
import financial.firstdigital.online.service.*;
import financial.firstdigital.online.service.database.EmailDetailService;
import financial.firstdigital.online.service.mailer.AccountCreationMailer;
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

    private final AccountCreationService accountCreationService;
    private final AccountCreationMailer accountCreationMailer;

    public RegistrationResource(AccountCreationService accountCreationService, AccountCreationMailer accountCreationMailer) {
        this.accountCreationService = accountCreationService;
        this.accountCreationMailer = accountCreationMailer;

    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<String> registerNewUser(@RequestBody RegistrationDetails user) throws AccountCreationException {

        ApplicationUser applicationUser = accountCreationService.createAccount(user);
        accountCreationMailer.sendVerificationEmail(applicationUser);

        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
