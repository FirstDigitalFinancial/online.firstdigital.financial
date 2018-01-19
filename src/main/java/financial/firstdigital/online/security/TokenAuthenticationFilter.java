package financial.firstdigital.online.security;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static financial.firstdigital.online.configuration.SecurityConstants.HEADER_STRING;
import static financial.firstdigital.online.configuration.SecurityConstants.TOKEN_PREFIX;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenService tokenService;

    public TokenAuthenticationFilter(JwtTokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String tokenHeader = request.getHeader(HEADER_STRING);

        if (tokenHeader == null  || !tokenHeader.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        String tokenHash = tokenHeader.replace(TOKEN_PREFIX, "");

        if (tokenService.validateJwtToken(tokenHash)) {
            chain.doFilter(request, response);
            return;
        }

        chain.doFilter(request, response);
    }
}
