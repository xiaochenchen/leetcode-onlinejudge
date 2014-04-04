package xcc.leetcode.array;

/**
 * Given n non-negative integers representing an elevation
 * map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * Created by lightsaber on 4/3/14.
 */
public class TrappingRainWater
{
    public int trap(int[] A)
    {
        // two arrays to track the left max and right max for each element
        int[] maxL = new int[A.length];
        int[] maxR = new int[A.length];

        // scan the array, generate the left max array
        int sideMax = 0;
        for(int i = 0; i < A.length; ++i)
        {
            maxL[i] = sideMax;
            if(A[i] > sideMax) sideMax = A[i];
        }

        // scan the array reversely, generate the right max array
        // and in the meantime calculate the max trapped water
        int maxWater = 0;
        sideMax = 0;
        for(int i = A.length - 1; i >= 0; --i)
        {
            maxR[i] = sideMax;
            if(A[i] > sideMax) sideMax = A[i];

            int minSide = Math.min(maxL[i], maxR[i]);
            if(minSide > A[i]) maxWater += minSide - A[i];
        }

        return maxWater;
    }
}
