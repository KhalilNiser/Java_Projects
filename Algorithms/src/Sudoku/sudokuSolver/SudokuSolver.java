
/**
 * @author Niser, Khalil (2023/05/28)
 * 
 * Sudoku.sudokuSolver (SudokuSlover)
 * 
 * 				---- THEORY_IMPLEMENTATION ----
 * 
 * Sudoku (originally called Number Place) is a logic-based, combinatorial number-
 * placement puzzle. In classic Sudoku, the objective is to fill a 9 × 9 grid with 
 * digits so that each column, each row, and each of the nine 3 × 3 subgrids that 
 * compose the grid (also called "boxes", "blocks", or "regions") contain all of 
 * the digits from 1 to 9. The puzzle setter provides a partially completed grid, 
 * which for a well-posed puzzle has a single solution.
 * 
 * French newspapers featured variations of the Sudoku puzzles in the 19th century, 
 * and the puzzle has appeared since 1979 in puzzle books under the name Number 
 * Place. However, the modern Sudoku only began to gain widespread popularity in 
 * 1986 when it was published by the Japanese puzzle company Nikoli under the name 
 * Sudoku, meaning "single number".[6] It first appeared in a U.S. newspaper, and 
 * then The Times (London), in 2004, thanks to the efforts of Wayne Gould, who 
 * devised a computer program to rapidly produce unique puzzles.
 * 
 */


package Sudoku.sudokuSolver;

public class SudokuSolver 
{
	
	// CONSTANT VARIABLE: Size of the "grid" 9x9
	public static final int GRID_SIZE = 9;

	public static void main(String[] args) 
	{
		// Two Dimensional intArray (boardLayout)
		int[][] board = 
			{
					{ 7, 0, 2, 0, 5, 0, 6, 0, 0},
					{ 0, 0, 0, 0, 0, 3, 0, 0, 0 },
					{ 1, 0, 0, 0, 0, 9, 5, 0, 0 }, 
					{ 8, 0, 0, 0, 0, 0, 0, 9, 0 }, 
					{ 0, 4, 3, 0, 0, 0, 7, 5, 0 },
					{ 0, 9, 0, 0, 0, 0, 0, 0, 8 },     
					{ 0, 0, 9, 7, 0, 0, 0, 0, 5 },
					{ 0, 0, 0, 2, 0, 0, 0, 0, 0 },
					{ 0, 0, 7, 0, 4, 0, 2, 0, 3 }
			};
		
		System.out.println(  "\t\t\t---- BOARD_BEFORE_SOLVING_PUZZLE! ----");
		
		printBoard( board );
		
		System.out.println();
		
		System.out.println( "\t\t\t---- BOARD_AFTER_SOLVING_PUZZLE ----!" );
		
		System.out.println();
		
		if ( solveBoard( board ) )
		{
			System.out.println( "---- BOARD_SOLVED_SUCCESSFULLY! ----");
		}
		else
		{
			System.out.println( "---- UNSOLVABLE_BOARD! ( ----");
		}
		
		printBoard( board );

	}
	
	private static void printBoard( int[][] board )
	{
		for ( int row = 0; row < GRID_SIZE; row++ )
		{
			/*
			 * For every third row, and the row Not Equal to zero (0).
			 * For every third row, except for the very Top one, 
			 * insert hyphens
			 */
			if ( row % 3 == 0 && row != 0 )
			{
				System.out.println( "-----------" );
			}
			for ( int column = 0; column < GRID_SIZE; column++ )
			{
				if ( column % 3 == 0 && column != 0 )
				{
					System.out.print( "|" );
				}
				System.out.print( board[ row ][ column ] );
			}
			
			System.out.println();
		}
	}
	
