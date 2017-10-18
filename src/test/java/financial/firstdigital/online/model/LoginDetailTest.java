package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The LoginDetailTest class is a test class that
 * tests the LoginDetail class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class LoginDetailTest {

    LoginDetail loginDetailUnderTest;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {
        loginDetailUnderTest = new LoginDetail(1L,
                                                "andymccall",
                                                "HjjUii8$aa2",
                                                1234,
                                                0,
                                                true );
    }

    /**
     * Tests LoginDetail.getLoginId()
     */
    @Test
    public void getLoginId_LoginIdIsGot_Passes() throws Exception {
        Assert.assertEquals("LoginDetail.getLoginId() has failed",
                Long.valueOf(1), loginDetailUnderTest.getLoginId());
    }

    /**
     * Tests LoginDetail.getUserName()
     */
    @Test
    public void getUserName_UserNameIsGot_Passes() throws Exception {
        Assert.assertEquals("LoginDetail.getUserName() has failed",
                "andymccall", loginDetailUnderTest.getUserName());
    }

    /**
     * Tests LoginDetail.setUserName()
     */
    @Test
    public void setUserName_UserNameIsSet_Passes() throws Exception {
        loginDetailUnderTest.setUserName("testuser");
        Assert.assertEquals("LoginDetail.setUserName() has failed",
                "testuser", loginDetailUnderTest.getUserName());    }

    /**
     * Tests LoginDetail.getPassword()
     */
    @Test
    public void getPassword_PasswordIsGot_Passes() throws Exception {
        Assert.assertEquals("LoginDetail.getPassword() has failed",
                "HjjUii8$aa2", loginDetailUnderTest.getPassword());
    }

    /**
     * Tests LoginDetail.setPassword()
     */
    @Test
    public void setPassword_PasswordIsSet_Passes() throws Exception {
        loginDetailUnderTest.setPassword("DfD$32!00");
        Assert.assertEquals("LoginDetail.setPassword() has failed",
                "DfD$32!00", loginDetailUnderTest.getPassword());
    }

    /**
     * Tests LoginDetail.getMasterPin()
     */
    @Test
    public void getMasterPin_MasterPinIsGot_Passes() throws Exception {
        Assert.assertEquals("LoginDetail.getMasterPin() has failed",
                1234, loginDetailUnderTest.getMasterPin());
    }

    /**
     * Tests LoginDetail.setMasterPin()
     */
    @Test
    public void setMasterPin_MasterPinIsSet_Passes() throws Exception {
        loginDetailUnderTest.setMasterPin(5678);
        Assert.assertEquals("LoginDetail.setMasterPin() has failed",
                5678, loginDetailUnderTest.getMasterPin());
    }

    /**
     * Tests LoginDetail.toString()
     */
    @Test
    public void toString_StringReturned_Passes() throws Exception {
        Assert.assertEquals("LoginDetail.toString() has failed",
                "LoginDetail{loginId=1, userName='andymccall', password='HjjUii8$aa2', masterPin=1234, loginAttempt=0, accountStatus=true}",
                loginDetailUnderTest.toString());
    }

}