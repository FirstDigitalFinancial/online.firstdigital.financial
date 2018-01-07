package financial.firstdigital.online.model.accounts;

/**
 * Created by Andrew on 16/12/2017.
 */
public class RegistrationDetails {
    private String emailAddress;
    private String password;
    private String firstName;
    private String lastName;
    private String captchaResponse;

    @Override
    public String toString() {
        return String.format("%s, %s", emailAddress, password);
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCaptchaResponse() {
        return captchaResponse;
    }

    public void setCaptchaResponse(String captchaResponse) {
        this.captchaResponse = captchaResponse;
    }
}
