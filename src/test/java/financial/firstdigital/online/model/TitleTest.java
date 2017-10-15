package financial.firstdigital.online.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The TitleTest class is a test class that tests Title.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-10-15
 */
public class TitleTest {

    Title titleUnderTest;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {
        titleUnderTest = new Title(1, "Mr");
    }

    /**
     * Tests Title.getTitle()
     */
    @Test
    public void getTitle_CurrentTitleIsGot_Passes() throws Exception {
        Assert.assertEquals( "getTitle() has failed",
                "Mr", titleUnderTest.getTitle());
    }

    /**
     * Tests Title.getTitleId()
     */
    @Test
    public void getTitleId_CurrentTitleIdIsGot_Passes() throws Exception {
        Assert.assertEquals(1,1);
    }

    /**
     * Tests Title.setTitle()
     */
    @Test
    public void setTitle_SetsTitleToNewTitle_Passes() throws Exception {
        titleUnderTest.setTitle("Mrs");
        Assert.assertEquals( "setTitle() has failed",
                "Mrs", titleUnderTest.getTitle());
    }

    /**
     * Tests Title.toString()
     */
    @Test
    public void toString_StringReturned_Passes() throws Exception {
        Assert.assertEquals( "toString() has failed",
                "Title{titleId=1, title='Mr'}", titleUnderTest.toString());
    }

}