package financial.firstdigital.online.repository;

import financial.firstdigital.online.model.security.JwtToken;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<JwtToken, Long>{
    public JwtToken findDistinctByTokenHashEquals(String tokenHash);
    public JwtToken deleteDistinctByTokenHashEquals(String tokenHash);
    public boolean existsByTokenHash(String tokenHash);
}
