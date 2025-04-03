
/**
 * @author Niser, Khalil (2023/07/16)
 * 
 * Factorial.iterativeFactorial: Factorial
 * 
 * 				---- FACTORIAL ----
 * The factorial of a non-negative integer n is the product of all positive 
 * integers less than or equal to n. It is denoted by n!. Factorial is 
 * mainly used to calculate the total number of ways in which n distinct 
 * objects can be arranged into a sequence.
 * 
 * For example,
 * 
 * The value of 5! is 120 as
 * 
 * 5! = 1 × 2 × 3 × 4 × 5 = 120
 * 
 * (5 distinct objects can be arranged into a sequence in 120 ways).
 * 
 * The value of 0! is 1
 * 
 * 				---- ITERATIVE_FACTORIAL ----
 * The iterative version uses a loop to calculate the product of all positive 
 * integers less than equal to n. Since the factorial of a number can be huge, 
 * the data type of factorial variable is declared as unsigned long.
 * 
 * 				---- TIME_COMPLEXITY ----
 * The time complexity of the above solution is O(n) and requires constant space.
 */

package Factorial.iterativeFactorial;

import java.util.Scanner;

public class Factorial 
{
	
	public static long factIterative( long number )
	{
		long factor = 1;
		
		for ( int i = 1; i <= number; i++ )
		{
			factor *= i;
		}
		
		return factor;
	}

	public static void main(String[] args) 
	{
		// Variables
		long userNumber;
		int result;
		
		// Scanner class object: Accepts user input
		Scanner scanner = new Scanner( System.in );
		
		System.out.println( "Please Enter a Non_Negative value!" );
		userNumber = scanner.nextLong();
		
		// Closes the input
		scanner.close();
		
		result = ( int ) factIterative( userNumber );
		
		// String Format
		System.out.printf( "%d! = %,d", userNumber, result );

	}

}
