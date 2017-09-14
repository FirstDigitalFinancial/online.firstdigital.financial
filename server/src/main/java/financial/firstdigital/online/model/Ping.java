package financial.firstdigital.online.model;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Ping class.
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-10
 */
public class Ping {

    private String response="pong";
    private String date;
    private String time;
    private final Clock clock;

    public String getResponse() {
        return response;
    }
    public String getDate() { return date; }
    public String getTime() { return time; }

    public Ping(Clock clock) {

        this.clock = clock;

        LocalDateTime localDateTime = LocalDateTime.now(clock);
        DateTimeFormatter dtf;

        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date = dtf.format(localDateTime).toString();

        dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        time = dtf.format(localDateTime).toString();
    }

    @Override
    public String toString() {
        return "Ping{" +
                "response=" + response +
                ", date=" + date +
                ", time=" + time +
                '}';
    }

}
