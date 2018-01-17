package financial.firstdigital.online.controller;

import financial.firstdigital.online.model.ApplicationUser;
import financial.firstdigital.online.model.security.JwtToken;
import financial.firstdigital.online.model.security.RegistrationDetails;
import financial.firstdigital.online.service.database.UserTokenService;
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
@RequestMapping("/token")
public class JwtTokenResource {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenResource.class);

    @Autowired
    private UserTokenService userTokenService;

    public JwtTokenResource() {

    }

    @RequestMapping(value = "/revoke", method = RequestMethod.POST)
    public ResponseEntity<String> registerNewUser(@RequestParam("token") String tokenHash) throws Exception {
        if (tokenHash != null && userTokenService.exists(tokenHash)) {
            JwtToken token = userTokenService.revokeToken(tokenHash);

            if (token != null) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
