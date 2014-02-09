package xcc.leetcode;
import junit.framework.Assert;

import org.junit.Test;

import xcc.leetcode.ThreeSumClosest;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 9/16/13
 * Time: 11:30 PM
 */
public class ThreeSumClosestTest {
    @Test
    public void testThreeSumClosest() throws Exception {
        ThreeSumClosest tsc = new ThreeSumClosest();
        int[] num = {-3,-2,-5,3,-4};
        Assert.assertEquals(-2, tsc.threeSumClosest(num, -1));
    }
}
