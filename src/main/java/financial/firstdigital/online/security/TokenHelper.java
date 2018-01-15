package financial.firstdigital.online.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class TokenHelper {

    private String secretKey;

    public TokenHelper(String secretKey) {
        this.secretKey = secretKey;
    }

    public String makeTokenHash(JwtToken jwtToken) {
        Map<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("typ", jwtToken.getType());
        Map<String, Object> claimMap = new HashMap<>();
        claimMap.put("userFingerprint", jwtToken.getUserFingerPrint());

        String compactJws = Jwts.builder()
                .setSubject(jwtToken.getUserName())
                .setExpiration(jwtToken.getExpirationDate())
                .setIssuedAt(jwtToken.getIssuedAtDate())
                .setNotBefore(jwtToken.getWithNotBeforeDate())
                .setClaims(claimMap)
                .setHeader(headerClaims)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

        return compactJws;
    }
}
