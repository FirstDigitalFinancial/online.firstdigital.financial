package financial.firstdigital.online.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import financial.firstdigital.online.model.TelephoneDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsSenderService {

    private static final Logger logger = LoggerFactory.getLogger(SmsSenderService.class);


    @Value("${twilio.account.sid}")
    private String ACCOUNT_SID;

    @Value("${twilio.auth.token}")
    private String AUTH_TOKEN;

    @Value("${sms.verification.text}")
    private String SMS_MESSAGE;

    @Value("${twilio.from.number}")
    private String TWILIO_FROM_NUMBER;

    public SmsSenderService() {
    }

    public void sendVerificationSms(TelephoneDetail telephoneDetail) {

        String fullMessage = SMS_MESSAGE + telephoneDetail.getVerificationCode();

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new PhoneNumber(telephoneDetail.getTelephoneNumber().toString()),
                new PhoneNumber(TWILIO_FROM_NUMBER),
                fullMessage).create();

        logger.info("SMS sent. Sid: " + message.getSid());

    }

}
