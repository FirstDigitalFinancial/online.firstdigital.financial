package financial.firstdigital.online.service;

import financial.firstdigital.online.model.User;
import financial.firstdigital.online.model.accounts.RegistrationDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AccountCreation {

    private UserDetailsService userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public AccountCreation(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public boolean createAccount(RegistrationDetails registrationDetails) {

        User user = new User();
        user.setUserName(registrationDetails.getEmailAddress());
        user.setPassword(bCryptPasswordEncoder.encode(registrationDetails.getPassword()));

        userDetailsService.saveUserDetails(user);

        return true;
    }
}
