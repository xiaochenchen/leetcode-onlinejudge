import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/11/13
 * Time: 11:50 AM
 */
public class StringToIntegerTest {

    private StringToInteger sti;

    @Before
    public void setUp() throws Exception {
        sti = new StringToInteger();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAtoi() throws Exception {
        Assert.assertEquals(0, sti.atoi(null));
        Assert.assertEquals(0, sti.atoi(""));
        Assert.assertEquals(12, sti.atoi("12"));
        Assert.assertEquals(12, sti.atoi("+12"));
        Assert.assertEquals(-12, sti.atoi("-12"));
        Assert.assertEquals(Integer.MAX_VALUE, sti.atoi("2147483648"));
        Assert.assertEquals(-2147483648, sti.atoi("-2147483648"));
        Assert.assertEquals(Integer.MAX_VALUE, sti.atoi("    10522545459"));
    }
}
