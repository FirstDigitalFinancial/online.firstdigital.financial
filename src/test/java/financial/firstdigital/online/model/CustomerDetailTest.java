package financial.firstdigital.online.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * The CustomerDetailTest class is a test class
 * that tests the CustomerDetail class.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class CustomerDetailTest {

    CustomerDetail customerDetailUnderTest;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {

        Title title = new Title(1,"Mr");

        Town town = new Town(1,"Blackpool");
        County county = new County(1,"Lancashire");

        AddressDetail addressDetail = new AddressDetail(Long.valueOf(1),
                                                        95,
                                                        "Torrington",
                                                        "Newton Drive",
                                                        town,
                                                        county,
                                                        "FY3 8LX");

        Set<AddressDetail> addressDetailSet = new HashSet<AddressDetail>();
        addressDetailSet.add(addressDetail);

        EmailDetail emailDetail = new EmailDetail();
        emailDetail.setEmailAddress("test@firstdigital.financial");
        emailDetail.setEmailType(EmailType.PRIMARY);
        emailDetail.setVerified(true);
        emailDetail.setVerificationKey("7f7b353f-aac5-48d2-8f3a-8bc7e666c42c");

        Set<EmailDetail> emailDetailSet = new HashSet<EmailDetail>();
        emailDetailSet.add(emailDetail);

        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setStatus(AccountStatus.OPEN);
        accountDetail.setCurrency(Currency.BITCOIN_CORE);
        accountDetail.setAddress("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");

        Set<AccountDetail> accountDetailSet = new HashSet<AccountDetail>();
        accountDetailSet.add(accountDetail);

        MarketingPreferenceDetail marketingPreferenceDetail = new MarketingPreferenceDetail();
        marketingPreferenceDetail.setByApp(false);
        marketingPreferenceDetail.setByEmail(true);
        marketingPreferenceDetail.setByPhone(false);
        marketingPreferenceDetail.setByPost(true);
        marketingPreferenceDetail.setBySocial(true);
        marketingPreferenceDetail.setByText(false);

        customerDetailUnderTest = new CustomerDetail(1L, title, "Andy", "McCall",
                "Edward", Gender.MALE, addressDetailSet, emailDetailSet, accountDetailSet,
                marketingPreferenceDetail);
    }

    /**
     * Tests CustomerDetail.getCustomerId()
     */
    @Test
    public void getCustomerId_CustomerIdIsGot_Passes() throws Exception {
        Assert.assertEquals(Long.valueOf(1), customerDetailUnderTest.getCustomerId());
    }

    /**
     * Tests CustomerDetail.getTitle()
     */
    @Test
    public void getTitle_TitleIsGot_Passes() throws Exception {
        Assert.assertEquals("Mr", customerDetailUnderTest.getTitle().getTitle());
    }

    /**
     * Tests CustomerDetail.setTitle()
     */
    @Test
    public void setTitle_TitleIsSet_Passes() throws Exception {
        Title title = new Title(2,"Mrs");
        customerDetailUnderTest.setTitle(title);
        Assert.assertEquals("Mrs", customerDetailUnderTest.getTitle().getTitle());
    }

    /**
     * Tests CustomerDetail.getFirstName()
     */
    @Test
    public void getFirstName_FirstNameIsGot_Passes() throws Exception {
        Assert.assertEquals("Andy", customerDetailUnderTest.getFirstName());
    }

    /**
     * Tests CustomerDetail.setFirstName()
     */
    @Test
    public void setFirstName_FirstNameIsSet_Passes() throws Exception {
        customerDetailUnderTest.setFirstName("Andrew");
        Assert.assertEquals("Andrew", customerDetailUnderTest.getFirstName());
    }

    /**
     * Tests CustomerDetail.getLastName()
     */
    @Test
    public void getLastName_LastNameGot_Passes() throws Exception {
        Assert.assertEquals("McCall", customerDetailUnderTest.getLastName());
    }

    /**
     * Tests CustomerDetail.setLastName()
     */
    @Test
    public void setLastName_LastNameSet_Passes() throws Exception {
        customerDetailUnderTest.setLastName("Smith");
        Assert.assertEquals("Smith", customerDetailUnderTest.getLastName());
    }

    /**
     * Tests CustomerDetail.getOtherNames()
     */
    @Test
    public void getOtherNames_OtherNamesGot_Passes() throws Exception {
        Assert.assertEquals("Edward", customerDetailUnderTest.getOtherNames());
    }

    /**
     * Tests CustomerDetail.setOtherNames()
     */
    @Test
    public void setOtherNames_OtherNamesGot_Passes() throws Exception {
        customerDetailUnderTest.setOtherNames("James");
        Assert.assertEquals("James", customerDetailUnderTest.getOtherNames());
    }

    /**
     * Tests CustomerDetail.getGender()
     */
    @Test
    public void getGender_GenderIsGot_Passes() throws Exception {
        Assert.assertEquals("M", customerDetailUnderTest.getGender().getDisplayName());
    }

    /**
     * Tests CustomerDetail.setGender()
     */
    @Test
    public void setGender_GenderIsSet_Passes() throws Exception {
        customerDetailUnderTest.setGender(Gender.UNKNOWN);
        Assert.assertEquals("U", customerDetailUnderTest.getGender().getDisplayName());
    }

    /**
     * Tests CustomerDetail.getAddressDetailSet()
     */
    @Test
    public void getAddressDetailSet_AddressDetailSetIsGot_Passes() throws Exception {
        List<AddressDetail> customerDetailList = new ArrayList<AddressDetail>();
        customerDetailList.addAll(customerDetailUnderTest.getAddressDetailSet());
        Assert.assertEquals(customerDetailList.size(), 1);
        Assert.assertEquals("Blackpool", customerDetailList.get(0).getTown().getTownName());
    }

    @Test
    public void setAddressDetailSet_AddressDetailSetIsSet_Passes() throws Exception {
        Town town = new Town(1,"Preston");
        County county = new County(1,"Lancashire");

        AddressDetail addressDetail = new AddressDetail();
        addressDetail.setHouseNumber(95);
        addressDetail.setHouseName("Smithy");
        addressDetail.setStreetName("Church Street");
        addressDetail.setTown(town);
        addressDetail.setCounty(county);
        addressDetail.setPostCode("PR1 1EE");

        Set<AddressDetail> addressDetailSet = new HashSet<AddressDetail>();
        addressDetailSet.add(addressDetail);

        customerDetailUnderTest.setAddressDetailSet(addressDetailSet);

        List<AddressDetail> customerDetailList = new ArrayList<AddressDetail>();
        customerDetailList.addAll(customerDetailUnderTest.getAddressDetailSet());
        Assert.assertEquals(customerDetailList.size(), 1);
        Assert.assertEquals("Preston", customerDetailList.get(0).getTown().getTownName());
    }

/*    @Test
    public void getEmailDetailSet() throws Exception {
    }

    @Test
    public void setEmailDetail() throws Exception {
    }

    @Test
    public void getAccountDetailSet() throws Exception {
    }

    @Test
    public void setAccountDetailSet() throws Exception {
    }

    @Test
    public void getMarketingPreferenceDetail() throws Exception {
    }

    @Test
    public void setMarketingPreferenceDetail() throws Exception {
    }*/

    @Test
    public void toString_StringReturned_Passes() throws Exception {
        Assert.assertEquals("CustomerDetail.toString() has failed",
                "CustomerDetail{customerId=1, title=Title{titleId=1, title='Mr'}, firstName='Andy', lastName='McCall', otherNames='Edward', gender=MALE, addressDetailSet=[AddressDetail{addressId=1, houseNumber=95, houseName='Torrington', streetName='Newton Drive', town=town{townId=1, townName='Blackpool'}, county=County{countyId=1, countyName='Lancashire'}, postCode='FY3 8LX'}], emailDetailSet='[EmailDetail{emailId=null, emailAddress='test@firstdigital.financial', emailType=PRIMARY, isVerified=true, verificationKey='7f7b353f-aac5-48d2-8f3a-8bc7e666c42c'}]', accountDetailSet=[AccountDetail{accountId=null, address='1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa', currency=BITCOIN_CORE, status=OPEN}], marketingPreferenceDetail=MarketingPreferenceDetail{marketingPreferenceId=null, byEmail=true, byPost=true, byPhone=false, byText=false, byApp=false, bySocial=true}}",
                customerDetailUnderTest.toString());
    }

}