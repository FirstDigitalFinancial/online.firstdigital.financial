package financial.firstdigital.online.service;

import financial.firstdigital.online.model.AddressDetail;
import financial.firstdigital.online.model.County;
import financial.firstdigital.online.model.Town;
import financial.firstdigital.online.repository.AddressDetailRepository;
import financial.firstdigital.online.service.database.AddressDetailService;
import financial.firstdigital.online.service.database.AddressDetailServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The AddressDetailServiceImplTest class is a test class that
 * tests the AddressDetailServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class AddressDetailServiceImplTest {

    @Mock
    AddressDetailRepository mockAddressDetailRepository;

    @InjectMocks
    AddressDetailService addressDetailServiceUnderTest = new AddressDetailServiceImpl();

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        Town town = new Town(1,"Blackpool");
        County county = new County(1,"Lancashire");

        AddressDetail addressDetail = new AddressDetail(Long.valueOf(1),
                95,
                "Torrington",
                "Newton Drive",
                town,
                county,
                "FY3 8LX");

        Town town2 = new Town(1,"Bradford");
        County county2 = new County(1,"Yorkshire");

        AddressDetail addressDetail2 = new AddressDetail(Long.valueOf(1),
                100,
                "",
                "Smithy Road",
                town2,
                county2,
                "BD1 1UU");

        Set<AddressDetail> addressDetailSet2 = new HashSet<AddressDetail>();
        addressDetailSet2.add(addressDetail2);

        when(mockAddressDetailRepository.findDistinctByAddressIdEquals(Long.valueOf(1))).thenReturn(addressDetail);
        when(mockAddressDetailRepository.findDistinctByHouseNumberEqualsAndPostCodeEquals(95,"FY3 8LX")).thenReturn(addressDetail);
        when(mockAddressDetailRepository.save(addressDetailSet2)).thenReturn(addressDetailSet2);
    }

    /**
     * Tests AddressDetailServiceImpl.findDistinctByAddressIdEquals()
     */
    @Test
    public void findDistinctByAddressIdEquals_AddressIsGot_Passes() throws Exception {
        Assert.assertEquals("AddressDetailServiceImpl.findDistinctByAddressIdEquals() has failed",
                "Torrington", addressDetailServiceUnderTest.findDistinctByAddressIdEquals(Long.valueOf(1)).getHouseName());
    }

    /**
     * Tests AddressDetailServiceImpl.saveAddressDetailSet()
     */
    @Test
    public void saveAddressDetailSet() throws Exception {
        Town town = new Town(1,"Bradford");
        County county = new County(1,"Yorkshire");

        AddressDetail addressDetail = new AddressDetail(Long.valueOf(1),
                100,
                "",
                "Smithy Road",
                town,
                county,
                "BD1 1UU");

        Set<AddressDetail> addressDetailSet = new HashSet<AddressDetail>();
        addressDetailSet.add(addressDetail);

        addressDetailServiceUnderTest.saveAddressDetailSet(addressDetailSet);

        verify(mockAddressDetailRepository, times(1)).save(addressDetailSet);
    }

    /**
     * Tests AddressDetailServiceImpl.findDistinctByHouseNumberEqualsAndPostCodeEquals()
     */
    @Test
    public void findDistinctByHouseNumberEqualsAndPostCodeEquals() throws Exception {
        Assert.assertEquals("AddressDetailServiceImpl.findDistinctByHouseNumberEqualsAndPostCodeEquals() has failed",
                "Torrington", addressDetailServiceUnderTest.findDistinctByHouseNumberEqualsAndPostCodeEquals(95,"FY3 8LX").getHouseName());
    }

}