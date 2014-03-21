package xcc.leetcode;

/**
 * Created by Maximus on 3/20/14.
 */
public class MaximumSubarray
{
    public int maxSubarray(int[] A)
    {
        int result = Integer.MIN_VALUE;

        int curMax = 0;
        for(int i = 0; i < A.length; ++i)
        {
            curMax += A[i];

            if(curMax > result)
            {
                result = curMax;
            }

            if(curMax < 0)
            {
                curMax = 0;
            }
        }

        return result;
    }
}
