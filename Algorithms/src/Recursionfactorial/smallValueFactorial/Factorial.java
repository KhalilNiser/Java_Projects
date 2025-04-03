
/**
 * @author Niser, Khalil: (2023/06/26)
 * 
 * RecursionFactorial.smallValueFactorial: Factorial
 * 
 * 				---- FACTORIAL ----
 * Factorial of a non-negative integer, is multiplication of all integers smaller
 * than or equal to n. For example factorial of 6 is 6*5*4*3*2*1 which is 720.
 */

package Recursionfactorial.smallValueFactorial;

public class Factorial 
{
	/**
	 * 				---- FACTORIAL_METHOD ----
	 * @param n
	 * @return Returns the resulting factorial of a number. I want the
	 * program to take the factorial of any number. User should be able 
	 * to input any value into this method.
	 */
	public static int factorial( int n )
	{
		/*
		 * BASE CASE: Tell the program when to stop. 
		 * NOTE: Base Case is the biggest and most important part 
		 * of recursion. The base Case is 1, it will return 1. 
		 */
		if ( n == 1 )
		{
			System.out.println( "Factorial( " + n + "!) = 1 " );
			return 1;
		}
		else
		{
//			System.out.println( "Factorial( " + n + "!) = " + n + 
//					" * Facorial( " + ( n - 1 ) + " ) " );
			System.out.println();
			System.out.printf( "Factorial(%3d!) = %3d! * Factorial(%3d!)", 
					n, n, (n - 1) );
			return n * factorial( n - 1 );
		}
	}

	public static void main(String[] args) 
	{
		/*
		 * Five times 4! factorial ( 5! = 5 * (4 * 3 * 2 * 1)
		 */
		System.out.println( factorial( 3 ) );

	}

}
