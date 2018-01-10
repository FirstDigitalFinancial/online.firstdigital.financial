package financial.firstdigital.online.controller;

import financial.firstdigital.online.model.TelephoneDetail;
import financial.firstdigital.online.service.database.TelephoneDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verification/telephone/")
public class TelephoneVerificationController {

    private static final Logger logger = LoggerFactory.getLogger(TelephoneVerificationController.class);

    @Autowired
    private final TelephoneDetailService telephoneDetailService;

    public TelephoneVerificationController(TelephoneDetailService telephoneDetailService) {
        this.telephoneDetailService = telephoneDetailService;
    }

    @RequestMapping(value = "verify", method = RequestMethod.POST)
    public ResponseEntity<String> verifyTelephone(TelephoneDetail telephoneDetail) {

        logger.info("Verifying telephone number");

        if (telephoneDetail != null) {

            TelephoneDetail telephoneDetailToVerify = telephoneDetailService.findDistinctByVerificationCodeIs(telephoneDetail.getVerificationCode());

            if (telephoneDetailToVerify != null) {

                if (telephoneDetailToVerify.getVerified()) {
                    logger.info("Telephone number already verified");
                    return new ResponseEntity<>("Telephone number already verified", HttpStatus.ALREADY_REPORTED);
                } else if (telephoneDetail.getTelephoneNumber().equalsIgnoreCase(telephoneDetailToVerify.getTelephoneNumber())
                        & telephoneDetail.getVerificationCode() == telephoneDetailToVerify.getVerificationCode()) {
                    logger.info("Telephone number verification successful");
                    telephoneDetailToVerify.setVerified(true);
                    telephoneDetailService.saveTelephoneDetail(telephoneDetailToVerify);
                    return new ResponseEntity<>("Telephone number verified", HttpStatus.OK);
                }
            }

        }

        logger.info("Telephone number verification unsuccessful");
        return new ResponseEntity<>("Your telephone number or code is incorrect", HttpStatus.NOT_FOUND);

    }

}
