
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
import java.util.Queue;
import java.util.Scanner;

public class PalQueue_UserInput 
{

	public static void main(String[] args) 
	{
		// Scanner class: Accepts input from the user
		Scanner scanner = new Scanner( System.in );
		
		// Variables
		String userInputString;
		
		// Method reverse a String assigned
		String reverseString = "";
		
		System.out.println( "Enter a String!" );
		userInputString = scanner.nextLine();
		
		// Instantiating Queue: LinkedList Class methods
		Queue queue = new LinkedList();
		
		/*
		 * Iterate/retrieve through every character of the userInput, 
		 * one character at a time. Starting with the last character 
		 * all the way to the first
		 */
		for ( int i = userInputString.length() - 1; i >= 0; i-- )
		{
			queue.add(userInputString.charAt( i ) );
		}
		
		while ( !queue.isEmpty() )
		{
			/*
			 * While the queue is Not empty, remove every character 
			 * from the stack and assign it to a temporary variable 
			 * called reverseString
			 */
			reverseString += queue.remove();
//			reverseString = reverseString + queue.remove();
		}
		
		/*
		 * Compare userInputString with the reverseString 
		 * Checking if palindrome or not
		 */
		if ( userInputString.equalsIgnoreCase(reverseString) )
		{
			System.out.println( "The Input String is a Palindrome!" );
		}
		else
		{
			System.out.println( "The Input String is \"NOT\" a Palindrome!" );
		}

	}

}
