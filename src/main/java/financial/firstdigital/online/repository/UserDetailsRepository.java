package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<User, Long>{
    public User findDistinctByUserNameEquals(String username);
}
