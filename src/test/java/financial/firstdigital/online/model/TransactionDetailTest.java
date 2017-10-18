package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * The TransactionDetailTest class is a test class that
 * tests the TransactionDetail class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class TransactionDetailTest {

    TransactionDetail transactionDetailUnderTest;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {

        AccountDetail accountDetail = new AccountDetail(1L,
                "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa",
                Currency.BITCOIN_CORE,
                AccountStatus.OPEN);

        transactionDetailUnderTest = new TransactionDetail(Long.valueOf(10000),
                TransactionType.DEPOST,
                BigDecimal.valueOf(95.01),
                BigDecimal.valueOf(195.01),
                accountDetail);
    }

    /**
     * Tests TransactionDetail.getTransactionId()
     */
    @Test
    public void getTransactionId_TransactionIdIsGot_Passes() throws Exception {
        Assert.assertEquals("TransactionDetail.getTransactionId() has failed",
                Long.valueOf(10000),
                transactionDetailUnderTest.getTransactionId());
    }

    /**
     * Tests TransactionDetail.getTransactionType()
     */
    @Test
    public void getTransactionType_TransactionTypeIsGot_Passes() throws Exception {
        Assert.assertEquals("TransactionDetail.getTransactionType() has failed",
                TransactionType.DEPOST,
                transactionDetailUnderTest.getTransactionType());
    }

    /**
     * Tests TransactionDetail.setTransactionType()
     */
    @Test
    public void setTransactionType_TransactionTypeIsSet_Passes() throws Exception {
        transactionDetailUnderTest.setTransactionType(TransactionType.CHARGE);
        Assert.assertEquals("TransactionDetail.setTransactionType() has failed",
                TransactionType.CHARGE,
                transactionDetailUnderTest.getTransactionType());
    }

    /**
     * Tests TransactionDetail.getTransactionValue()
     */
    @Test
    public void getTransactionValue_TransactionValueIsGot_Passes() throws Exception {
        Assert.assertEquals("TransactionDetail.getTransactionValue() has failed",
                BigDecimal.valueOf(95.01),
                transactionDetailUnderTest.getTransactionValue());
    }

    /**
     * Tests TransactionDetail.setTransactionValue()
     */
    @Test
    public void setTransactionValue_TransactionValueIsSet_Passes() throws Exception {
        transactionDetailUnderTest.setTransactionValue(BigDecimal.valueOf(101.22));
        Assert.assertEquals("TransactionDetail.setTransactionValue() has failed",
                BigDecimal.valueOf(101.22),
                transactionDetailUnderTest.getTransactionValue());
    }

    /**
     * Tests TransactionDetail.getEndOfTransactionBalance()
     */
    @Test
    public void getEndOfTransactionBalance_EndOfTransactionBalanceIsGet_Passes() throws Exception {
        Assert.assertEquals("TransactionDetail.getEndOfTransactionBalance() has failed",
                BigDecimal.valueOf(195.01),
                transactionDetailUnderTest.getEndOfTransactionBalance());
    }

    /**
     * Tests TransactionDetail.setEndOfTransactionBalance()
     */
    @Test
    public void setEndOfTransactionBalance_EndOfTransactionBalanceIsSet_Passes() throws Exception {
        transactionDetailUnderTest.setEndOfTransactionBalance(BigDecimal.valueOf(222.01));
        Assert.assertEquals("TransactionDetail.getEndOfTransactionBalance() has failed",
                BigDecimal.valueOf(222.01),
                transactionDetailUnderTest.getEndOfTransactionBalance());
    }

    /**
     * Tests TransactionDetail.toString()
     */
    @Test
    public void toString_StringReturned_Passes() throws Exception {
        Assert.assertEquals("TransactionDetail.toString() has failed",
                "TransactionDetail{transactionId=10000, transactionType=DEPOST, transactionValue=95.01, endOfTransactionBalance=195.01}",
                transactionDetailUnderTest.toString());
    }

}