
/**
 * @author Niser, Khalil (04/21/2023)
 * Data Structure Challenges: PalQueue_UserInput (Palindrome Check 
 * using Queue)
 * 
 * 				---- PALINDROME_CHECK_USING_QUEUE ----
 * In this example, I am using Queue to reverse the given string. 
 * Each character of the string is read by using String charAt() 
 * method. These characters are added to the Queue using add() 
 * method. Once all the characters are added. We are iterating 
 * the Queue and removing the last character of the Queue using 
 * remove() method and appending it to the reverseString.
 */

package Queues.palindrome;

import java.util.LinkedList;

public class PalindromeQueue 
{

	public static void main(String[] args) 
	{
		// Should return true
		System.out.println(checkIfPalindrome("abccba"));

		// Should return true
		System.out.println(checkIfPalindrome("Was it a car, or a cat I saw"));

		// Should return true
		System.out.println(checkIfPalindrome("I did did I"));

		// Should return false
		System.out.println(checkIfPalindrome("Hello"));

		// Should return true
		System.out.println(checkIfPalindrome("Race car"));

		// Should return false
		System.out.println(checkIfPalindrome("Desserts"));

		// Should return true
		System.out.println(checkIfPalindrome("Don't nod"));

	}
	
	public static boolean checkIfPalindrome( String string )
	{
		/*
		 * Creating my "queue" and "stack" using the LinkedList class
		 */
		LinkedList< Character > queue = new LinkedList< Character >();
		LinkedList< Character > stack = new LinkedList< Character >();
		
		// Lowercase the Given String
		String lowercase = string.toLowerCase();
		
		/*
		 * Loops through the given String of lowercase 
		 * characters one by one
		 */
		for ( int i = 0; i < lowercase.length(); i++ )
		{
			/*
			 * This gets me the character in the String
			 * with the index in position "i".
			 */
			char ch = lowercase.charAt( i );
			
			/*
			 * If, the given character falls between "a" thru "z"
			 */
			if ( ch >= 'a' && ch <= 'z' )
			{
				// Added last on to the "Queue"
				queue.addLast( ch );
				
				// Push on to the "Stack"
				stack.push( ch );
			}
		}
		
		// While the stack is not empty
		while ( !stack.isEmpty() )
		{
			/*
			 * While the popped from the stack, is Not equal
			 * to the what's removed first from the queue
			 */
			if ( !stack.pop().equals(queue.removeFirst() ) )
			{
				return false;
			}
		}
		
		return true;
		
	}

}
