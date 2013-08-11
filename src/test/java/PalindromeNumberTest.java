import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/11/13
 * Time: 1:51 PM
 */
public class PalindromeNumberTest {

    @Test
    public void testIsPalindrome() throws Exception {
        PalindromeNumber pn = new PalindromeNumber();
        //Assert.assertFalse(pn.isPalindrome(-2147483648));
        Assert.assertFalse(pn.isPalindrome(-2147447412));
    }
}
