
/**
 * @author Niser, Khalil (04/07/2023)
 * data Structure Challenges: Palindrome
 * 
 * 				---- PALINDROME_CHECK_USING_STACK ----
 * In this example, the user enters a string. The program iterates over 
 * the input string by running a loop from 1 to the length of the string  
 * and adds each character of the string to the stack using push() method.
 * 
 * Once all the characters of the given string are added to the stack. The
 * program runs a while loop until the stack is empty and at each iteration 
 * removes the last character of the string using pop() method and adds it 
 * to the reverseString variable.
 * 
 * The pop() method removes the last character from the stack. In the last
 * step it compares the string and the reverseString to check if the string
 * is palindrome or not.
 */

package Stacks.palindrome;

import java.util.Scanner;
import java.util.Stack;

public class PalStack 
{

	public static void main(String[] args) 
	{
		// Accepts input from the user
		Scanner scanner = new Scanner( System.in );
		
		// Variables
		String userInputStr;
		String reverseString;
		
		// Asking user for input
		System.out.println( "Enter a String: " );
		userInputStr = scanner.nextLine();
		
		// Instantiate an instance of Stack Class
		Stack stack = new Stack();
		
		/*
		 * Iterate through the length of the userInput, one
		 * character at a time. Starting with the first 
		 * character all the way to the last
		 */
		for ( int i = 0; i < userInputStr.length(); i++ )
		{
			stack.push( userInputStr.charAt( i ) );
		}
		
		reverseString = "";
		
		while( !stack.isEmpty() )
		{
			/*
			 * Pop every character from the stack and assign 
			 * it to a temporary variable called reverseString
			 */
			reverseString += stack.pop();
		}
		
		// Compare userInputString with the reverseString
		// Checking if palindrome or not
		if ( userInputStr.equals( reverseString ) )
		{
			System.out.println( "The input String is a Plaindroem!" );
		}
		else
		{
			System.out.println( "The input String is \"NOT\" a Plaindroem!" );
		}
	}

}
