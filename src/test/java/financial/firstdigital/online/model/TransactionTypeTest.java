package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The TransactionTypeTest class is a test class that
 * tests the values of the ENUM TransactionType.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class TransactionTypeTest {

    /**
     * Tests TransactionType.DEPOST.getDisplayName()
     */
    @Test
    public void getDisplayName_IsDeposit_Passes() throws Exception {
        Assert.assertEquals(TransactionType.DEPOST.getDisplayName(), "Deposit");
    }

    /**
     * Tests TransactionType.WITHDRAW.getDisplayName()
     */
    @Test
    public void getDisplayName_IsWithdraw_Passes() throws Exception {
        Assert.assertEquals(TransactionType.WITHDRAW.getDisplayName(), "Withdraw");
    }

    /**
     * Tests TransactionType.TRANSFER.getDisplayName()
     */
    @Test
    public void getDisplayName_IsTransfer_Passes() throws Exception {
        Assert.assertEquals(TransactionType.TRANSFER.getDisplayName(), "Transfer");
    }

    /**
     * Tests TransactionType.CHARGE.getDisplayName()
     */
    @Test
    public void getDisplayName_IsCharge_Passes() throws Exception {
        Assert.assertEquals(TransactionType.CHARGE.getDisplayName(), "Charge");
    }

    /**
     * Tests TransactionType.REFUND.getDisplayName()
     */
    @Test
    public void getDisplayName_IsRefund_Passes() throws Exception {
        Assert.assertEquals(TransactionType.REFUND.getDisplayName(), "Refund");
    }

    /**
     * Tests TransactionType.EXCHANGE.getDisplayName()
     */
    @Test
    public void getDisplayName_IsExchange_Passes() throws Exception {
        Assert.assertEquals(TransactionType.EXCHANGE.getDisplayName(), "Exchange");
    }

}