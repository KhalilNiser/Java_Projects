
/**
 * @author Niser, Khalil (2022/11/13)
 * 
 * Data Structure: Recursion Theory/Implementation
 * 
 * 				---- FACTORIAL_ALGORITHM ----
 * I)	If number is equal to 0, the factorial is 1. Stop. We have 
 * the result. Otherwise...
 * II)	Set multiplier to 1.
 * III)	Set factorial to 1.
 * IV)	While multiplier is not equal to number, do steps 5 and 6
 * V)	Multiply factorial by multiplier and assign the result to
 * factorial
 * VI)	Add 1 to multiplier
 * VII)	Stop. The result is factorial
 */

package recursion;

public class Recursion 
{

	/**
	 * 				---- METHOD:_CODE_CALCULATOR ----
	 * 				---- ITERATIVE_FACTORIAL ----
	 * 
	 * Let's say I want to calculate 3! Numb is not equal to zero.
	 * Numb is set to 1. So I will start with the 1! 
	 * Index (i) has to be <= to 3, because the numb passed-in is 3.
	 * On the first iteration the loop factorial, factorial will be assigned 
	 * 1! [1 * 1 = 1], i will then become 2, factorial sets to [1 * 2 = 2].
	 * Then i becomes 3, factorial sets to [2 * 3 = 6]. At this point i sets 
	 * to 4, 4 is greater then numb input. It automatically drops-out and
	 * so it returns 6, as the answer.
	 * 
	 * @param args
	 */
	public static int iterativeFactorial( int numb )
	{
		// If num equal zero, return 1
		if ( numb == 0 )
		{
			return 1;
		}
		
		int factorial = 1;
		
		for ( int i = 1; i <= numb; i++ )
		{
			factorial *= i;
		}
		
		return factorial;
	}
	
	
	
	/**
	 * 				---- METHOD:_CODE_CALCULATOR ----
	 * 				---- RECURSIVE_FACTORIAL ----
	 * 
	 * Instead of using the loop I can have the method call itself.
	 * Because 2! is calculated as 1! * 2; 3! is calculated as 
	 * 2! * 3 = 6; 4! is calculated as 3! * 4 = 12
	 * 
	 * FACTORIAL: 
	 * I)	1! = 1 * 0! = 1
	 * II)	2! = 2 * 1 = 2; (2 * 1! = 2)
	 * III)	3! = 3 * 2 * 1 = 6; (3 * 2! = 6)
	 * IV)	4! = 4 * 3 * 2 * 1 = 24; (4 * 3! = 24)
	 * V)	5! = 5 * 4 * 3 * 2 * 1 = 120; (5 * 4! = 120)
	 * 
	 * @param args
	 */
	public static int recursiveFactorial( int numb )
	{
		// If num equal zero, return 1
		/*
		 * NOTE: In recursiveFactorial this conditional 
		 * if-statement is the "break condition (base case)"
		 */
		if ( numb == 0 )
		{
			return 1;
		}
		
		// Otherwise return number times the former recursiveFactorial 
		// n! = n * (n! - 1)!
		/*
		 * If current number (recursive factorial) minus 1 is not equal 
		 * to zero, push current number onto the "Stack", move over to 
		 * the next number down working in descending order (backwards)... 
		 * Until the said number at hand minus 1 returns zero (recursive 
		 * factorial). Then, it starts working its way pushing from the 
		 * top of the Stack until expected output return.
		 */
		return numb * recursiveFactorial( numb - 1 );
	}
	public static void main(String[] args) 
	{
		// Output Display
		System.out.println( "ITERATIVE_FACTORIAL:\n" + iterativeFactorial( 4 ) );
		System.out.println( "RECURSIVE_FACTORIAL:\n" + recursiveFactorial( 4 ) );

	}

}
