package financial.firstdigital.online.security;

import financial.firstdigital.online.model.ApplicationUser;
import financial.firstdigital.online.model.security.JwtToken;
import financial.firstdigital.online.service.database.UserTokenService;
import financial.firstdigital.online.utils.DateHelper;
import financial.firstdigital.online.utils.UuidHelper;
import io.jsonwebtoken.*;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenService {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenService.class);

    private final DateHelper dateHelper;
    private final int tokenDuration;
    private final UuidHelper uuidHelper;
    private final String jwtSecretKey;

    @Autowired
    private UserTokenService userTokenService;

    public JwtTokenService(String jwtSecretKey, DateHelper dateHelper, UuidHelper uuidHelper) {
        this.jwtSecretKey = jwtSecretKey;
        this.dateHelper = dateHelper;
        this.uuidHelper = uuidHelper;
        this.tokenDuration = 1000 * 60 * 60 * 24; //24 hours
    }


    public JwtToken makeJwtToken(ApplicationUser authenticatedApplicationUser) {
        DateTime expirationDate = dateHelper.getDate().plus(tokenDuration);
        DateTime notBefore = dateHelper.getDate();
        DateTime issuedAt = dateHelper.getDate();
        JwtToken jwtToken = new JwtToken(uuidHelper.getRandomUuid(),
                authenticatedApplicationUser.getUsername(),
                issuedAt.toDate(),
                notBefore.toDate(),
                expirationDate.toDate());

        return jwtToken;
    }

    public String generateJwtTokenHash(JwtToken jwtToken) {
        Map<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("typ", jwtToken.getType());
        Map<String, Object> claimMap = new HashMap<>();
        claimMap.put("userFingerprint", jwtToken.getUserFingerPrint());

        String compactJws = Jwts.builder()
                .setSubject(jwtToken.getUsername())
                .setExpiration(jwtToken.getExpirationDate())
                .setIssuedAt(jwtToken.getIssuedAtDate())
                .setNotBefore(jwtToken.getWithNotBeforeDate())
                .setId(jwtToken.getUserFingerPrint())
                .setHeader(headerClaims)
                .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
                .compact();

        return compactJws;
    }

    public JwtToken getStoredToken(String jwtTokenHash) {
        return userTokenService.findByTokenHash(jwtTokenHash);
    }

    public boolean validateJwtToken(JwtToken jwtToken, String jwtTokenHash) {
        if (jwtTokenHash == null) {
            logger.info(String.format("TokenHash not found: %s", jwtTokenHash));
            return false;
        }

        if (jwtToken == null) {
            logger.info(String.format("JwtToken not found in database: %s", jwtTokenHash));
            return false;
        }

        try {
            Jws<Claims> claims = Jwts.parser()
                    .requireSubject(jwtToken.getUsername())
                    .requireExpiration(jwtToken.getExpirationDate())
                    .requireIssuedAt(jwtToken.getIssuedAtDate())
                    .requireNotBefore(jwtToken.getWithNotBeforeDate())
                    .requireId(jwtToken.getUserFingerPrint())
                    .setSigningKey(jwtSecretKey)
                    .parseClaimsJws(jwtTokenHash);


            Date now = dateHelper.getDate().toDate();
            if (now.after(jwtToken.getExpirationDate())) {
                throw new ExpiredTokenException();
            }

            return true;
        } catch (MissingClaimException e) {
            logger.info(String.format("MissingClaimException, JwtToken Failed - %s : %s", jwtToken.getUsername(), jwtTokenHash));
        } catch (IncorrectClaimException e) {
            logger.info(String.format("IncorrectClaimException, JwtToken Failed - %s : %s", jwtToken.getUsername(), jwtTokenHash));
        } catch (ExpiredTokenException e) {
            logger.info(String.format("ExpiredTokenException, JwtToken Failed - %s : %s", jwtToken.getUsername(), jwtTokenHash));
        } catch (Exception e) {
            logger.info("UnknownException, JwtToken Failed");
            throw e;
        }

        return false;
    }
}
