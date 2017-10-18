package financial.firstdigital.online;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

/**
 * The ApplicationTest class is the class that
 * tests the Application class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@TestPropertySource(
        locations = "classpath:test.properties")
public class ApplicationTest {

    /**
     * Test Application.main()
     */
    @Test
    public void main() throws Exception {
        Application.main(new String[] {});
    }
}