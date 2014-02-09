package xcc.leetcode;
import org.junit.Test;

import xcc.leetcode.LongestPalindromicSubstring;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/7/13
 * Time: 11:12 PM
 */
public class LongestPalindromicSubstringTest
{
    @Test
    public void longestPalindromeDPTest()
    {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        lps.longestPalindromeDP("");
    }

    @Test
    public void longestPalindromeManacherTest()
    {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        //System.out.println(lps.longestPalindromeManacher("a"));
        System.out.println(lps.longestPalindromeManacher("ccc"));
        //System.out.println(lps.longestPalindromeManacher("abcbaddef"));
    }
}
