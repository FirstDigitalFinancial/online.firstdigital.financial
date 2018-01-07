package financial.firstdigital.online.exceptions;

/**
 * Created by Andrew on 03/01/2018.
 */
public class RecaptchaException extends FdfException {
    public RecaptchaException(String message, String safeMessage) {
        super(message, safeMessage);
    }
}
