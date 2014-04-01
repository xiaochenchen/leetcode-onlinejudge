package xcc.leetcode.sudoku;

import java.util.Arrays;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 *
 * Created by lightsaber on 3/31/14.
 */
public class ValidSudoku
{
    public boolean isValidSudoku(char[][] board)
    {
        boolean[] visited = new boolean[9];

        // check each row
        for(int i = 0; i < board.length; ++i)
        {
            Arrays.fill(visited, false);
            for(int j = 0; j < board[i].length; ++j)
            {
                if(board[i][j] != '.')
                {
                    if(visited[board[i][j] - '1']) return false;
                    else visited[board[i][j] - '1'] = true;
                }
            }
        }

        // check each column
        for(int j = 0; j < board[0].length; ++j)
        {
            Arrays.fill(visited, false);
            for(int i = 0; i < board.length; ++i)
            {
                if(board[i][j] != '.')
                {
                    if(visited[board[i][j] - '1']) return false;
                    else visited[board[i][j] - '1'] = true;
                }
            }
        }

        // check each 3 * 3 grid
        for(int m = 0; m < 3; ++m)
        {
            for(int n = 0; n < 3; ++n)
            {
                Arrays.fill(visited, false);
                for(int i = m * 3; i < m * 3 + 3; ++i)
                {
                    for(int j = n * 3; j < n * 3 + 3; ++j)
                    {
                        if(board[i][j] != '.')
                        {
                            if(visited[board[i][j] - '1']) return false;
                            else visited[board[i][j] - '1'] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
