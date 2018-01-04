package financial.firstdigital.online.controller;

import financial.firstdigital.online.exceptions.ValidationException;
import financial.firstdigital.online.model.EmailDetail;
import financial.firstdigital.online.model.EmailType;
import financial.firstdigital.online.model.accounts.RegistrationDetails;
import financial.firstdigital.online.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Component
@RestController
@RequestMapping("/registration")
public class RegistrationResource {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationResource.class);

    private final AccountCreationService accountCreationService;
    private final AccountCreationMailer accountCreationMailer;
    private final EmailDetailService emailDetailService;

    public RegistrationResource(AccountCreationService accountCreationService, AccountCreationMailer accountCreationMailer, EmailDetailService emailDetailService) {
        this.accountCreationService = accountCreationService;
        this.accountCreationMailer = accountCreationMailer;
        this.emailDetailService = emailDetailService;

    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<String> registerNewUser(@RequestBody RegistrationDetails user) throws ValidationException {

        AccountCreationStatus creationStatus = accountCreationService.createAccount(user);

        EmailDetail emailDetail= new EmailDetail();
        emailDetail.setEmailAddress(user.getEmailAddress());
        emailDetail.setVerified(false);
        emailDetail.setEmailType(EmailType.PRIMARY);
        emailDetail.setVerificationKey(UUID.randomUUID().toString());

        emailDetailService.saveEmailDetail(emailDetail);


        if (creationStatus == AccountCreationStatus.CREATED) {
            accountCreationMailer.sendVerificationEmail(emailDetail);
            return new ResponseEntity<String>(HttpStatus.OK);
        } else if (creationStatus == AccountCreationStatus.USER_EXISTS) {
            return new ResponseEntity<>(AccountCreationStatus.USER_EXISTS.name(), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>("Error. Account not created", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
