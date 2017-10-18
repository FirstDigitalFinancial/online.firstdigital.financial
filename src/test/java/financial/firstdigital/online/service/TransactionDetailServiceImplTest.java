package financial.firstdigital.online.service;

import financial.firstdigital.online.model.*;
import financial.firstdigital.online.repository.TransactionDetailRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * The TransactionDetailServiceImplTest class is a test class that
 * tests the TransactionDetailServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class TransactionDetailServiceImplTest {

    @Mock
    TransactionDetailRepository mockTransactionDetailRepository;

    @InjectMocks
    TransactionDetailService transactionDetailServiceUnderTest = new TransactionDetailServiceImpl();

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        AccountDetail accountDetail = new AccountDetail(1L,
                "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa",
                Currency.BITCOIN_CORE,
                AccountStatus.OPEN);

        TransactionDetail transactionDetail = new TransactionDetail(Long.valueOf(10000),
                TransactionType.DEPOST,
                BigDecimal.valueOf(95.01),
                BigDecimal.valueOf(195.01),
                accountDetail);

        when(mockTransactionDetailRepository.findDistinctByTransactionIdEquals(Long.valueOf(10000))).thenReturn(transactionDetail);
        when(mockTransactionDetailRepository.save(transactionDetail)).thenReturn(transactionDetail);

    }

    /**
     * Tests TransactionDetailServiceImpl.findDistinctByTransactionIdEquals()
     */
    @Test
    public void findDistinctByTransactionIdEquals_TransactionDetailIsGot_Passes() throws Exception {
        Assert.assertEquals("TransactionDetailServiceImpl.findDistinctByTransactionIdEquals() has failed",
                BigDecimal.valueOf(95.01), transactionDetailServiceUnderTest.findDistinctByTransactionIdEquals(Long.valueOf(10000)).getTransactionValue());
    }

    /**
     * Tests TransactionDetailServiceImpl.saveTransactionDetail()
     */
    @Test
    public void saveTransactionDetail_TransactionIsSaved_Passes() throws Exception {

        AccountDetail accountDetail = new AccountDetail(1L,
                "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa",
                Currency.BITCOIN_CORE,
                AccountStatus.OPEN);

        TransactionDetail transactionDetail = new TransactionDetail(Long.valueOf(10000),
                TransactionType.DEPOST,
                BigDecimal.valueOf(95.01),
                BigDecimal.valueOf(195.01),
                accountDetail);

        transactionDetailServiceUnderTest.saveTransactionDetail(transactionDetail);

        //TODO: Find a way to test the above CrudRepository save...

    }

}