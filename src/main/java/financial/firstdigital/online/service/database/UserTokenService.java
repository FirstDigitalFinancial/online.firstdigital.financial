package financial.firstdigital.online.service.database;

import financial.firstdigital.online.model.security.JwtToken;
import financial.firstdigital.online.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userTokenService")
@Transactional
public class UserTokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public void saveUserToken(JwtToken jwtToken) {
        tokenRepository.save(jwtToken);
    }

    public JwtToken findByTokenHash(String tokenHash) {
        return tokenRepository.findDistinctByTokenHashEquals(tokenHash);
    }

    public boolean exists(String tokenHash) {
        return tokenRepository.existsByTokenHash(tokenHash);
    }

    public JwtToken revokeToken(String tokenHash) {
        return tokenRepository.deleteDistinctByTokenHashEquals(tokenHash);
    }
}
