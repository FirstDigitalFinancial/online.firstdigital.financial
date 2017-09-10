package financial.firstdigital.online.model;

/**
 * The PingJsonResponse class.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-10
 */
public class PingJsonResponse extends JsonResponse {

    private Ping result;

    public Ping getResult() {
        return result;
    }

    public void setResult(Ping result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PingJsonResponse{" +
                "status=" + super.getStatus() +
                ", result='" + result + '\'' +
                ", error='" + super.getError() +
                '}';
    }
}
