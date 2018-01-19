package financial.firstdigital.online.model.security;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RecaptchaVerificationResponse {
    private boolean successful;
    private String hostname;
    @JsonProperty("challenge_ts")
    private String timestamp;
    @JsonProperty("error-codes")
    private List<String> errorCodes;

    public RecaptchaVerificationResponse() {

    }

    public RecaptchaVerificationResponse(boolean successful, String hostname, String timestamp) {
        this.successful = successful;
        this.hostname = hostname;
        this.timestamp = timestamp;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }
}
