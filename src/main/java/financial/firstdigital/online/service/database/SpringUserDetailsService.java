package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.ApplicationUser;
import financial.firstdigital.online.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service("userDetailService")
@Transactional
public class SpringUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser domainApplicationUser = userDetailsRepository.findDistinctByUsernameEquals(username);
        if (domainApplicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(domainApplicationUser.getUsername(), domainApplicationUser.getPassword(), Collections.emptyList());
    }
}
