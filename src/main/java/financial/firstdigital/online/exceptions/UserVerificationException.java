package financial.firstdigital.online.exceptions;

public class UserVerificationException extends FdfException {
    public UserVerificationException(String message, String safeMessage) {
        super(message, safeMessage);
    }
}
