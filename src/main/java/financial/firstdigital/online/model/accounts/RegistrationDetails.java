package financial.firstdigital.online.model.accounts;

/**
 * Created by Andrew on 16/12/2017.
 */
public class RegistrationDetails {
    private String emailAddress;
    private String password;

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
}
