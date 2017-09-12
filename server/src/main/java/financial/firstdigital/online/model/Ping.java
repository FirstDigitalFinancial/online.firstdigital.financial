package financial.firstdigital.online.model;

/**
 * The Ping class.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-10
 */
public class Ping {

    private String response="pong";

    public String getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "Ping{" +
                "response=" + response +
                '}';
    }

}
