package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The GenderTest class is a test class that
 * tests the values of the ENUM Gender.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class GenderTest {

    /**
     * Tests GenderTest.UNKNOWN.getDisplayName()
     */
    @Test
    public void getDisplayName_IsUnknown_Passes() throws Exception {
        Assert.assertEquals(Gender.UNKNOWN.getDisplayName(),"U");
    }

    /**
     * Tests GenderTest.MALE.getDisplayName()
     */
    @Test
    public void getDisplayName_IsMale_Passes() throws Exception {
        Assert.assertEquals(Gender.MALE.getDisplayName(),"M");
    }

    /**
     * Tests GenderTest.FEMALE.getDisplayName()
     */
    @Test
    public void getDisplayName_IsFemale_Passes() throws Exception {
        Assert.assertEquals(Gender.FEMALE.getDisplayName(),"F");
    }

    /**
     * Tests GenderTest.NOT_APPLICABLE.getDisplayName()
     */
    @Test
    public void getDisplayName_IsNotApplicable_Passes() throws Exception {
        Assert.assertEquals(Gender.NOT_APPLICABLE.getDisplayName(),"N");
    }

    /**
     * Tests GenderTest.WITHHELD.getDisplayName()
     */
    @Test
    public void getDisplayName_IsWithheld_Passes() throws Exception {
        Assert.assertEquals(Gender.WITHHELD.getDisplayName(),"W");
    }

}