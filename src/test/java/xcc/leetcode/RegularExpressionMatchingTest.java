package xcc.leetcode;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xcc.leetcode.RegularExpressionMatching;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/13/13
 * Time: 12:00 AM
 */
public class RegularExpressionMatchingTest {

    RegularExpressionMatching rem = new RegularExpressionMatching();

    @Before
    public void setUp() throws Exception {
        rem = new RegularExpressionMatching();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsMatchDP() throws Exception {
        rem.isMatchDP("", ".*");
    }

    @Test
    public void testIsMatchDPOL() throws Exception {
        Assert.assertTrue(rem.isMatchDPOL("aaa", "ab*ac*a"));
    }
}
