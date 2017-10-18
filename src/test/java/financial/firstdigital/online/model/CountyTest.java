package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The CountyTest class is the class that
 * tests the County model
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class CountyTest {

    County countyUnderTest;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {
        countyUnderTest = new County(1,"Lancashire");
    }

    /**
     * Tests County.getCountyId()
     */
    @Test
    public void getCountyId_CountyIdIsGot_Passes() throws Exception {
        Assert.assertEquals("County.getCountyId() has failed",1,countyUnderTest.getCountyId());
    }

    /**
     * Tests County.setCountyId()
     */
    @Test
    public void setCountyId_CountyIdIsSet_Passes() throws Exception {
        countyUnderTest.setCountyId(2);
        Assert.assertEquals("County.getCountyId() has failed",2,countyUnderTest.getCountyId());
    }

    /**
     * Tests County.setCountyName()
     */
    @Test
    public void getCountyName_CountyNameIsGot_Passes() throws Exception {
        Assert.assertEquals("County.getCountyName() has failed","Lancashire",countyUnderTest.getCountyName());
    }

    /**
     * Tests County.setCountyName()
     */
    @Test
    public void setCountyName_CountyNameIsSet_Passes() throws Exception {
        countyUnderTest.setCountyName("Yorkshire");
        Assert.assertEquals("County.getCountyName() has failed","Yorkshire",countyUnderTest.getCountyName());
    }

    /**
     * Tests County.toString()
     */
    @Test
    public void toString_StringReturned_Passes() throws Exception {
        Assert.assertEquals("County.toString() has failed,", "County{countyId=1, countyName='Lancashire'}", countyUnderTest.toString());

    }

}