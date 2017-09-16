package financial.firstdigital.online.controller;

import financial.firstdigital.online.model.*;
import financial.firstdigital.online.service.AccountDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.Instant;

/**
 * The RESTController is the main controller where all the APIs are
 * called from.
 *
 * @author  Andy McCall
 * @version 0.3
 * @since   2017-09-10
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class RESTController {

    private Clock clock = Clock.systemDefaultZone();;

    private static final Logger logger =
            LoggerFactory.getLogger(RESTController.class);

    AccountDetailService accountDetailService;

    @Autowired
    public void setAccountDetailService(AccountDetailService accountDetailService) {
        this.accountDetailService = accountDetailService;
    }

    /**
     * Gets the PingJsonResponse for the controller.
     * @return AddressRecordJsonResponse.
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
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

    @RequestMapping(value = "/account/{accountNumber}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    AccountDetailJsonReponse getAccountDetail(@PathVariable Long accountNumber) {

        logger.debug("Entering getAccountDetail");

        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setStatus(AccountStatus.OPEN);
        accountDetail.setCurrency(Currency.ETHEREUM);
        accountDetail.setAddress("0xC38Df9faA80F068675096f0a6da964862E90892B");
        accountDetail.setAccountNumber(accountNumber);
        accountDetailService.saveAccountDetail(accountDetail);

        AccountDetailJsonReponse accountDetailJsonReponse = new AccountDetailJsonReponse();
        accountDetailJsonReponse.setAccountDetail(accountDetailService.findDistinctByAccountNumberEquals(accountNumber));

        return accountDetailJsonReponse;
    }



}

