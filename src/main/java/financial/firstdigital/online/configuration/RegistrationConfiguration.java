package financial.firstdigital.online.configuration;

import financial.firstdigital.online.security.JwtTokenService;
import financial.firstdigital.online.security.TokenAuthenticationFilter;
import financial.firstdigital.online.service.RecaptchaVerificationService;
import financial.firstdigital.online.transformers.ApplicationUserTransformer;
import financial.firstdigital.online.transformers.EmailDetailTransformer;
import financial.firstdigital.online.utils.DateHelper;
import financial.firstdigital.online.utils.UuidHelper;
import financial.firstdigital.online.validation.EmailValidation;
import financial.firstdigital.online.validation.PasswordValidation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableWebSecurity
public class RegistrationConfiguration {

    @Value("${google.recaptcha.secretkey}")
    private String recaptchaSecretKey;

    @Value("${google.recaptcha.verify-url}")
    private String recaptchaVerifyUrl;

    @Value("${google.recaptcha.enabled}")
    private boolean isRecaptchaVerificationEnabled;

    @Value("${jwt.secret.key}")
    private String jwtSecretKey;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public EmailValidation emailValidation() {
        return new EmailValidation();
    }

    @Bean
    public PasswordValidation passwordValidation() {
        return new PasswordValidation();
    }

    @Bean
    public EmailDetailTransformer emailDetailTransformer() {
        return new EmailDetailTransformer();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ApplicationUserTransformer applicationUserTransformer() {
        return new ApplicationUserTransformer(bCryptPasswordEncoder());
    }

    @Bean
    public RecaptchaVerificationService recaptchaAuthenticationService(RestTemplate restTemplate) {
        return new RecaptchaVerificationService(restTemplate, recaptchaVerifyUrl, recaptchaSecretKey, isRecaptchaVerificationEnabled);
    }

    @Bean
    public JwtTokenService jwtTokenService() {
        return new JwtTokenService(jwtSecretKey, new DateHelper(), new UuidHelper());
    }

    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter(jwtTokenService());
    }
}
