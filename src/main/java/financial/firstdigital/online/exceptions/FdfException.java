package financial.firstdigital.online.exceptions;

public class FdfException extends Exception {
    private String safeMessage;

    public FdfException(String message, String safeMessage) {
        super(message);
        this.safeMessage = safeMessage;
    }

    public FdfException(String message) {
        super(message);
    }

    public String getSafeMessage() {
        return safeMessage;
    }

    public void setSafeMessage(String safeMessage) {
        this.safeMessage = safeMessage;
    }
}
