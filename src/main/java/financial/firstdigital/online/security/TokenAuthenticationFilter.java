package financial.firstdigital.online.security;

import financial.firstdigital.online.model.security.JwtToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

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

        String tokenHash = tokenHeader.replace(TOKEN_PREFIX, "").trim();

        // check for a token like string

        JwtToken jwtToken = tokenService.getStoredToken(tokenHash);

        if (!tokenService.validateJwtToken(jwtToken, tokenHash)) {
            chain.doFilter(request, response);
            return;
        }

        // Investigate what this is doing...
        UserDetails userDetails = new User(jwtToken.getUsername(), jwtToken.getTokenHash(), Collections.emptyList());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }
}
