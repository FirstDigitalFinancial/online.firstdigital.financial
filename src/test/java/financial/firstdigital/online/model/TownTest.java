package financial.firstdigital.online.model;

import financial.firstdigital.online.repository.TownRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * The TownTest class is a test class that tests Town.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-15
 */
public class TownTest {

    Town townUnderTest;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {
        townUnderTest = new Town(1, "Blackpool");
        townUnderTest.setTownId(1);
    }

    /**
     * Tests Town.getTownId()
     */
    @Test
    public void getTownId_TownIdIsGot_Passes() throws Exception {
        Assert.assertEquals( "getTownId() has failed",
                1, townUnderTest.getTownId());
    }

    /**
     * Tests Town.setTownId()
     */
    @Test
    public void setTownId_TownIdIsSet_Passes() throws Exception {
        townUnderTest.setTownId(2);
        Assert.assertEquals( "setTownId() has failed",
                2, townUnderTest.getTownId());
    }

    /**
     * Tests Town.getTownName()
     */
    @Test
    public void getTown_TownIsGot_Passes() throws Exception {
        Assert.assertEquals("Blackpool", townUnderTest.getTownName());
    }

    /**
     * Tests Town.toString()
     */
    @Test
    public void toString_StringReturned_Passes() throws Exception {
        Assert.assertEquals( "toString() has failed",
                "town{townId=1, townName='Blackpool'}", townUnderTest.toString());
    }

}