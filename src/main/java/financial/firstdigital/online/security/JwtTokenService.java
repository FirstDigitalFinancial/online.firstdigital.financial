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
import org.springframework.context.annotation.Lazy;

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
                .setClaims(claimMap)
                .setHeader(headerClaims)
                .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
                .compact();

        return compactJws;
    }

    public boolean validateJwtToken(String jwtTokenHash) {
        JwtToken jwtToken = userTokenService.findByTokenHash(jwtTokenHash);
        try {
            Jws<Claims> claims = Jwts.parser()
                    .requireSubject(jwtToken.getUsername())
                    .requireExpiration(jwtToken.getExpirationDate())
                    .requireIssuedAt(jwtToken.getIssuedAtDate())
                    .requireNotBefore(jwtToken.getWithNotBeforeDate())
                    .require("userFingerprint", jwtToken.getUserFingerPrint())
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
        }  catch (ExpiredTokenException e) {
            logger.info(String.format("ExpiredTokenException, JwtToken Failed - %s : %s", jwtToken.getUsername(), jwtTokenHash));
        } catch (Exception e) {
            logger.info("UnknownException, JwtToken Failed");
            throw e;
        }

        return false;
    }
}
