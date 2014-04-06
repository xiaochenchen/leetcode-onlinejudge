package xcc.leetcode.array;

/**
 * Given an array of non-negative integers,
 * you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 * Created by lightsaber on 4/6/14.
 */
public class JumpGame
{
    public boolean canJump(int[] A)
    {
        if(A == null) return false;

        // use maxCover to track the max jumpable index
        // scan the array from left to maxCover
        // if a new element can jump beyond the maxCover
        // update maxCover
        // if reached the end of the array, return true
        // else return false
        int maxCover = 0;
        for(int i = 0; i <= maxCover; ++i)
        {
            int curCover = i + A[i];
            if(curCover > maxCover) maxCover = curCover;

            if(maxCover >= A.length - 1) return true;
        }

        return false;
    }
}
