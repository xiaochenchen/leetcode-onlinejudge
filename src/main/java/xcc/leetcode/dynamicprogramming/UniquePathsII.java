package xcc.leetcode.dynamicprogramming;

/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids.
 * How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 *
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 *
 * Created by lightsaber on 4/6/14.
 */
public class UniquePathsII
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        if(obstacleGrid == null) return 0;
        int m = obstacleGrid.length;

        if(obstacleGrid[0] == null) return 0;
        int n = obstacleGrid[0].length;

        int[][] ways = new int[m][n];

        // initialize first row
        int i = 0;
        while(i < n)
        {
            if(obstacleGrid[0][i] == 1) while(i < n) { ways[0][i++] = 0; }
            else ways[0][i++] = 1;
        }

        // initialize first column
        i = 0;
        while(i < m)
        {
            if(obstacleGrid[i][0] == 1) while(i < m) { ways[i++][0] = 0; }
            else ways[i++][0] = 1;
        }

        // calculate the ways for each cell
        for(i = 1; i < m; ++i)
        {
            for(int j = 1; j < n; ++j)
            {
                if(obstacleGrid[i][j] == 1) ways[i][j] = 0;
                else ways[i][j] = ways[i-1][j] + ways[i][j-1];
            }
        }

        return ways[m-1][n-1];
    }
}
