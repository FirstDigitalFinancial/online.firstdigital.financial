package financial.firstdigital.online.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

/**
 * The AccountDetailTest class is the class that
 * tests the AccountDetail model
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class AccountDetailTest {

    AccountDetail accountDetailUnderTest;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {
        accountDetailUnderTest = new AccountDetail(1L,
                "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa",
                Currency.BITCOIN_CORE,
                AccountStatus.OPEN);
    }

    @Test
    public void getAccountId_AccountIdIsGot_Passes() throws Exception {
        Assert.assertEquals(accountDetailUnderTest.getAccountId(), Long.valueOf(1L));
    }

    @Test
    public void getAddress_AddressIsGot_Passes() throws Exception {
        Assert.assertEquals("AccountDetail.getAddress() has failed", "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", accountDetailUnderTest.getAddress());
    }

    @Test
    public void setAddress_AddressIsSet_Passes() throws Exception {
        accountDetailUnderTest.setAddress("1XPTgDRhN8RFnzniWCddobD9iKZatrvH4");
        Assert.assertEquals("AccountDetail.setAddress() has failed", "1XPTgDRhN8RFnzniWCddobD9iKZatrvH4", accountDetailUnderTest.getAddress());
   }

    @Test
    public void getCurrency_CurrencyIsGot_Passes() throws Exception {
        Assert.assertEquals("AccountDetail.getCurrency() has failed", Currency.BITCOIN_CORE, accountDetailUnderTest.getCurrency());
    }

    @Test
    public void setCurrency_CurrencyIsSet_Passes() throws Exception {
        accountDetailUnderTest.setCurrency(Currency.ETHEREUM);
        Assert.assertEquals("AccountDetail.setCurrency() has failed", Currency.ETHEREUM, accountDetailUnderTest.getCurrency());
    }

    @Test
    public void getStatus_StatusIsGot_Passes() throws Exception {
        Assert.assertEquals("AccountDetail.getStatus() has failed", AccountStatus.OPEN, accountDetailUnderTest.getStatus());
    }

    @Test
    public void setStatus_StatusIsSet_Passes() throws Exception {
        accountDetailUnderTest.setStatus(AccountStatus.CLOSED);
        Assert.assertEquals("AccountDetail.setStatus() has failed", AccountStatus.CLOSED, accountDetailUnderTest.getStatus());
    }

    @Test
    public void toString_StringReturned_Passes() throws Exception {
        Assert.assertEquals("AccountDetail.toString() has failed", "AccountDetail{accountId=1, address='1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa', currency=BITCOIN_CORE, status=OPEN}", accountDetailUnderTest.toString());
    }

}