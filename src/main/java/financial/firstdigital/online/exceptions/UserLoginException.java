package financial.firstdigital.online.exceptions;

public class UserLoginException extends FdfException {
    public UserLoginException(String message, String safeMessage) {
        super(message, safeMessage);
    }
}
