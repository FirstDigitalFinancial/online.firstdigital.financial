package financial.firstdigital.online.configuration;

import financial.firstdigital.online.transformers.EmailDetailTransformer;
import financial.firstdigital.online.validation.EmailValidation;
import financial.firstdigital.online.validation.PasswordValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class RegistrationConfiguration {

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
}