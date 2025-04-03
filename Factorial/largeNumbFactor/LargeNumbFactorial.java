
/**
 * @author Niser, Khalil (2023/07/17)
 * 
 * Data_Structure: Factorial.largeNumbFactor LargeNumbFactorial
 * 
 * 				---- LARGE_NUMBER_FACTORIAL ----
 * 
 * Why conventional way of computing factorial fails for large numbers?
 * A factorial of 100 has 158 digits. It is not possible to store these 
 * many digits even if we use long int. 
 * 
 * The idea is to use basic mathematics for multiplication.
 * 
 * Illustration:
 * 
 * -->	let x = 10
 * -->	Initialize carry = 0
 * 
 * 				---- STEPS_TO_SOLVE_THE_GIVEN_VALUE ----
 * Follow the steps below to solve the given problem:
 * 
 * a.	Create an array res[] of MAX size where MAX is a number of maximum 
 * digits in output. 
 * 
 * b.	Initialize value stored in res[] as 1 and initialize res_size 
 * (size of ‘res[]’) as 1. 
 * 
 * c.	Multiply x with res[] and update res[] and res_size to store the 
 * multiplication result for all the numbers from x = 2 to n.
 * 
 * d.	To multiply a number x with the number stored in res[], one by one 
 * multiply x with every digit of res[].
 * 
 * e.	To implement multiply function perform the following steps:
 * 
 * 		1.	Initialize carry as 0. 
 * 
 * 		2.	Do following for i = 0 to res_size – 1 
 * 
 * 			a.	Find value of res[i] * x + carry. Let this value be prod. 
 * 
 * 			b.	Update res[i] by storing the last digit of prod in it. 
 * 
 * 			c.	Update carry by storing the remaining digits in carry. 
 * 
 * 		3.	Put all digits of carry in res[] and increase res_size by the 
 * number of digits in carry.
 * 
 * Below is the implementation of the above algorithm.
 */

package Factorial.largeNumbFactor;

import java.util.Scanner;

public class LargeNumbFactorial 
{
	
/*				----JAVA_PROGRAM_TO_COMPUTE_FACTORIAL_OF_LARGE_NUMBERS ----*/
	
	/**
	 * 				---- FACTORIAL_METHOD ----
	 * This method finds the factorial of large numbers and stores them
	 * @param n
	 */
	static int factorial( int n )
	{
		// Initialize the array size to hold 500 digits
		int[] res = new int[ 500 ];
		
		// Initialize the result
		res[ 0 ] = 1;
		
		int resSize = 1;
		
		/*
		 * Apply simple factorial formula
		 * n! = 1 * 2 * 3 * 4... * n 
		 */
		for ( int x = 2; x <= n; x++ )
		{
			resSize = multiply( x, res, resSize );
		}
		
		System.out.println( "Factorial of the Given Number is: " );
		for ( int i = resSize - 1; i >= 0; i-- )
		{
//			System.out.printf( "%,d", res[ i ] );
			System.out.print( res[ i ] );
		}
		
		return res[ resSize ];
	}
	
	/**
	 * 				---- MULTIPLY_METHOD ----
	 * @param x
	 * @param res
	 * @param resSize
	 * @return
	 * 
	 * This method multiplies x with the number represented by res[].
	 * The variable resSize is the size of res[] or number of digits
	 * in the number represented by res[]. This method uses simple
	 * school mathematics for multiplication. This method may value
	 * of resSize and returns the new value of resSize
	 */
	static int multiply( int x, int[] res, int resSize )
	{
		// Variables 
		
		// Initialize carry
		int carry = 0;
		int prod;
		
		/*
		 * One by one, multiply n, with individual digits
		 * of res[].
		 */
		for ( int i = 0; i < resSize; i++ )
		{
			prod = res[ i ] * x + carry;
			
			// Store last digit of "prod" in res[]
			res[ i ] = prod % 10;
			
			// assign res[] o carry
			carry = prod / 10; 
		}
		
		/*
		 * Store carry in res, and increase resSize
		 */
		while ( carry != 0 )
		{
			res[ resSize ] = carry % 10;
			
			carry /= 10;
			
			resSize++;
		}
		
		return resSize;
	}

	public static void main(String[] args) 
	{
//		// Variables
//		int userNumber;
//		int result;
//		
//		// Scanner class object: Accepts user input
//		Scanner scanner = new Scanner( System.in );
//		
//		System.out.println( "Please Enter a Non-Negative Large Value: " );
//		userNumber = scanner.nextInt();
//		
//		scanner.close(); // CLOSES THE INPUT
//		
//		result = factorial( userNumber );
//		
//		// String Format
//		System.out.printf( "%d! = %,d", userNumber, result );
		
		factorial( 100 );

	}

}
