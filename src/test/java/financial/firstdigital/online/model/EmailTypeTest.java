package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The EmailTypeTest class is a test class that
 * tests the values of the ENUM EmailType.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class EmailTypeTest {

    /**
     * Tests EmailType.PRIMARY.getDisplayName()
     */
    @Test
    public void getDisplayName_IsPrimary_Passes() throws Exception {
        Assert.assertEquals(EmailType.PRIMARY.getDisplayName(),"Primary");
    }

    /**
     * Tests EmailType.SECONDARY.getDisplayName()
     */
    @Test
    public void getDisplayName_IsSecondary_Passes() throws Exception {
        Assert.assertEquals(EmailType.SECONDARY.getDisplayName(),"Secondary");
    }

}