	/**
	 * 				---- METHOD_DOES_NUMBER_EXIST_IN_ROW ----
	 * Does the number I'm looking for exist in the row
	 * 
	 * If, the board in that row that was passed in, at the current
	 * column of i that I'm iterating, if that number matches the 
	 * number I'm looking for, return true. Else return false
	 * 
	 * @param board
	 * @param num
	 * @param row
	 * @return
	 */
	private static boolean doesNumberExistInRow( int[][] board, int num, int row )
	{
		for ( int i = 0; i < GRID_SIZE; i++ )
		{
			
			if ( board[ row ][ i ] == num )
			{
				return true;
			}
		}
		
		// If, it doesn't exist return false
		return false;
		
	}
	
	/**
	 * 				---- METHOD_DOES_NUMBER_EXIST_IN_ROW ----
	 * Does the number I'm looking for exist in the column
	 * 
	 * Look at the board in row "i", and column, column. If 
	 * that number exists anywhere in that column, return 
	 * true. Else return false
	 * 
	 * @param board
	 * @param num
	 * @param column
	 * @return
	 */
	private static boolean doesNumberExistInColumn( int[][] board, int num, int column )
	{
		for ( int i = 0; i < GRID_SIZE; i++ )
		{
			
			if ( board[ i ][ column ] == num )
			{
				return true;
			}
		}
		
		// If, it doesn't exist return false
		return false;
		
	}
	
	/**
	 * 				---- METHOD_DOES_NUMBER_EXIST_IN_BOX ----
	 * Does the number I'm looking for exist in that 3x3 box
	 * 
	 * If, the board at row "i" in column "j", if that spot 
	 * matches the number I'm looking for, return true, else
	 * return false
	 * 
	 * @param board
	 * @param num
	 * @param row
	 * @param column
	 * @return
	 */
	private static boolean doesNumberExistInBox( int[][] board, int num, int row, int column )
	{
		
		// Variables
		int localBoxRow = row - row % 3;
		int localBoxColumn = column - column % 3;
		
		for ( int i = localBoxRow; i < localBoxRow + 3; i++ )
		{
			for ( int j = localBoxColumn; j < localBoxColumn + 3; j++ )
			{
				if ( board[ i ][ j ] == num )
				{
					return true;
				}
		
			}
		
		}
		
		return false;
		
	}
	
	/**
	 * 				---- VALID_PLACEMENT_METHOD ----
	 * Return, Not !doesNumberExistInRow Pass in parameters(int[][] board,
	 * number looking for, and row)
	 * Return, Not !doesNumberExistInColumn Pass in parameters(int[][] board,
	 * number looking for, and column)
	 * Return, Not !doesNumberExistInBox Pass in parameters(int[][] board,
	 * number looking for, row, and column)
	 * @param board
	 * @param number
	 * @param row
	 * @param column
	 * @return
	 */
	private static boolean isValidPlacement( int[][] board, int num, int row, int column )
	{
		return !doesNumberExistInRow( board, num, row ) &&
				!doesNumberExistInColumn( board, num, column ) &&
				!doesNumberExistInBox( board, num, row, column );
	}
	
	/**
	 * 				---- SOLVE_BOARD_METHOD ----
	 * @param board
	 * @return
	 */
	private static boolean solveBoard( int[][] board )
	{
		// NOTE: GRID_SIZE is 9x9
		for ( int row = 0; row < GRID_SIZE; row++ )
		{
			for ( int column = 0; column < GRID_SIZE; column++ )
			{
				if ( board[ row][ column ] == 0 )
				{
					for ( int trialNumber = 1; trialNumber <= GRID_SIZE; trialNumber++ )
					{
						if ( isValidPlacement( board, trialNumber, row, column ) )
						{
							board[ row ][column ] = trialNumber;
							
							/*
							 * 				---- RECURSIVE_ALGORITHM ----
							 * Recursively calling for solveBoard method. Filling-
							 * in the blanks, and/or replacing zero's with valid
							 * numbers.
							 */
							if ( solveBoard( board ) )
							{
								return true;
							}
							else
							{
								board[ row ][ column ] = 0;
							}
						}
					}
					
					return false;
				}
			}
		}
		
		return true;
	}

}
