package financial.firstdigital.online.controller;

import financial.firstdigital.online.model.ApplicationUser;
import financial.firstdigital.online.model.security.JwtToken;
import financial.firstdigital.online.model.security.LoginDetails;
import financial.firstdigital.online.model.security.RegistrationDetails;
import financial.firstdigital.online.security.JwtTokenService;
import financial.firstdigital.online.service.*;
import financial.firstdigital.online.service.database.UserTokenService;
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
public class RegistrationResource {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationResource.class);

    private final AccountService accountService;
    private final AccountCreationMailer accountCreationMailer;
    private final RecaptchaVerificationService recaptchaVerificationService;
    private final JwtTokenService tokenService;

    @Autowired
    private UserTokenService userTokenService;

    public RegistrationResource(AccountService accountService,
                                AccountCreationMailer accountCreationMailer,
                                RecaptchaVerificationService recaptchaVerificationService,
                                JwtTokenService tokenService) {
        this.accountService = accountService;
        this.accountCreationMailer = accountCreationMailer;
        this.recaptchaVerificationService = recaptchaVerificationService;
        this.tokenService = tokenService;
    }

    @RequestMapping(value = "/registration/register", method = RequestMethod.POST)
    public ResponseEntity<String> registerNewUser(@RequestBody RegistrationDetails user, HttpServletRequest request) throws Exception {

        recaptchaVerificationService.authenticate(user.getCaptchaResponse(), request.getRemoteAddr());
        ApplicationUser applicationUser = accountService.createAccount(user);
        accountCreationMailer.sendVerificationEmail(applicationUser);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody LoginDetails user, HttpServletRequest request) throws Exception {

        ApplicationUser authenticatedApplicationUser = accountService.authenticateUser(user);

        if (authenticatedApplicationUser != null) {
            JwtToken jwtToken = tokenService.makeJwtToken(authenticatedApplicationUser);
            String tokenHash = tokenService.generateJwtTokenHash(jwtToken);
            jwtToken.setTokenHash(tokenHash);
            userTokenService.saveUserToken(jwtToken);

            return new ResponseEntity<String>(tokenHash, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
}
