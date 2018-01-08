package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTypeTest {

    /**
     * Tests ContactType.PRIMARY.getDisplayName()
     */
    @Test
    public void getDisplayName_IsPrimary_Passes() throws Exception {
        Assert.assertEquals(ContactType.PRIMARY.getDisplayName(),"Primary");
    }

    /**
     * Tests ContactType.SECONDARY.getDisplayName()
     */
    @Test
    public void getDisplayName_IsSecondary_Passes() throws Exception {
        Assert.assertEquals(ContactType.SECONDARY.getDisplayName(),"Secondary");
    }

}