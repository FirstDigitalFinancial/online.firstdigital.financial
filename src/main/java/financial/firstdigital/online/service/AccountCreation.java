package financial.firstdigital.online.service;

import financial.firstdigital.online.model.ApplicationUser;
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

        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUsername(registrationDetails.getEmailAddress());
        applicationUser.setPassword(bCryptPasswordEncoder.encode(registrationDetails.getPassword()));

        userDetailsService.saveUserDetails(applicationUser);

        return userDetailsService.exists(applicationUser);
    }
}
