package xcc.leetcode.dynamicprogramming;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Created by lightsaber on 4/6/14.
 */
public class MinimumPathSum
{
    public int minPathSum(int[][] grid)
    {
        if(grid == null) return 0;
        int m = grid.length;

        if(grid[0] == null) return 0;
        int n = grid[0].length;

        int[][] sums = new int[m][n];

        sums[0][0] = grid[0][0];
        // initialize the first row
        for(int i = 1; i < n; ++i)
        {
            sums[0][i] = sums[0][i-1] + grid[0][i];
        }
        // initialize the first column
        for(int i = 1; i < m; ++i)
        {
            sums[i][0] = sums[i-1][0] + grid[i][0];
        }

        // calculate the minimum sum for all cells
        for(int i = 1; i < m; ++i)
        {
            for(int j = 1; j < n; ++j)
            {
                sums[i][j] = Math.min(sums[i-1][j], sums[i][j-1]) + grid[i][j];
            }
        }

        return sums[m-1][n-1];
    }
}
