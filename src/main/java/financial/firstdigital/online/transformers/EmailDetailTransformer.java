package financial.firstdigital.online.transformers;

import financial.firstdigital.online.model.EmailDetail;
import financial.firstdigital.online.model.accounts.RegistrationDetails;

public class EmailDetailTransformer {

    public EmailDetail transform(RegistrationDetails registrationDetails) {
        EmailDetail emailDetail = new EmailDetail();
        emailDetail.setEmailAddress(registrationDetails.getEmailAddress());
        emailDetail.setVerified(false);
        return emailDetail;
    }
}
