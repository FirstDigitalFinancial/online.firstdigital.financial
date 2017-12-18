package financial.firstdigital.online.service;

import financial.firstdigital.online.model.EmailDetail;
import financial.firstdigital.online.model.EmailType;
import financial.firstdigital.online.repository.EmailDetailRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The EmailDetailServiceImplTest class is a test class that
 * tests the EmailDetailServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class EmailDetailServiceImplTest {

    @Mock
    EmailDetailRepository mockEmailDetailRepository;

    @InjectMocks
    EmailDetailService emailDetailServiceUnderTest = new EmailDetailService();

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     *
     */
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        EmailDetail emailDetail = new EmailDetail(Long.valueOf(1),
                                                  "test@firstdigital.financial",
                                                  EmailType.PRIMARY,
                                                  true);

        when(mockEmailDetailRepository.findDistinctByEmailIdEquals(Long.valueOf(1))).thenReturn(emailDetail);
        when(mockEmailDetailRepository.findDistinctByEmailAddressEquals("test@firstdigital.financial")).thenReturn(emailDetail);
        when(mockEmailDetailRepository.save(emailDetail)).thenReturn(emailDetail);

    }

    /**
     * Tests EmailDetailServiceImpl.findDistinctByEmailIdEquals()
     */
    @Test
    public void findDistinctByEmailIdEquals_EmailIsFound_Passes() throws Exception {
        Assert.assertEquals("EmailDetailServiceImpl.findDistinctByEmailIdEquals() has failed",
                "test@firstdigital.financial",
                emailDetailServiceUnderTest.findDistinctByEmailIdEquals(Long.valueOf(1)).getEmailAddress());
    }

    /**
     * Tests EmailDetailServiceImpl.findDistinctByEmailAddressEquals()
     */
    @Test
    public void findDistinctByEmailAddressEquals_EmailIsFound_Passes() throws Exception {
        Assert.assertEquals("EmailDetailServiceImpl.findDistinctByEmailAddressEquals() has failed",
                "test@firstdigital.financial",
                emailDetailServiceUnderTest.findDistinctByEmailAddressEquals("test@firstdigital.financial").getEmailAddress());
    }

    /**
     * Tests EmailDetailServiceImpl.saveUserDetails()
     */
    @Test
    public void saveEmailDetail_EmailIsSaved_Passes() throws Exception {
        EmailDetail emailDetail = new EmailDetail(Long.valueOf(2),
                "test2@firstdigital.financial",
                EmailType.PRIMARY,
                true);

        emailDetailServiceUnderTest.saveEmailDetail(emailDetail);

        verify(mockEmailDetailRepository, times(1)).save(emailDetail);

    }

}