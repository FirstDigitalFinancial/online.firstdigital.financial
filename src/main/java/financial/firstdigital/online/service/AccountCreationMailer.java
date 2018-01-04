package financial.firstdigital.online.service;

import financial.firstdigital.online.model.EmailDetail;

public interface AccountCreationMailer {

    public void sendVerificationEmail(EmailDetail emailDetail);

}
