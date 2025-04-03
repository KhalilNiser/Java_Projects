
/**
 * @author Niser, Khalil: (2023/06/14)
 * 
 * Fibonacci.recursiveFibo RecursiveFibonacci 
 * 
 * The Fibonacci numbers are the numbers in the following integer sequence:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, .........
 * 
 * Input  : n = 5
 * Output : 1
 * Input  : n = 9
 * Output : 34
 * 
 * 				---- RECURSIVE_APPROACH ----
 * Recursion Approach to Find and Print Nth Fibonacci Numbers:
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the 
 * recurrence relation: F_{n} = F_{n-1} + F_{n-2}   with seed values and F_0 = 0   
 * and F_1 = 1.
 * 
 * The Nth Fibonacci Number can be found using the recurrence relation shown above:
 * 
 * if n = 0, then return 0. 
 * If n = 1, then it should return 1. 
 * For n > 1, it should return Fn-1 + Fn-2
 * 
 * Below is the implementation of the above approach:
 * 
 * 				---- TIME_COMPLEXITY/AUXILARY_SPACE ----
 * 
 * Time Complexity: Exponential, as every function calls two other functions.
 * Auxiliary space complexity: O(n), as the maximum depth of the recursion tree is n.
 */

package Fibonacci.recursiveFibo;

import java.util.Scanner;

public class RecursiveFibinacci 
{
	
	/**
	 * 				---- FIBONACCI_METHOD ----
	 * Fibonacci Series using Recursion
	 * @param num
	 * @return
	 */
	static int fibonacci( int num )
	{
		if ( num <= 1 )
		{
			return num;
		}
		
		return fibonacci( num - 1 ) + fibonacci( num - 2 );
	}

	public static void main(String[] args) 
	{
		// Variable
		int num;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner( System.in );
		
		System.out.println( "Please Enter a Positive Integer: " );
		num = scanner.nextInt();
		
		System.out.println( num + "! = " + fibonacci( num ) );

	}

}
