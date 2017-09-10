package financial.firstdigital.online.controller;

import financial.firstdigital.online.model.Ping;
import financial.firstdigital.online.model.PingJsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    private static final Logger logger =
            LoggerFactory.getLogger(RESTController.class);


    /**
     * Gets the PingJsonResponse for the controller.
     * @return AddressRecordJsonResponse.
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    PingJsonResponse getPing() {
        logger.debug("Entering getPing()");

        Ping ping = new Ping();

        PingJsonResponse pingJsonResponse = new PingJsonResponse();
        pingJsonResponse.setResult(ping);

        pingJsonResponse.setStatus(200);

        logger.debug("Exiting getPing()");
        return (pingJsonResponse);
    }


}

