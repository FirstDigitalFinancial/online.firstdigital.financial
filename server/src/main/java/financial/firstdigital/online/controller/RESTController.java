package financial.firstdigital.online.controller;

import financial.firstdigital.online.model.Ping;
import financial.firstdigital.online.model.PingJsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.Instant;

/**
 * The RESTController is the main controller where all the APIs are
 * called from.
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-10
 */
@RestController
@RequestMapping("/")
public class RESTController {

    private Clock clock = Clock.systemDefaultZone();;

    private static final Logger logger =
            LoggerFactory.getLogger(RESTController.class);

    /**
     * Gets the PingJsonResponse for the controller.
     * @return AddressRecordJsonResponse.
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    PingJsonResponse getPing() {

        logger.debug("Entering getPing()");

        Ping ping = new Ping(clock);

        PingJsonResponse pingJsonResponse = new PingJsonResponse();
        pingJsonResponse.setResult(ping);

        pingJsonResponse.setStatus(200);

        logger.debug("Exiting getPing()");
        return (pingJsonResponse);
    }


}

