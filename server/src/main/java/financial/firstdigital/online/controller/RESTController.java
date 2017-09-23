package financial.firstdigital.online.controller;

import financial.firstdigital.online.model.*;
import financial.firstdigital.online.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Clock;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static javax.servlet.http.HttpServletResponse.SC_CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN;

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
    TransactionDetailService transactionDetailService;
    CustomerDetailService customerDetailService;
    AddressDetailService addressDetailService;
    CountyService countyService;
    TownService townService;
    TitleService titleService;
    MarketingPreferenceService marketingPreferenceService;

    @Autowired
    public void setAccountDetailService(AccountDetailService accountDetailService) {
        this.accountDetailService = accountDetailService;
    }

    @Autowired
    public void setTransactionDetailService(TransactionDetailService transactionDetailService) {
        this.transactionDetailService = transactionDetailService;
    }

    @Autowired
    public void setCustomerDetailService(CustomerDetailService customerDetailService) {
        this.customerDetailService = customerDetailService;
    }

    @Autowired
    public void setAddressDetailService(AddressDetailService addressDetailService) {
        this.addressDetailService = addressDetailService;
    }

    @Autowired
    public void setCountyService(CountyService countyService) {
        this.countyService = countyService;
    }

    @Autowired
    public void setTownService(TownService townService) {
        this.townService = townService;
    }

    @Autowired
    public void setTitleService(TitleService titleService) { this.titleService = titleService; }

    @Autowired
    public void setMarketingPreferenceService(MarketingPreferenceService marketingPreferenceService) {
        this.marketingPreferenceService = marketingPreferenceService;
    }

    /**
     * Gets the Ping json for the controller.
     * @return GenericJsonResponse.
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    GenericJsonResponse getPing() {

        logger.debug("Entering getPing()");

        Ping ping = new Ping(clock);

        GenericJsonResponse<Ping> pingJsonResponse = new GenericJsonResponse<Ping>();

        pingJsonResponse.setResult(Arrays.asList(ping));

        pingJsonResponse.setStatus(200);

        logger.debug("Exiting getPing()");
        return (pingJsonResponse);
    }

    @RequestMapping(value = "/account/{accountId}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    GenericJsonResponse getAccountDetail(@PathVariable Long accountId) {

        logger.debug("Entering getAccountDetail");

        GenericJsonResponse<AccountDetail> accountDetailJsonReponse = new GenericJsonResponse<AccountDetail>();
        accountDetailJsonReponse.setResult(Arrays.asList(accountDetailService.findDistinctByAccountIdEquals(accountId)));

        return accountDetailJsonReponse;
    }

    @RequestMapping(value = "/transaction/{transactionId}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    GenericJsonResponse getTransactionDetail(@PathVariable Long transactionId) {

        logger.debug("Entering getTransactionDetail");

        TransactionDetail transactionDetail = new TransactionDetail();

        BigDecimal transactionValue = new BigDecimal(100.00);
        BigDecimal endOfTransactionBalance = new BigDecimal(100.00);

        transactionDetail.setTransactionType(TransactionType.DEPOST);
        transactionDetail.setTransactionValue(transactionValue);
        transactionDetail.setEndOfTransactionBalance(endOfTransactionBalance);
        transactionDetailService.saveTransactionDetail(transactionDetail);

        GenericJsonResponse<TransactionDetail> transactionDetailJsonResponse = new GenericJsonResponse<TransactionDetail>();
        transactionDetailJsonResponse.setResult(Arrays.asList(transactionDetailService.findDistinctByTransactionIdEquals(transactionId)));

        return transactionDetailJsonResponse;

    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    GenericJsonResponse getCustomerDetail(@PathVariable Long customerId) {

        logger.debug("Entering getTransactionDetail");

        Town town = townService.findDistinctByTownIdEquals(685);
        County county = countyService.findDistinctByCountyIdEquals(27);

        AddressDetail addressDetail = new AddressDetail();
        addressDetail.setHouseNumber(95);
        addressDetail.setHouseName("Torrington");
        addressDetail.setStreetName("Newton Drive");
        addressDetail.setTown(town);
        addressDetail.setCounty(county);
        addressDetail.setPostCode("FY3 8LX");
        addressDetailService.saveAddressDetail(addressDetail);

        Title title = titleService.findDistinctByTitleIdEquals(1);

        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setAddressDetail(addressDetail);
        customerDetail.setTitle(title);
        customerDetail.setFirstName("Andy");
        customerDetail.setLastName("McCall");
        customerDetail.setOtherNames("Edward");
        customerDetail.setGender(Gender.MALE);
        customerDetail.setEmailAddress("andy.mccall@gmail.com");

        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setStatus(AccountStatus.OPEN);
        accountDetail.setCurrency(Currency.ETHEREUM);
        accountDetail.setAddress("0xC38Df9faA80F068675096f0a6da964862E90892B");

        AccountDetail accountDetail2 = new AccountDetail();
        accountDetail2.setStatus(AccountStatus.OPEN);
        accountDetail2.setCurrency(Currency.BITCOIN_CORE);
        accountDetail2.setAddress("1DexwwKk4UJQKtjJ7rz4h8YbHtJeGLmxEx");

        Set<AccountDetail> accountDetailSet = new HashSet<AccountDetail>();
        accountDetailSet.add(accountDetail);
        accountDetailSet.add(accountDetail2);

        customerDetail.setAccountDetailSet(accountDetailSet);

        MarketingPreferenceDetail marketingPreferenceDetail = new MarketingPreferenceDetail();
        marketingPreferenceDetail.setByApp(false);
        marketingPreferenceDetail.setByEmail(true);
        marketingPreferenceDetail.setByPhone(false);
        marketingPreferenceDetail.setByPost(true);
        marketingPreferenceDetail.setBySocial(true);
        marketingPreferenceDetail.setByText(false);
        marketingPreferenceService.saveMarketingPreferenceDetail(marketingPreferenceDetail);

        customerDetail.setMarketingPreferenceDetail(marketingPreferenceDetail);

        customerDetailService.saveCustomerDetail(customerDetail);

        GenericJsonResponse<CustomerDetail> customerDetailJsonResponse = new GenericJsonResponse<CustomerDetail>();
        customerDetailJsonResponse.setResult(Arrays.asList(customerDetailService.findDistinctByCustomerIdEquals(customerId)));

        return customerDetailJsonResponse;

    }

    @RequestMapping(value = "/address/", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<GenericJsonResponse> setAddressDetail(@RequestBody AddressDetail addressDetail) {

        logger.debug("Entering setAddressDetail");

        Town newTown = townService.findDistinctByTownNameEquals(addressDetail.getTown().getTownName());
        County newCounty = countyService.findDistinctByCountyNameEquals(addressDetail.getCounty().getCountyName());

        AddressDetail newAddressDetail1 = addressDetail;

        newAddressDetail1.setTown(newTown);
        newAddressDetail1.setCounty(newCounty);

        if (addressDetail != null ) {
            addressDetailService.saveAddressDetail(newAddressDetail1);
        }

        GenericJsonResponse<AddressDetail> addressDetailJsonReponse = new GenericJsonResponse<AddressDetail>();
        addressDetailJsonReponse.setStatus(SC_CREATED);
        addressDetailJsonReponse.setMessage("OK");
        addressDetailJsonReponse.setResult(Arrays.asList(
                addressDetailService.findDistinctByHouseNumberEqualsAndPostCodeEquals(
                        addressDetail.getHouseNumber(),
                        addressDetail.getPostCode())));

        ResponseEntity<GenericJsonResponse> responseEntity = new ResponseEntity<GenericJsonResponse>(addressDetailJsonReponse, HttpStatus.CREATED);

        return responseEntity;

    }

    @RequestMapping(value = "/address/{addressId}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    GenericJsonResponse getAddressDetail(@PathVariable Long addressId) {

        logger.debug("Entering getAddressDetail");

        GenericJsonResponse<AddressDetail> addressDetailJsonReponse = new GenericJsonResponse<AddressDetail>();
        addressDetailJsonReponse.setResult(Arrays.asList(addressDetailService.findDistinctByAddressIdEquals(addressId)));

        return addressDetailJsonReponse;
    }

    @RequestMapping(value = "/marketing/", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<GenericJsonResponse> setMarketingPreferenceDetail(@RequestBody MarketingPreferenceDetail marketingPreferenceDetail) {

        logger.debug("Entering setMarketingPreferenceDetail");

        if (marketingPreferenceDetail != null ) {
            marketingPreferenceService.saveMarketingPreferenceDetail(marketingPreferenceDetail);
        }

        GenericJsonResponse<MarketingPreferenceDetail> marketingPreferenceDetailJsonReponse = new GenericJsonResponse<MarketingPreferenceDetail>();
        marketingPreferenceDetailJsonReponse.setStatus(SC_CREATED);
        marketingPreferenceDetailJsonReponse.setMessage("OK");
        marketingPreferenceDetailJsonReponse.setResult(Arrays.asList(
                marketingPreferenceService.findDistinctByMarketingPreferenceIdEquals(
                        marketingPreferenceDetail.getMarketingPreferenceId())));

        ResponseEntity<GenericJsonResponse> responseEntity = new ResponseEntity<GenericJsonResponse>(marketingPreferenceDetailJsonReponse, HttpStatus.CREATED);

        return responseEntity;

    }

    @RequestMapping(value = "/marketing/{marketingPreferenceId}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    GenericJsonResponse getMarketingPreferenceDetail(@PathVariable Long marketingPreferenceId) {

        logger.debug("Entering getMarketingPreferenceDetail");

        GenericJsonResponse<MarketingPreferenceDetail> marketingPreferenceDetailJsonReponse = new GenericJsonResponse<MarketingPreferenceDetail>();
        marketingPreferenceDetailJsonReponse.setResult(Arrays.asList(marketingPreferenceService.findDistinctByMarketingPreferenceIdEquals(marketingPreferenceId)));

        return marketingPreferenceDetailJsonReponse;
    }

}

