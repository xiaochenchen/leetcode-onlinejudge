package xcc.leetcode.array;

/**
 * Given an unsorted integer array,
 * find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * Created by lightsaber on 3/30/14.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A)
    {
        // for a postive integer i
        // place it at index i - 1

        // very bad way to iterate, there is gonna be a better way
        /*
        for(int i = 0; i < A.length; ++i)
        {
            // if the new integer that gets swapped to i needs to be placed
            // keep placing them!
            while(A[i] > 0 && A[i] - 1 < A.length && A[i] - 1 != i && A[i] != A[A[i]-1])
            {
                swap(A, A[i] - 1, i);
            }
        }
        */

        int i = 0;
        while(i < A.length)
        {
            if(A[i] > 0 && A[i] - 1 < A.length
                    && A[i] - 1 != i && A[i] != A[A[i] - 1])
                swap(A, i, A[i] - 1);
            else
                i++;
        }

        // if there is a missing positive found, return it
        for(i = 0; i < A.length; ++i)
        {
            if(A[i] != i + 1)
            {
                 return i + 1;
            }
        }

        // there is no missing positive so far, so next one will be
        return A.length + 1;
    }

    public void swap(int[] A, int i, int j)
    {
        if(A == null || i == j || i < 0 || j < 0
                || i >= A.length || j >= A.length)
        {
            return;
        }

        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
