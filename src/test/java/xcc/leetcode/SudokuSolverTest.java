package xcc.leetcode;

import org.junit.Test;

public class SudokuSolverTest {

	@Test
	public void testSolveSudoku() {
		
		String[] inputs = 
			{ "..9748...",
			  "7........",
			  ".2.1.9...",
			  "..7...24.",
			  ".64.1.59.",
			  ".98...3..",
			  "...8.3.2.",
			  "........6",
			  "...2759.."};
		
		SudokuSolver obj = new SudokuSolver();
		char[][] board = createCharArray(inputs);
		printSudoku(board);

		obj.solveSudoku(board);
		
		printSudoku(board);
	}
	
	private char[][] createCharArray(String[] inputs)
	{
		char[][] array = new char[9][9];
		
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				array[i][j] = inputs[i].charAt(j);
			}
		}
		
		return array;
	}
	
	private void printSudoku(char[][] inputs)
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				System.out.print(inputs[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
