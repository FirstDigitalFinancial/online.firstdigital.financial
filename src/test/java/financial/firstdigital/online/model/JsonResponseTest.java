package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The JsonResponseTest class is a test class that
 * tests the JsonResponse class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class JsonResponseTest {

    JsonResponse jsonResponseUnderTest;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {
        jsonResponseUnderTest = new JsonResponse(200, "Test message");
    }

    /**
     * Tests JsonResponse.getStatus()
     */
    @Test
    public void getStatus_StatusGot_Passes() throws Exception {
        Assert.assertEquals(jsonResponseUnderTest.getStatus(), 200);
    }

    /**
     * Tests JsonResponse.setStatus()
     */
    @Test
    public void setStatus_StatusIsSet_Passes() throws Exception {
        jsonResponseUnderTest.setStatus(300);
        Assert.assertEquals(jsonResponseUnderTest.getStatus(), 300);
    }

    /**
     * Tests JsonResponse.getMessage()
     */
    @Test
    public void getMessage_MessageIsGot_Passes() throws Exception {
        Assert.assertEquals(jsonResponseUnderTest.getMessage(), "Test message");
    }

    /**
     * Tests JsonResponse.setMessage()
     */
    @Test
    public void setMessage() throws Exception {
        jsonResponseUnderTest.setMessage("Second test message");
        Assert.assertEquals(jsonResponseUnderTest.getMessage(), "Second test message");
    }

}