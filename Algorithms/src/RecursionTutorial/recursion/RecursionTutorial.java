
/**
 * @author Niser, Khalil (2023/05/27)
 * 
 * RecursionTutorial.recursion (RecursionTutorial)
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
 * 				---- SAY_Hi_PROGRAM_EXPLAINED ----
 * Here is what's happening. While your Java program is executing.
 * Everytime it enters a new method it puts the information for
 * that method on something called the "Call Stack". So at the 
 * beginning of your program when your "main" method starts, Java
 * puts all the information for the main method onto a "call Stack".
 * That information includes things like the name of the method, 
 * references to any variables that where passed-in, and things like 
 * that. Once that method finishes and your program leaves the method
 * Java takes that information off of the call Stack, Because it does
 * not need it anymore. And if that method was the main method at the 
 * bottom of the callStack, then your program exits and finishes.
 * But if Java is running that main method and it has the information f
 * or that method on the callStack, if inside that method it has to call
 * another method, Java adds the information for that method, onto the 
 * callStack to. And if that method calls on another method inside of it,
 * Java has to add that method that it calls onto the callStack to. This
 * process keeps on going and keeps on happening the deeper that method
 * calls go. But the thing is Java, only has so much memory allocated 
 * and information keep piling up until it over flows. And you get a 
 * "Stack over flow" error.
 * So you might be asking yourself, does that mean "recursion" is terrible
 * and every single time we try to use it, the program is going to blow up
 * and throw a "Stack over flow error"? Yes, unless you know how to code 
 * your recursive program right, so that it does Not happen. By creating
 * an "exit strategy".
 * 
 * 				---- HALTING_CONDITION ----
 * Just as loops can run into the problem of infinite looping, recursive 
 * functions can run into the problem of infinite recursion. Infinite 
 * recursion is when the function never stops calling itself. Every 
 * recursive function should have a halting condition, which is the 
 * condition where the function stops calling itself. In the previous 
 * example, the halting condition is when the parameter k becomes 0.
 * 
 */

package RecursionTutorial.recursion;

public class RecursionTutorial 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		/*
		 * NOTE: Change the 3, so the program can repeat 
		 * that same process 1000, times you will not get 
		 * a "stack over flow" error. But if I change the
		 * repeat process to 100000, I will get a "stack 
		 * over flow" error. 
		 * That is because Java's call stack memory is not 
		 * large enough to hold 100000 in memory allocated.
		 * 
		 * In this case just using a simple iteration with
		 * a for-loop or something is probably a better way
		 * to print-out "Hi", a "billion" times.
		 */
		sayHi( 1000 );

	}
	
	/**
	 * Add a parameter to my method (int count)
	 * @param count
	 */
	public static void sayHi( int count )
	{
		System.out.println( "Hi!" );
		
		/*
		 * If, count is less that or equal to 1, just return
		 * and exit the program, and not recursively call 
		 * itself (Like in this "Hi" example).
		 * 
		 * Together having a program where it has a "base case"
		 * where we don't call on the method recursively, and 
		 * have a code to allow that program to work towards that
		 * base case, make it so we don't get infinite recursion.
		 * NOTE: Every recursive algorithm must have those two 
		 * elements in order to NOT get a "Stack over flow".
		 * 
		 */
		if ( count <= 1 ) // START BASE CASE
		{
			return;
		} // END BASE CASE
		/*
		 * if, the count is greater than 1, keep on 
		 * running until reaches 1.
		 */
		sayHi( count - 1 );
	}

}
