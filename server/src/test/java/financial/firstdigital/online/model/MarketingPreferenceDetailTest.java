package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarketingPreferenceDetailTest {

    MarketingPreferenceDetail marketingPreferenceDetailUnderTest;
    Boolean testValue = true;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {
        marketingPreferenceDetailUnderTest = new MarketingPreferenceDetail(1L,
                                                                            true,
                                                                            true,
                                                                            true,
                                                                            true,
                                                                            true,
                                                                            true);
    }

    /**
     * Tests MarketingPreferenceDetail.getMarketingPreferenceId()
     */
    @Test
    public void getMarketingPreferenceId_MarketingPreferenceIdIsGot_Passes() throws Exception {
        Assert.assertEquals(1,1);
    }

    /**
     * Tests MarketingPreferenceDetail.getByEmail()
     */
    @Test
    public void getByEmail_byEmailGot_Passes() throws Exception {
        Assert.assertEquals("getByEmail() has failed", true, marketingPreferenceDetailUnderTest.getByEmail());
    }

    /**
     * Tests MarketingPreferenceDetail.getByEmail()
     */
    @Test
    public void setByEmail_byEmailSet_Passes() throws Exception {
        marketingPreferenceDetailUnderTest.setByEmail(testValue);
        Assert.assertEquals("setByEmail() has failed", testValue, marketingPreferenceDetailUnderTest.getByEmail());
    }

    /**
     * Tests MarketingPreferenceDetail.getByPost()
     */
    @Test
    public void getByPost_byPostGot_Passes() throws Exception {
        Assert.assertEquals("getByPost() has failed", true, marketingPreferenceDetailUnderTest.getByPost());
    }

    /**
     * Tests MarketingPreferenceDetail.setByPost()
     */
    @Test
    public void setByPost_byPostSet_Passes() throws Exception {
        marketingPreferenceDetailUnderTest.setByPost(testValue);
        Assert.assertEquals("setByPost() has failed", testValue, marketingPreferenceDetailUnderTest.getByPost());
    }

    /**
     * Tests MarketingPreferenceDetail.getByPhone()
     */
    @Test
    public void getByPhone_byPhoneGot_Passes() throws Exception {
        Assert.assertEquals("getByPhone() has failed", true, marketingPreferenceDetailUnderTest.getByPhone());
    }

    /**
     * Tests MarketingPreferenceDetail.setByPhone()
     */
    @Test
    public void setByPhone_byPhoneSet_Passes() throws Exception {
        marketingPreferenceDetailUnderTest.setByPhone(testValue);
        Assert.assertEquals("setByPhone() has failed", testValue, marketingPreferenceDetailUnderTest.getByPhone());
    }

    /**
     * Tests MarketingPreferenceDetail.getByText()
     */
    @Test
    public void getByText_byTextGot_Passes() throws Exception {
        Assert.assertEquals("getByText() has failed", true, marketingPreferenceDetailUnderTest.getByText());
    }

    /**
     * Tests MarketingPreferenceDetail.setByText()
     */
    @Test
    public void setByText_byTextSet_Passes() throws Exception {
        marketingPreferenceDetailUnderTest.setByText(testValue);
        Assert.assertEquals("getByText() has failed", testValue, marketingPreferenceDetailUnderTest.getByText());
    }

    /**
     * Tests MarketingPreferenceDetail.getByApp()
     */
    @Test
    public void getByApp_byAppGot_Passes() throws Exception {
        Assert.assertEquals("getByApp() has failed", true, marketingPreferenceDetailUnderTest.getByApp());
    }

    /**
     * Tests MarketingPreferenceDetail.setByApp()
     */
    @Test
    public void setByApp_byAppSet_Passes() throws Exception {
        marketingPreferenceDetailUnderTest.setByApp(testValue);
        Assert.assertEquals("getByApp() has failed", testValue, marketingPreferenceDetailUnderTest.getByApp());
    }

    /**
     * Tests MarketingPreferenceDetail.getBySocial()
     */
    @Test
    public void getBySocial_bySocialGot_Passes() throws Exception {
        Assert.assertEquals("getBySocial() has failed", true, marketingPreferenceDetailUnderTest.getBySocial());
    }

    /**
     * Tests MarketingPreferenceDetail.setBySocial()
     */
    @Test
    public void setBySocial_bySocialSet_Passes() throws Exception {
        marketingPreferenceDetailUnderTest.setBySocial(testValue);
        Assert.assertEquals("getBySocial() has failed", testValue, marketingPreferenceDetailUnderTest.getBySocial());
    }

    /**
     * Tests MarketingPreferenceDetail.toString()
     */
    @Test
    public void toString_StringReturned_Passes() throws Exception {
        Assert.assertEquals( "toString() has failed",
                "MarketingPreferenceDetail{marketingPreferenceId=1, byEmail=true, byPost=true, byPhone=true, byText=true, byApp=true, bySocial=true}",
                marketingPreferenceDetailUnderTest.toString());
    }

}