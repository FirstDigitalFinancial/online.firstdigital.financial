package financial.firstdigital.online.service;

import financial.firstdigital.online.exceptions.RecaptchaException;
import financial.firstdigital.online.model.security.RecaptchaVerificationResponse;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RecaptchaVerificationService {

    private final RestTemplate restTemplate;
    private final String recapatchaVerifyUrl;
    private final String recaptchaSecret;
    private final boolean isRecaptchaVerificationEnabled;

    public RecaptchaVerificationService(RestTemplate restTemplate, String recaptchaVerifyUrl, String recaptchaSecret, boolean isRecaptchaVerificationEnabled) {
        this.restTemplate = restTemplate;
        this.recapatchaVerifyUrl = recaptchaVerifyUrl;
        this.recaptchaSecret = recaptchaSecret;
        this.isRecaptchaVerificationEnabled = isRecaptchaVerificationEnabled;
    }

    public RecaptchaVerificationResponse authenticate(String recaptchaUserResponse, String usersIpAddress) throws RecaptchaException {
        if (!isRecaptchaVerificationEnabled) {
            return new RecaptchaVerificationResponse();
        }

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map requestPayload = new HashMap();
        requestPayload.put("secret", recaptchaSecret);
        requestPayload.put("response ", recaptchaUserResponse);
        requestPayload.put("remoteip", usersIpAddress);

        HttpEntity<?> request = new HttpEntity<>(requestPayload, headers);

        RecaptchaVerificationResponse response = restTemplate.postForObject(recapatchaVerifyUrl, request, RecaptchaVerificationResponse.class);

        if (response.isSuccessful()) {
            return response;
        } else {
            throw new RecaptchaException("Recaptcha verification failed", "Recaptcha verification failed");
        }
    }
}
