package financial.firstdigital.online.controller;

import financial.firstdigital.online.exceptions.AccountCreationException;
import financial.firstdigital.online.model.EmailDetail;
import financial.firstdigital.online.service.database.EmailDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verification/email/")
public class EmailVerificationController {

    private static final Logger logger = LoggerFactory.getLogger(EmailVerificationController.class);

    private final EmailDetailService emailDetailService;

    public EmailVerificationController(EmailDetailService emailDetailService) {
        this.emailDetailService = emailDetailService;
    }

    @RequestMapping(value = "verify", method = RequestMethod.GET)
    public ResponseEntity<String> getTelephoneDetails(String verificationToken) {

        return new ResponseEntity<>("Not implemented", HttpStatus.NOT_IMPLEMENTED);

    }

    @RequestMapping(value = "verify", method = RequestMethod.POST)
    public ResponseEntity<String> verifyEmail(@RequestBody EmailDetail verificationKey) throws AccountCreationException {

        EmailDetail emailDetailToVerify = emailDetailService.findDistinctByVerificationKeyEquals(verificationKey.getVerificationKey());

        if (emailDetailToVerify != null) {
            emailDetailToVerify.setVerified(true);
            emailDetailService.saveEmailDetail(emailDetailToVerify);
            return new ResponseEntity<>("Email verified", HttpStatus.OK);
        }

        return new ResponseEntity<>("Error. Email not verified", HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
