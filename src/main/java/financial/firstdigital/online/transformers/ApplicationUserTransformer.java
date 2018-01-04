package financial.firstdigital.online.transformers;

import financial.firstdigital.online.model.ApplicationUser;
import financial.firstdigital.online.model.accounts.RegistrationDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

public class ApplicationUserTransformer {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationUserTransformer(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public ApplicationUser transform(RegistrationDetails registrationDetails) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUsername(registrationDetails.getEmailAddress());
        applicationUser.setPassword(bCryptPasswordEncoder.encode(registrationDetails.getPassword()));
        applicationUser.setVerified(false);
        applicationUser.setVerificationKey(UUID.randomUUID().toString());

        return applicationUser;
    }
}
