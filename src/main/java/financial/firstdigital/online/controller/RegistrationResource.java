package financial.firstdigital.online.controller;

import financial.firstdigital.online.exceptions.ValidationException;
import financial.firstdigital.online.model.accounts.RegistrationDetails;
import financial.firstdigital.online.service.AccountCreationService;
import financial.firstdigital.online.service.AccountCreationStatus;
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

    public RegistrationResource(AccountCreationService accountCreationService) {
        this.accountCreationService = accountCreationService;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<String> registerNewUser(@RequestBody RegistrationDetails user) throws ValidationException {

        AccountCreationStatus creationStatus = accountCreationService.createAccount(user);

        if (creationStatus == AccountCreationStatus.CREATED) {
            return new ResponseEntity<String>(HttpStatus.OK);
        } else if (creationStatus == AccountCreationStatus.USER_EXISTS) {
            return new ResponseEntity<>(AccountCreationStatus.USER_EXISTS.name(), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>("Error. Account not created", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
