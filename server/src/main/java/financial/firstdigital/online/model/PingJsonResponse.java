package financial.firstdigital.online.model;

/**
 * The PingJsonResponse class.
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-10
 */
public class PingJsonResponse extends JsonResponse {

    private Ping ping;

    public Ping getResult() {
        return ping;
    }

    public void setResult(Ping result) {
        this.ping = result;
    }

    @Override
    public String toString() {
        return "PingJsonResponse{" +
                "status=" + super.getStatus() +
                ", result='" + ping + '\'' +
                ", error='" + super.getError() +
                '}';
    }
}
