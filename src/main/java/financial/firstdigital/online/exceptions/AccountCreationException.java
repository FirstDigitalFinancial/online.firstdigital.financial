package financial.firstdigital.online.exceptions;

/**
 * Created by Andrew on 03/01/2018.
 */
public class AccountCreationException extends FdfException {
    public AccountCreationException(String message, String safeMessage) {
        super(message, safeMessage);
    }
}
