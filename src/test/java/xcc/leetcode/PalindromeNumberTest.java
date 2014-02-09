package xcc.leetcode;
import junit.framework.Assert;

import org.junit.Test;

import xcc.leetcode.PalindromeNumber;

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
//        Assert.assertFalse(pn.isPalindromeByReverse(-2147483648));
//        Assert.assertFalse(pn.isPalindromeByReverse(-2147447412));
        Assert.assertFalse(pn.isPalindrome(10));
    }
}
