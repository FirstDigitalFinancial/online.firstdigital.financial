package financial.firstdigital.online.controller;

import financial.firstdigital.online.model.security.JwtToken;
import financial.firstdigital.online.service.database.UserTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import static financial.firstdigital.online.configuration.SecurityConstants.TOKEN_PREFIX;

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
    public ResponseEntity<String> registerNewUser(@RequestHeader(name = "Authorization", required = true) String tokenHeader) throws Exception {
        if (tokenHeader == null  || !tokenHeader.startsWith(TOKEN_PREFIX)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String tokenHash = tokenHeader.replace(TOKEN_PREFIX, "").trim();

        if (userTokenService.exists(tokenHash)) {
            userTokenService.revokeToken(tokenHash);

            if (userTokenService.exists(tokenHash)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
