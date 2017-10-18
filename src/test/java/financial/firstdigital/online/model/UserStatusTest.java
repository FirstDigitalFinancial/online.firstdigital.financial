package financial.firstdigital.online.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The UserStatusTest class is a test class that
 * tests the values of the ENUM UserStatus. This
 * test does very little, but by including it
 * it allows a the luxury of always reacting
 * to a less than 100% coverage report
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
public class UserStatusTest {

    /**
     * Tests UserStatus.ACTIVE
     */
    @Test
    public void UserStatus_ACTIVE_Passes() throws Exception {
        UserStatus.valueOf(UserStatus.ACTIVE.toString());
    }

    /**
     * Tests UserStatus.DISABLED
     */
    @Test
    public void UserStatus_DISABLED_Passes() throws Exception {
        UserStatus.valueOf(UserStatus.DISABLED.toString());
    }

}