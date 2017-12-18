package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<ApplicationUser, Long>{
    public ApplicationUser findDistinctByUserNameEquals(String username);
}
