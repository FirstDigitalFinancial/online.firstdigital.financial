package financial.firstdigital.online.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

/**
 * The PingTest class is a test class that tests Ping.
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-10
 */
public class PingTest {

    private Ping testPing;
    @Mock
    private Clock mockClock;
    private int year = 2017;
    private int month = 2;
    private int day = 3;

    private int hour = 22;
    private int minute = 11;
    private int second = 00;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {

        Clock mockClock =
                Clock.fixed(
                        LocalDateTime.of(year, month, day, hour, minute, second).toInstant(OffsetDateTime.now().getOffset()),
                        Clock.systemUTC().getZone());

        testPing = new Ping(mockClock);

    }

    /**
     * Tests Ping.getResponse()
     */
    @Test
    public void getResponse_ResponseIsGot_Passes() throws Exception {
        Assert.assertEquals("getResponse() has failed",
                "pong", testPing.getResponse());
    }

    /**
     * Tests Ping.toString()
     */
    @Test
    public void toString_StringReturned_Passes() throws Exception {
         Assert.assertEquals( "toString() has failed",
                "Ping{response=pong, date=2017-02-03, time=21:11:00}", testPing.toString());
    }

}