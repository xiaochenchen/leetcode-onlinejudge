package xcc.leetcode.dynamicprogramming;

/**
 * A robot is located at the top-left corner of
 * a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Created by lightsaber on 4/6/14.
 */
public class UniquePaths
{
    public int uniquePaths(int m, int n)
    {
        int[][] ways = new int[m][n];

        // initialize first row
        for(int i = 0; i < n; ++i)
        {
            ways[0][i] = 1;
        }
        // initialize first column
        for(int i = 0; i < m; ++i)
        {
            ways[i][0] = 1;
        }

        // calculate the dynamic matrix
        for(int i = 1; i < m; ++i)
        {
            for(int j = 1; j < n; ++j)
            {
                ways[i][j] = ways[i-1][j] + ways[i][j-1];
            }
        }

        return ways[m-1][n-1];
    }
}
