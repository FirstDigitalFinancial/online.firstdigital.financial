package financial.firstdigital.online.service;

import financial.firstdigital.online.model.Title;
import financial.firstdigital.online.repository.TitleDetailRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * The TitleServiceImplTest class is a test class that
 * tests the TitleServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class TitleServiceImplTest {

    @Mock
    TitleDetailRepository mockTitleDetailRepository;

    @InjectMocks
    TitleService titleServiceImplUnderTest = new TitleServiceImpl();

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        Title testTitle = new Title(1,"Mr");

        when(mockTitleDetailRepository.findDistinctByTitleEquals("Mr")).thenReturn(testTitle);
        when(mockTitleDetailRepository.findDistinctByTitleIdEquals(1)).thenReturn(testTitle);

    }

    /**
     * Tests TitleServiceImpl.findDistinctByTitleIdEquals()
     */
    @Test
    public void findDistinctByTitleIdEquals_TitleFound_Passes() throws Exception {
        Assert.assertEquals(titleServiceImplUnderTest.findDistinctByTitleIdEquals(1).getTitleId(),1);
    }

    /**
     * Tests TitleServiceImpl.findDistinctByTitleEquals()
     */
    @Test
    public void findDistinctByTitleEquals_TitleFound_Passes() throws Exception {
        Assert.assertEquals(titleServiceImplUnderTest.findDistinctByTitleEquals("Mr").getTitle(),"Mr");
    }

}