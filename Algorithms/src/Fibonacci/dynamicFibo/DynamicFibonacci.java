
/**
 * @author Niser, Khalil (2023/06/16)
 * Fibonacci.dynamicFibo: DynamicFibonacci
 * 
 * 				---- FIBONACCI_SEQUENCE ----
 * Dynamic Programming Approach to Find and Print Nth Fibonacci Numbers:
 * 
 * Consider the Recursion Tree for 5th Fibonacci Number from the above approach:
 *
 *                        fib(5)   
 *                   /                \
 *              fib(4)                fib(3)   
 *            /        \              /       \ 
 *        fib(3)      fib(2)         fib(2)   fib(1)
 *       /    \       /    \        /      \
 * fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
 * /     
 * fib(1) fib(0)
 * 
 * 				---- OPTIMIZED_APPROACH ----
 * If you see, same method call is being done multiple times for the same value. 
 * This can be optimized with the help of Dynamic Programming. We can avoid the 
 * repeated work done in Recursion approach by storing the Fibonacci numbers 
 * calculated so far.
 * 
 * 				---- TIME_COMPLEXITY/AUXILARY_SPACE ----
 * Time complexity: O(n) for given n
 * Auxiliary space: O(n)
 * 
 * Below is the implementation of the above approach: 
 */

package Fibonacci.dynamicFibo;

public class DynamicFibonacci 
{
	
	/**
	 * 				---- FIBONACCI_METHOD ----
	 * Fibonacci series using Dynamic Programming
	 * @param num
	 * @return
	 */
	static int fibonacci( int num )
	{
		// Declare an Array to store Fibonacci Numbers
		
		// 1 extra to handle case, num = 0
		int[] fibo = new int[ num + 2 ];
		
		/* 0th and 1st numbers of the series are 0 and 1 respectively */
		fibo[ 0 ] = 0;
		fibo[ 1 ] = 1;
		
		// Iterate through the array of ints
		for ( int i = 2; i <= num;  i++ )
		{
			/*
			 * Add the previous two numbers in the series and 
			 * store them
			 */
			fibo[ i ] = fibo[ i - 1 ] + fibo[ i - 2 ];
			
		}
		
		return fibo[ num ];
		
	}

	public static void main(String[] args) 
	{
		int num = 9;
		
		System.out.println( fibonacci( num ));
	}

}
