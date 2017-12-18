package financial.firstdigital.online.service;

import financial.firstdigital.online.model.EmailDetail;
import financial.firstdigital.online.model.User;
import financial.firstdigital.online.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userDetailService")
@Transactional
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public void saveUserDetails(User user) {
        userDetailsRepository.save(user);
    }

    public boolean exists(User user) {
        if (user.getUserName() != null && userDetailsRepository.findDistinctByUserNameEquals(user.getUserName()) != null) {
            return true;
        }

        return false;
    }

    public User findByUsername(String username) {
        return userDetailsRepository.findDistinctByUserNameEquals(username);
    }
}
