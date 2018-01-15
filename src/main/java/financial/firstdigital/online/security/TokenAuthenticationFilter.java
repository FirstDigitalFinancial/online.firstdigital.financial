package financial.firstdigital.online.security;

import financial.firstdigital.online.model.ApplicationUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Andrew on 15/01/2018.
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private static final long TOKEN_EXPIRATION_TIME = 24 * 60 * 60 * 1000; //24 hours
    private final String jwtSecretKey;

    public TokenAuthenticationFilter(String jwtSecretKey) {
        this.jwtSecretKey = jwtSecretKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

    }

    private String makeToken(HttpServletRequest req, HttpServletResponse res, FilterChain chain, ApplicationUser applicationUser) {
        String token = Jwts.builder()
                .setSubject(applicationUser.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
                .compact();

        return token;
    }
}
