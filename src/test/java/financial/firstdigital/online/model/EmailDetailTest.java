package financial.firstdigital.online.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The EmailDetailTest class is a test class that
 * tests the EmailDetail class.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class EmailDetailTest {

    EmailDetail emailDetailUnderTest;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {
        emailDetailUnderTest = new EmailDetail(1L,
                "test@firstdigital.financial",
                ContactType.PRIMARY,
                true,
                "7f7b353f-aac5-48d2-8f3a-8bc7e666c42c");
    }

    /**
     * Tests EmailDetail.getEmailId()
     */
    @Test
    public void getEmailId_EmailIdIsGot_Passes() throws Exception {
        Assert.assertEquals(emailDetailUnderTest.getEmailId(),Long.valueOf(1L));
    }

    /**
     * Tests EmailDetail.getEmailAddress()
     */
    @Test
    public void getEmailAddress_EmailAddressIsGot_Passes() throws Exception {
        Assert.assertEquals(emailDetailUnderTest.getEmailAddress(),"test@firstdigital.financial");
    }

    /**
     * Tests EmailDetail.setEmailAddress()
     */
    @Test
    public void setEmailAddress_EmailAddressIsSet_Passes() throws Exception {
        emailDetailUnderTest.setEmailAddress("second.test@firstdigital.financial");
        Assert.assertEquals(emailDetailUnderTest.getEmailAddress(),"second.test@firstdigital.financial");
    }

    /**
     * Tests EmailDetail.getEmailType()
     */
    @Test
    public void getEmailType_EmailTypeIsGot_Passes() throws Exception {
        Assert.assertEquals(emailDetailUnderTest.getEmailType(), ContactType.PRIMARY);
    }

    /**
     * Tests EmailDetail.setEmailType()
     */
    @Test
    public void setEmailType_EmailTypeIsSet_Passes() throws Exception {
        emailDetailUnderTest.setEmailType(ContactType.SECONDARY);
        Assert.assertEquals(emailDetailUnderTest.getEmailType(), ContactType.SECONDARY);
    }

    /**
     * Tests EmailDetail.getVerified()
     */
    @Test
    public void getVerified_VerifiedIsGot_Passes() throws Exception {
        Assert.assertEquals(emailDetailUnderTest.getVerified(),true);
    }

    /**
     * Tests EmailDetail.setVerified()
     */
    @Test
    public void setVerified_VerifiedIsSet_Passes() throws Exception {
        emailDetailUnderTest.setVerified(false);
        Assert.assertEquals(emailDetailUnderTest.getVerified(),false);
    }

    /**
     * Tests EmailDetail.toString()
     */
    @Test
    public void toString_StringReturned_Passes() throws Exception {
        Assert.assertEquals("EmailDetail{emailId=1, emailAddress='test@firstdigital.financial', contactType=PRIMARY, isVerified=true, verificationKey='7f7b353f-aac5-48d2-8f3a-8bc7e666c42c'}", emailDetailUnderTest.toString());
    }

}