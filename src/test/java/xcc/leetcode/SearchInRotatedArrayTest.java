package xcc.leetcode;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 2/13/14
 * Time: 12:02 PM
 */
public class SearchInRotatedArrayTest
{
    @Test
    public void testFindSortedArrayRotation()
    {
        SearchInRotatedArray obj = new SearchInRotatedArray();
        Assert.assertEquals(0, obj.findSortedArrayRotation(new int[]{1}));
        Assert.assertEquals(0, obj.findSortedArrayRotation(new int[] {1,2}));
        Assert.assertEquals(1, obj.findSortedArrayRotation(new int[] {2,1}));
        Assert.assertEquals(0, obj.findSortedArrayRotation(new int[] {1,2,3}));
        Assert.assertEquals(1, obj.findSortedArrayRotation(new int[] {3,1,2}));
        Assert.assertEquals(2, obj.findSortedArrayRotation(new int[] {2,3,1}));
        Assert.assertEquals(0, obj.findSortedArrayRotation(new int[] {1,2,3,4,5}));
        Assert.assertEquals(4, obj.findSortedArrayRotation(new int[] {2,3,4,5,1}));
        Assert.assertEquals(3, obj.findSortedArrayRotation(new int[] {3,4,5,1,2}));
     }
}
