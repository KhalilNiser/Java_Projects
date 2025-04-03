
/**
 * @author Niser, Khalil (04/08/2023)
 * data Structure Challenges: Palindrome ( Checking for Palindrome
 * using for loop/while loop and String Function charAt() )
 * 
 * 				---- PALINDROME_CHECK_USING_FOR_LOOP_WHILE_LOOP 
 * 				---- STRING_FUNCTION_CHAR_AT() ----
 * 
 * This is really a simple program. You just need to have a basic 
 * understanding of for loop and if..else statement to understand 
 * this program. Here, we are iterating over the string in reverse 
 * order (from length-1 to 0) and reading the corresponding 
 * character using charAt() method. These characters read in reverse 
 * order are appended to the reverseString. In the last step, similar 
 * to the above programs, the string and reverseString are compared to 
 * check if the input string is palindrome.
 */

package Stacks.palindrome;

import java.util.Scanner;

public class PalindromeLoopStatements 
{

	public static void main(String[] args) 
	{
		// Scanner class: Accepts input from the user
		Scanner scanner = new Scanner(System.in);

		// Variables
		String userInputStr;
		String reverseString = "";
		int length;

		System.out.println("Enter a String to Check if it is a "
				+ "Plaindrome: ");
		userInputStr = scanner.nextLine();
		
		length = userInputStr.length();
		
		for ( int i = length - 1; i >= 0; i-- )
		{
			reverseString += userInputStr.charAt( i );
		}
		
		if ( userInputStr.equals( reverseString ) )
		{
			System.out.println( "Input String is a Palindrome!" );
		}
		else
		{
			System.out.println( "Input String is \"NOT\" a Palindrome!" );
		}

	}

}
