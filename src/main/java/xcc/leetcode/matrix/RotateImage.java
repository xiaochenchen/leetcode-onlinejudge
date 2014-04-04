package xcc.leetcode.matrix;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?
 *
 * Created by lightsaber on 4/3/14.
 */
public class RotateImage
{
    public void rotate(int[][] matrix)
    {
        int n = matrix.length;

        for(int i = 0; i < n / 2; ++i)
        {
            for(int j = i; j < n - 1 - i; ++j)
            {
                //////////////////////////////////////////////
                //  (i, j)              (j, n - 1 - i)
                //  (n - 1 - j, i)      (n - 1 - i, n - 1 - j)
                //////////////////////////////////////////////

                // swap the above four nodes clock wise for 90 degrees
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}
