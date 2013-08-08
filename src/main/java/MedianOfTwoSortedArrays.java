/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/6/13
 * Time: 10:58 PM
 */

/**
 * Problem Description:
 *
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 */

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len_a = A.length;
        int len_b = B.length;
        int len_total = len_a + len_b;

        int prev = 0, curr = 0, count = 0, index_a = 0, index_b = 0;

        while( count++ < len_total / 2 + 1 )
        {
            prev = curr;
            if(index_a < len_a && index_b < len_b)
            {
                curr = ( A[index_a] > B[index_b] ) ? B[index_b++] : A[index_a++];
            }
            else if(index_a < len_a)
            {
                curr = A[index_a++];
            }
            else
            {
                curr = B[index_b++];
            }
        }

        return (len_total % 2) == 1 ? curr : (prev + curr) / 2.0;

    }
}
