package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The AccountStatusTest class is a test class
 * that tests the values of the ENUM AccountStatus.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class AccountStatusTest {

    /**
     * Tests AccountStatus.OPEN.getDisplayName()
     */
    @Test
    public void getDisplayName_IsOpen_Passes() throws Exception {
        Assert.assertEquals(AccountStatus.OPEN.getDisplayName(),"Open");
    }

    /**
     * Tests AccountStatus.CLOSED.getDisplayName()
     */
    @Test
    public void getDisplayName_IsClosed_Passes() throws Exception {
        Assert.assertEquals(AccountStatus.CLOSED.getDisplayName(),"Closed");
    }

    /**
     * Tests AccountStatus.ON_HOLD.getDisplayName()
     */
    @Test
    public void getDisplayName_IsOnHold_Passes() throws Exception {
        Assert.assertEquals(AccountStatus.ON_HOLD.getDisplayName(),"On Hold");
    }

}