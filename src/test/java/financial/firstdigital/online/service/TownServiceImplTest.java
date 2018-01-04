package financial.firstdigital.online.service;

import financial.firstdigital.online.model.Town;
import financial.firstdigital.online.repository.TownRepository;
import financial.firstdigital.online.service.database.TownService;
import financial.firstdigital.online.service.database.TownServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * The TownServiceImplTest class is a test class that
 * tests the TownServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class TownServiceImplTest {

    @Mock
    TownRepository mockTownRepository;

    @InjectMocks
    TownService townServiceUnderTest = new TownServiceImpl();

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        Town testTown = new Town(1,"Blackpool");

        when(mockTownRepository.findDistinctByTownIdEquals(1)).thenReturn(testTown);
        when(mockTownRepository.findDistinctByTownNameEquals("Blackpool")).thenReturn(testTown);
    }

    /**
     * Tests TownServiceImpl.findDistinctByTownIdEquals()
     */
    @Test
    public void findDistinctByTownIdEquals() throws Exception {
        Assert.assertEquals("TownServiceImpl.findDistinctByTownIdEquals() has failed",
                1, townServiceUnderTest.findDistinctByTownIdEquals(1).getTownId());
    }

    /**
     * Tests TownServiceImpl.findDistinctByTownNameEquals()
     */
    @Test
    public void findDistinctByTownNameEquals() throws Exception {
        Assert.assertEquals("TownServiceImpl.findDistinctByTownNameEquals() has failed",
                "Blackpool", townServiceUnderTest.findDistinctByTownNameEquals("Blackpool").getTownName());
    }

}