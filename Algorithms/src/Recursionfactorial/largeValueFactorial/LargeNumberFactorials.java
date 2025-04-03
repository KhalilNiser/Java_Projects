
/**
 * @author Niser, Khalil: (2023/06/27)
 * 
 * RecursionFactorial.largeValueFactorial: LargeNumberFactorials
 * 
 * 				---- FACTORIAL ----
 * Factorial of a non-negative integer, is multiplication of all integers smaller
 * than or equal to n. For example factorial of 6 is 6*5*4*3*2*1 which is 720.
 */

package Recursionfactorial.largeValueFactorial;

import java.math.BigInteger;

public class LargeNumberFactorials 
{
	
	public static void main(String[] args) 
	{
		int number = 60;
		
		BigInteger factorial = BigInteger.ONE;
		
		if ( number < 0 )
		{
			System.out.println( "Factorial of a Negative Value is Not Possible");
		}
		else if ( number <= 1 )
		{
			System.out.printf( "(%d!) = %d", 
					number, factorial );
		}
		else
		{
			/*
			 * Looping in Decrement fashion, multiply the largest value
			 * with the adjacent lesser value.
			 */
			for ( int index = number; index >= 2; index-- )
			{
				factorial = factorial.multiply( BigInteger.valueOf( index ) );
			}
			
			System.out.println();
			System.out.printf( "Number: (%d!)%nFactorial: %,d)", 
					number, factorial );
		}
	}

}
