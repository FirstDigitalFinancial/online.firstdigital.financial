package financial.firstdigital.online.service;

import financial.firstdigital.online.model.ApplicationUser;
import financial.firstdigital.online.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userDetailsService")
@Transactional
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public void saveUserDetails(ApplicationUser applicationUser) {
        userDetailsRepository.save(applicationUser);
    }

    public boolean exists(ApplicationUser applicationUser) {
        if (applicationUser.getUsername() != null && userDetailsRepository.findDistinctByUserNameEquals(applicationUser.getUsername()) != null) {
            return true;
        }

        return false;
    }

    public ApplicationUser findByUsername(String username) {
        return userDetailsRepository.findDistinctByUserNameEquals(username);
    }
}
