package financial.firstdigital.online;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Application class is the entry point to the main program
 *
 * @author  Andy McCall, andy.mccall@firstdigtial.financial
 * @version 0.1
 * @since   2017-09-03
 */
@SpringBootApplication
public class Application {

    private static final Logger logger =
            LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Starting SpringApplication.run()");

        SpringApplication.run(Application.class, args);

    }

}
