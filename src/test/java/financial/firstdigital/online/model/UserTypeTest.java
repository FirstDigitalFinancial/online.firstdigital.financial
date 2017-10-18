package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * The UserTypeTest class is a test class that
 * tests the values of the ENUM UserType. This
 * test does very little, but by including it
 * it allows a the luxury of always reacting
 * to a less than 100% coverage report
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class UserTypeTest {

    /**
     * Tests UserType.ADMINISTRATOR
     */
    @Test
    public void UserType_ADMINISTRATOR_Passes() throws Exception {
        UserType.valueOf(UserType.ADMINISTRATOR.toString());
    }

    /**
     * Tests UserType.CUSTOMER_SUPPORT
     */
    @Test
    public void UserType_CUSTOMER_SUPPORT_Passes() throws Exception {
        UserType.valueOf(UserType.CUSTOMER_SUPPORT.toString());
    }

    /**
     * Tests UserType.CUSTOMER_SALES
     */
    @Test
    public void UserType_CUSTOMER_SALES_Passes() throws Exception {
        UserType.valueOf(UserType.CUSTOMER_SALES.toString());
    }

    /**
     * Tests UserType.BROKER_SUPPORT
     */
    @Test
    public void UserType_BROKER_SUPPORT_Passes() throws Exception {
        UserType.valueOf(UserType.BROKER_SUPPORT.toString());
    }

    /**
     * Tests UserType.BROKER_SALES
     */
    @Test
    public void UserType_BROKER_SALES_Passes() throws Exception {
        UserType.valueOf(UserType.BROKER_SALES.toString());
    }

    /**
     * Tests UserType.CUSTOMER
     */
    @Test
    public void UserType_CUSTOMER_Passes() throws Exception {
        UserType.valueOf(UserType.CUSTOMER.toString());
    }

}