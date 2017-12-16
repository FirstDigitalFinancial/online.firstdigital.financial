package financial.firstdigital.online.service;

import financial.firstdigital.online.model.EmailDetail;
import financial.firstdigital.online.model.accounts.RegistrationDetails;
import financial.firstdigital.online.transformers.EmailDetailTransformer;
import org.springframework.stereotype.Component;

@Component
public class AccountCreation {

    private EmailDetailService emailDetailService;
    private EmailDetailTransformer emailDetailTransformer;

    public AccountCreation(EmailDetailService emailDetailService, EmailDetailTransformer emailDetailTransformer) {
        this.emailDetailService = emailDetailService;
        this.emailDetailTransformer = emailDetailTransformer;
    }

    public boolean createAccount(RegistrationDetails registrationDetails) {

        EmailDetail emailDetails = emailDetailTransformer.transform(registrationDetails);
        if (emailDetailService.exists(emailDetails)) {
            return false;
        }

        emailDetailService.saveEmailDetail(emailDetails);

        return true;
    }
}
