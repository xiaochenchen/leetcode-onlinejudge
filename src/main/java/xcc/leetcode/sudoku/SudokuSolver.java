package xcc.leetcode.sudoku;

import java.util.Arrays;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 *
 * Created with IntelliJ IDEA.
 * User: lightsaber
 * Date: 2/13/14
 * Time: 7:08 PM
 */
public class SudokuSolver
{
    private final int BOARD_LEN = 9;

    public void solveSudoku(char[][] board) {
    	solve(board);
    }

    private boolean solve(char[][] board)
    {
        int[] unsolvedPosition = findUnsolvedPosition(board);

        // if there is no unsolved cell, return true
        if(Arrays.equals(new int[] {-1, -1}, unsolvedPosition)) return true;

        int r = unsolvedPosition[0], c = unsolvedPosition[1];

        for(int n = 1; n <= BOARD_LEN; n++)
        {
            if(isSafe(board, r, c, Character.forDigit(n, 10)))
            {
                board[r][c] = Character.forDigit(n, 10);
                if(solve(board))
                {
                    return true;
                }

                // failure, unset, try another number
                // always forget about this step, ATTENTION!!!!!
                board[r][c] = '.';
            }
        }

        return false;
    }

    private int[] findUnsolvedPosition(char[][] board)
    {
        int[] unsolvedPosition = new int[] {-1, -1};
        for(int i = 0; i < BOARD_LEN; i++)
        {
            for(int j = 0; j < BOARD_LEN; j++)
            {
                if(board[i][j] == '.')
                {
                    unsolvedPosition[0] = i;
                    unsolvedPosition[1] = j;
                    return unsolvedPosition;
                }
            }
        }
        return unsolvedPosition;
    }

    private boolean isSafe(char[][] board, int r, int c, char num)
    {
        // check row
        for(int j = 0; j < BOARD_LEN; j++)
        {
            if(board[r][j] == num)
            {
                return false;
            }
        }

        // check column
        for(int i = 0; i < BOARD_LEN; i++)
        {
            if(board[i][c] == num)
            {
                return false;
            }
        }

        // check 3X3 box
        int box_row = r / 3;
        int box_col = c / 3;
        for(int i = 3 * box_row; i < 3 * (box_row + 1); i++)
        {
            for(int j = 3 * box_col; j < 3 * (box_col + 1); j++)
            {
                if(board[i][j] == num)
                {
                    return false;
                }
            }
        }

        return true;
    }
}
