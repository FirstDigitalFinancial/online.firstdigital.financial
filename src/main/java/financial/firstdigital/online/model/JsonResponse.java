package financial.firstdigital.online.model;

/**
 * The JsonResponse class is a superclass that contains all the common details
 * about an JsonResponse.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-10
 */
public class JsonResponse {

    private int status;
    private String message;

    /**
     * JsonResponse constructor.
     */
    public JsonResponse() {

    }

    /**
     * JsonResponse constructor with parameters.
     */
    public JsonResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * Gets the status of the JsonResponse.
     * @return int containing status.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the status of the JsonResponse.
     * @param status containing status of JsonResponse
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gets the message of the JsonResponse.
     * @return String containing message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message of the JsonResponse.
     * @param message containing message of JsonResponse, must not be empty and
     *               cannot contain only whitespace.
     * @exception IllegalArgumentException if error is empty or contains only whitespace.
     */
    public void setMessage(String message) {

        // Check if the error only contains whitespace or is empty
        // everything else is valid
        if (message.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid error: " + message);
        }
        this.message = message;

    }

}
