package financial.firstdigital.online.service.database;

import financial.firstdigital.online.Application;
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

    public boolean usernameExists(ApplicationUser applicationUser) {
        if (applicationUser.getUsername() != null && userDetailsRepository.findDistinctByUsernameEquals(applicationUser.getUsername()) != null) {
            return true;
        }

        return false;
    }

    public ApplicationUser findByUsernameAndPassword(String username, String password) {
        if (username == null || password == null) {
            return null;
        }

        return userDetailsRepository.findDistinctByUsernameAndPassword(username, password);
    }

    public ApplicationUser findByUsername(String username) {
        return userDetailsRepository.findDistinctByUsernameEquals(username);
    }
}
