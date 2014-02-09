package xcc.leetcode;
import junit.framework.Assert;

import org.junit.Test;

import xcc.leetcode.LongestSubstringWithoutRepeatingCharacters;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/6/13
 * Time: 11:02 PM
 */
public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void lengthOfLongestSubstringSlowTest()
    {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        Assert.assertEquals(3, test.lengthOfLongestSubstringBruteForce("abcabcbb"));
    }

    @Test
    public void lengthOfLongestSubstringFastTest()
    {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        Assert.assertEquals(3, test.lengthOfLongestSubstringFast("abcabcbb"));
    }
}
