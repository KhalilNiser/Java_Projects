
/**
 * @author Niser, Khalil (2023/07/15) 
 * 
 * recursion.Factorial 
 * 
 * 				---- FACTORIAL_USING_RECURSION ----
 * Java program to find the "Factorial" of a Number using recursion..
 * 
 * Factorial of a non-negative integer, is multiplication of all integers 
 * smaller than or equal to n. 
 * For example factorial of 6 is 6*5*4*3*2*1 which is 720.
 * 
 * 
 * 				---- RECURSIVE_METHOD ----
 * A method is said to be a recursive method if it calls itself directly or
 * indirectly.
 */

package Factorial.recursionFactorial;

import java.util.Scanner;

public class Factorial 
{
	/**
	 * 				---- FACTORIAL_USING_RECURSION ----
	 * 
	 * As we already know that the factorial of 0 or 1, the factorial is 1.
	 * As I have said before this is going to be a recursive method. At 
	 * some point this method should stop calling itself. And the factorial 
	 * of said numbers we stop multiplying when we reach the number 1. 
	 * For example: if the user enters 4. To find the factorial of 4, what we 
	 * to do is multiply (4! = 4 * 3 * 2 * 1). So I will have to make the 
	 * program stop the recursive process when it reaches 1.
	 * @param n
	 * @return
	 */
	static int factorial( int n )
	{
		// STOP AT 1: For numbers 1 & 0
		if ( n <= 1 )
		{
			return 1;
		}
		
		return n * factorial( n - 1 );
		
		/*
		 * If, the number is greater than 1, then we have to find the 
		 * factorial.
		 */
		
	}

	public static void main(String[] args) 
	{
		// Variables
		int userNumber;
		int result;
		
		// Object of Scanner class: Accepts user input
		Scanner scanner = new Scanner( System.in );
		
		System.out.println( "Please Enter a Non-Negative Value!" );
		userNumber = scanner.nextInt();
		
		// CLOSE THE INPUT
		scanner.close();
		
		result = factorial( userNumber );
		
		// String Format
		System.out.printf( "%d! = %,d", userNumber, result );

	}

}
