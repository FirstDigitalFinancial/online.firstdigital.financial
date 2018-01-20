package financial.firstdigital.online.configuration;

import financial.firstdigital.online.security.JwtAuthenticationEntryPoint;
import financial.firstdigital.online.security.JwtTokenService;
import financial.firstdigital.online.security.TokenAuthenticationFilter;
import financial.firstdigital.online.service.database.SpringUserDetailsService;
import financial.firstdigital.online.utils.DateHelper;
import financial.firstdigital.online.utils.UuidHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final SpringUserDetailsService springUserDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenAuthenticationFilter tokenAuthenticationFilter;
    private final JwtAuthenticationEntryPoint unauthorizedHandler;

    public SecurityConfiguration(SpringUserDetailsService springUserDetailsService,
                                 BCryptPasswordEncoder bCryptPasswordEncoder,
                                 TokenAuthenticationFilter tokenAuthenticationFilter,
                                 JwtAuthenticationEntryPoint  unauthorizedHandler) {
        this.springUserDetailsService = springUserDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenAuthenticationFilter = tokenAuthenticationFilter;
        this.unauthorizedHandler = unauthorizedHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/healthcheck").permitAll()
                .antMatchers(HttpMethod.POST, "/registration/**").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/verification/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
