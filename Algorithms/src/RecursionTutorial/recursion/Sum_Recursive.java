
/**
 * @author Niser, Khalil (2023/05/27)
 * 
 * RecursionTutorial.recursion (Sum_Recursive)
 * Theory/Implementation
 * 
 * 				---- JAVA_RECURSION ----
 * Recursion is the technique of making a function call itself. This 
 * technique provides a way to break complicated problems down into 
 * simple problems which are easier to solve.
 * 
 * Recursion may be a bit difficult to understand. The best way to 
 * figure out how it works is to experiment with it.
 * 
 * 				---- RECURSION_EXAMPLE ----
 * Adding two numbers together is easy to do, but adding a range of 
 * numbers is more complicated. In the following example, recursion 
 * is used to add a range of numbers together by breaking it down 
 * into the simple task of adding two numbers:
 * 
 * 				---- EXAMPLE_EXPLAINED ----
 * When the sum() function is called, it adds parameter k to the sum 
 * of all numbers smaller than k and returns the result. When k 
 * becomes 0, the function just returns 0. When running, the program 
 * follows these steps:
 * (10 + sum(9)
 * 10 + ( 9 + sum(8) )
 * 10 + ( 9 + ( 8 + sum(7) ) )
 * ...
 * 10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + sum(0)
 * 10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + 0)
 * 
 * Since the function does not call itself when k is 0, the program 
 * stops there and returns the result.
 * 
 * 				---- HALTING_CONDITION ----
 * Just as loops can run into the problem of infinite looping, recursive 
 * functions can run into the problem of infinite recursion. Infinite 
 * recursion is when the function never stops calling itself. Every 
 * recursive function should have a halting condition, which is the 
 * condition where the function stops calling itself. In the previous 
 * example, the halting condition is when the parameter k becomes 0.
 * 
 * It is helpful to see a variety of different examples to better understand 
 * the concept. In this example, the function adds a range of numbers between 
 * a start and an end. The halting condition for this recursive function is 
 * when end is not greater than start:
 */

package RecursionTutorial.recursion;

public class Sum_Recursive 
{
	/**
	 * 				---- SUM_EXAMPLE ----
	 * Use recursion to add all of the numbers between 5 - 10
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public static int sum( int start, int end )
	{
		if ( end > start )
		{
			return ( end + sum( start, end - 1 ) );
		}
		else
		{
			return end;
		}
		
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int result = sum( 5, 10 );
		
		System.out.println( result );

	}

}
