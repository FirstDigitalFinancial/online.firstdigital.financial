package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The CurrencyTest class is a test class that
 * tests the values of the ENUM Currency.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class CurrencyTest {

    /**
     * Tests Currency.BITCOIN_CORE.getDisplayName()
     */
    @Test
    public void getDisplayName_IsBitcoinCore_Passes() throws Exception {
        Assert.assertEquals(Currency.BITCOIN_CORE.getDisplayName(), "Bitcoin Core");
    }

    /**
     * Tests Currency.BITCOIN_CORE.getDisplayName()
     */
    @Test
    public void getDisplayName_IsBitcoinCash_Passes() throws Exception {
        Assert.assertEquals(Currency.BITCOIN_CASH.getDisplayName(), "Bitcoin Cash");
    }

    /**
     * Tests Currency.ETHEREUM.getDisplayName()
     */
    @Test
    public void getDisplayName_IsEthereum_Passes() throws Exception {
        Assert.assertEquals(Currency.ETHEREUM.getDisplayName(), "Ethereum");
    }

    /**
     * Tests Currency.LITECOIN.getDisplayName()
     */
    @Test
    public void getDisplayName_IsLitecoin_Passes() throws Exception {
        Assert.assertEquals(Currency.LITECOIN.getDisplayName(), "Litecoin");
    }

}