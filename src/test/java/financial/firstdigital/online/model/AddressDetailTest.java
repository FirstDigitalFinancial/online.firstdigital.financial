package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The AddressDetailTest class is a test class
 * that tests the AddressDetail class.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class AddressDetailTest {

    AddressDetail addressDetailUnderTest;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {

        Town town = new Town(1,"Blackpool");
        County county = new County(1,"Lancashire");

        addressDetailUnderTest = new AddressDetail(Long.valueOf(1),
                95,
                "Torrington",
                "Newton Drive",
                town,
                county,
                "FY3 8LX");
    }

    /**
     * Tests AddressDetail.getAddressId()
     */
    @Test
    public void getAddressId_AddressIdIsGot_Passes() throws Exception {
        Assert.assertEquals("AddressDetail.getAddressId() has failed",
                Long.valueOf(1),addressDetailUnderTest.getAddressId());
    }

    /**
     * Tests AddressDetail.getHouseNumber()
     */
    @Test
    public void getHouseNumber_HouseNumberIsGot_Passes() throws Exception {
        Assert.assertEquals("AddressDetail.getHouseNumber() has failed",
                95,addressDetailUnderTest.getHouseNumber());
    }

    /**
     * Tests AddressDetail.setHouseNumber()
     */
    @Test
    public void setHouseNumber_HouseNumberIsSet_Passes() throws Exception {
        addressDetailUnderTest.setHouseNumber(100);
        Assert.assertEquals("AddressDetail.setHouseNumber() has failed",
                100,addressDetailUnderTest.getHouseNumber());
    }

    /**
     * Tests AddressDetail.getHouseName()
     */
    @Test
    public void getHouseName_HouseNameIsGot_Passes() throws Exception {
        Assert.assertEquals("AddressDetail.getHouseName() has failed",
                "Torrington",addressDetailUnderTest.getHouseName());
    }

    /**
     * Tests AddressDetail.setHouseName()
     */
    @Test
    public void setHouseName_HouseNameIsSet_Passes() throws Exception {
        addressDetailUnderTest.setHouseName("Broomcroft");
        Assert.assertEquals("AddressDetail.setHouseName() has failed",
                "Broomcroft",addressDetailUnderTest.getHouseName());
    }

    /**
     * Tests AddressDetail.getStreetName()
     */
    @Test
    public void getStreetName_StreetNameIsGot_Passes() throws Exception {
        Assert.assertEquals("AddressDetail.getStreetName() has failed",
                "Newton Drive",addressDetailUnderTest.getStreetName());
    }

    /**
     * Tests AddressDetail.setStreetName()
     */
    @Test
    public void setStreetName_StreetNameIsSet_Passes() throws Exception {
        addressDetailUnderTest.setStreetName("Nethway Avenue");
        Assert.assertEquals("AddressDetail.setStreetName() has failed",
                "Nethway Avenue",addressDetailUnderTest.getStreetName());
    }

    /**
     * Tests AddressDetail.getTown()
     */
    @Test
    public void getTown_TownIsGot_Passes() throws Exception {
        Assert.assertEquals("AddressDetail.getTown() has failed",
                "Blackpool",addressDetailUnderTest.getTown().getTownName());
    }

    /**
     * Tests AddressDetail.setTown()
     */
    @Test
    public void setTown_TownIsSet_Passes() throws Exception {
        Town town = new Town(1,"Preston");
        addressDetailUnderTest.setTown(town);
        Assert.assertEquals("AddressDetail.setTown() has failed",
                "Preston",addressDetailUnderTest.getTown().getTownName());
    }

    /**
     * Tests AddressDetail.getCounty()
     */
    @Test
    public void getCounty_CountyIsGot_Passes() throws Exception {
        Assert.assertEquals("AddressDetail.getTown() has failed",
                "Lancashire",addressDetailUnderTest.getCounty().getCountyName());
    }

    /**
     * Tests AddressDetail.setCounty()
     */
    @Test
    public void setCounty_CountyIsSet_Passes() throws Exception {
        County county = new County(1,"Yorkshire");
        addressDetailUnderTest.setCounty(county);
        Assert.assertEquals("AddressDetail.getTown() has failed",
                "Yorkshire",addressDetailUnderTest.getCounty().getCountyName());
    }

    /**
     * Tests AddressDetail.getPostCode()
     */
    @Test
    public void getPostCode_PostcodeIsGot_Passes() throws Exception {
        Assert.assertEquals("AddressDetail.getPostCode() has failed",
                "FY3 8LX",addressDetailUnderTest.getPostCode());
    }

    /**
     * Tests AddressDetail.setPostCode()
     */
    @Test
    public void setPostCode_PostcodeIsSet_Passes() throws Exception {
        addressDetailUnderTest.setPostCode("FY3 8JU");
        Assert.assertEquals("AddressDetail.setPostCode() has failed",
                "FY3 8JU",addressDetailUnderTest.getPostCode());
    }

    /**
     * Tests AddressDetail.toString()
     */
    @Test
    public void toString_StringReturned_Passes() throws Exception {
        Assert.assertEquals("AddressDetail.toString() has failed",
                "AddressDetail{addressId=1, houseNumber=95, houseName='Torrington', streetName='Newton Drive', town=town{townId=1, townName='Blackpool'}, county=County{countyId=1, countyName='Lancashire'}, postCode='FY3 8LX'}",
                addressDetailUnderTest.toString());
    }

}