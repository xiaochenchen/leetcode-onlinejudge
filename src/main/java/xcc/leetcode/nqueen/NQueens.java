package xcc.leetcode.nqueen;

import java.util.ArrayList;

/**
 * The n-queens puzzle is the problem of placing n queens
 * on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *      [".Q..",  // Solution 1
 *      "...Q",
 *      "Q...",
 *      "..Q."],
 *
 *      ["..Q.",  // Solution 2
 *      "Q...",
 *      "...Q",
 *      ".Q.."]
 * ]
 *
 * Created with IntelliJ IDEA.
 * User: lightsaber
 * Date: 4/5/14
 * Time: 10:08 PM
 */
public class NQueens
{
    public ArrayList<String[]> solveNQueens(int n)
    {
        // final results
        ArrayList<String[]> results = new ArrayList<String[]>();

        // store the column id of each queen for each row
        int[] rows = new int[n];

        solve(0, rows, results);

        return results;
    }

    public void solve(int r, int[] rows, ArrayList<String[]> results)
    {
        // base case: when found a valid solution
        if(r == rows.length)
        {
            results.add(genResult(rows));
            return;
        }

        // for row r, check each column to place the Queen
        for(int i = 0; i < rows.length; ++i)
        {
            // if this column does not have
            if(isSafe(r, i, rows))
            {
                rows[r] = i;
                solve(r + 1, rows, results);
            }
        }
    }

    /**
     *
     * @param r which row to check
     * @param c which column to check
     * @param rows the current nqueens solution
     * @return
     */
    public boolean isSafe(int r, int c, int[] rows)
    {
        for(int i = 0; i < r; ++i)
        {
            // check if there is a queen at column c
            if(rows[i] == c) return false;

            // check if there is a queen at the left-to-right diagonal
            if(i + (c - r) >= 0 && i + (c - r) < rows.length && rows[i] == i + (c - r)) return false;

            // check if there is a queen at the right-to-left diagonal
            if((c + r) - i >= 0 && (c + r) - i < rows.length && rows[i] == (c + r) - i) return false;
        }

        return true;
    }

    public String[] genResult(int[] rows)
    {
        String[] result = new String[rows.length];

        for(int i = 0; i < rows.length; ++i)
        {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < rows.length; ++j)
            {
                if(rows[i] == j) sb.append("Q");
                else sb.append(".");
            }
            result[i] = sb.toString();
        }

        return result;
    }
}
