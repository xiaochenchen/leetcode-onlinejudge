package xcc.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 2/13/14
 * Time: 1:31 PM
 */
public class SearchForARangeTest
{
    @Test
    public void testSearchRange()
    {
        SearchForARange obj = new SearchForARange();
        Assert.assertArrayEquals(new int[] {-1, -1}, obj.searchRange(new int[] {2,2}, 3));
        Assert.assertArrayEquals(new int[] {-1, -1}, obj.searchRange(new int[] {1}, 0));
        Assert.assertArrayEquals(new int[] {0, 0}, obj.searchRange(new int[] {1}, 1));
        Assert.assertArrayEquals(new int[] {0, 0}, obj.searchRange(new int[] {1,3}, 1));
        Assert.assertArrayEquals(new int[] {0, 1}, obj.searchRange(new int[] {2,2}, 2));
    }
}
