
/**
 * @author Niser, Khalil: (2023/06/14)
 * 
 * Fibonacci.recursiveFibo RecursiveFibonacci 
 * 
 * 				---- FIBONACCI_SEQUENCE ----
 * 
 * The Fibonacci numbers are the numbers in the following integer sequence:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, .........
 * 
 * Input  : n = 5
 * Output : 1
 * Input  : n = 9
 * Output : 34
 * 
 * 				---- IRETATIVE_APPROACH ----
 * Iretative Approach to Find and Print Nth Fibonacci Numbers
 * 
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the 
 * recurrence relation: F_{n} = F_{n-1} + F_{n-2}   with seed values and F_0 = 0   
 * and F_1 = 1.
 * 
 * 				---- TIME_COMPLEXITY/AUXILARY_SPACE ----
 * 
 * Time Complexity: O(n) 
 * Auxiliary Space: O(1)
 */

package Fibonacci.iretativeFibo;

public class IretativeFibonacci 
{
	
	/**
	 * 				---- FIBONACCI_METHOD ----
	 * Java program for Fibonacci series using Space Optimized Method
	 * @param num
	 * @return
	 */
	static int fibonacci( int num )
	{
		int a = 0;
		int b = 1;
		int c;
		
		if ( num == 0 )
		{
			return a;
		}
		
		for ( int i = 2; i <= num; i++ )
		{
			c = a + b;
			a = b;
			b = c;
			
		}
		
		return b;
		
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int num = 9;
		
		System.out.println( fibonacci( num ) );

	}

}
