package xcc.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 2/13/14
 * Time: 1:19 PM
 */
public class SearchForARange
{
    private int findLowerBound(int A[], int target)
    {
        int l = 0, r = A.length - 1;

        while(l <= r)
        {
            int m = (l + r)/2;
            // if strictly smaller than target, move left (l = m + 1)
            if(A[m] < target)
            {
                l = m + 1;
            }
            else
            {
                r = m - 1;
            }
        }

        if (l < A.length && A[l] == target) return l;
        else return -1;
    }

    private int findUpperBound(int A[], int target)
    {
        int l = 0, r = A.length - 1;

        while(l <= r)
        {
            int m = (l + r)/2;
            if(A[m] > target)
            {
                r = m - 1;
            }
            else
            {
                l = m + 1;
            }
        }

        if(r >= 0 && A[r] == target) return r;
        else return -1;
    }

    public int[] searchRange(int[] A, int target) {
        int lowerBound = findLowerBound(A, target);
        int upperBound = findUpperBound(A, target);
        return new int[] {lowerBound, upperBound};
    }
}
