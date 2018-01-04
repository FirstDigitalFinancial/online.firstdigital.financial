package financial.firstdigital.online.service;

import financial.firstdigital.online.model.MarketingPreferenceDetail;
import financial.firstdigital.online.repository.MarketingPreferenceRepository;
import financial.firstdigital.online.service.database.MarketingPreferenceService;
import financial.firstdigital.online.service.database.MarketingPreferenceServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The MarketingPreferenceServiceImplTest class is a test class that
 * tests the MarketingPreferenceServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-19
 */
public class MarketingPreferenceServiceImplTest {

    @Mock
    MarketingPreferenceRepository mockMarketingPreferenceRepository;

    @InjectMocks
    MarketingPreferenceService marketingPreferenceServiceUnderTest = new MarketingPreferenceServiceImpl();

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     *
     */
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        MarketingPreferenceDetail marketingPreferenceDetail = new MarketingPreferenceDetail(1L,
                true,
                true,
                true,
                true,
                true,
                true);

        when(mockMarketingPreferenceRepository.findDistinctByMarketingPreferenceIdEquals(Long.valueOf(1))).thenReturn(marketingPreferenceDetail);
        when(mockMarketingPreferenceRepository.save(marketingPreferenceDetail)).thenReturn(marketingPreferenceDetail);

    }

    /**
     * Tests MarketingPreferenceDetailServiceImpl.saveMarketingPreferenceDetail()
     */
    @Test
    public void saveMarketingPreferenceDetail_MarketingPreferenceDetailIsSaved_Passes() throws Exception {

        MarketingPreferenceDetail marketingPreferenceDetail = new MarketingPreferenceDetail(2L,
                false,
                false,
                false,
                false,
                false,
                false);

        marketingPreferenceServiceUnderTest.saveMarketingPreferenceDetail(marketingPreferenceDetail);

        verify(mockMarketingPreferenceRepository, times(1)).save(marketingPreferenceDetail);

    }

    /**
     * Tests MarketingPreferenceDetailServiceImpl.findDistinctByMarketingPreferenceIdEquals()
     */
    @Test
    public void findDistinctByMarketingPreferenceIdEquals_MarketingPreferenceDetailIsFound_Passes() throws Exception {
        Assert.assertEquals("MarketingPreferenceDetailServiceImpl.findDistinctByMarketingPreferenceIdEquals() has failed",
                Long.valueOf(1),
                marketingPreferenceServiceUnderTest.findDistinctByMarketingPreferenceIdEquals(Long.valueOf(1)).getMarketingPreferenceId());
    }

}