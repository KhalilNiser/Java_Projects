package Stacks.palindrome;

import java.util.LinkedList;

public class Palindrome 
{

	public static void main(String[] args) 
	{
		// Should return true
		System.out.println( checkIfPalindrome( "abccba" ) );
		
		// Should return true
		System.out.println( checkIfPalindrome( "Was it a car, or a cat I saw" ) );
		
		// Should return true
		System.out.println( checkIfPalindrome( "I did did I" ) );
		
		// Should return false
		System.out.println( checkIfPalindrome( "Hello" ) );
		
		// Should return true
		System.out.println( checkIfPalindrome( "Race car" ) );
		
		// Should return false
		System.out.println( checkIfPalindrome( "Desserts" ) );
		
		// Should return true
		System.out.println( checkIfPalindrome( "Don't nod" ) );

	}
	
	public static boolean checkIfPalindrome( String string )
	{
		
		/*
		 * Creating my "stack" using the LinkedList class
		 */
		LinkedList< Character > stack = new LinkedList< Character >();
		
		/*
		 * I will append all the non-punctuation, non-space 
		 * characters, onto the StringBuilder. I will give 
		 * it a length of String.length
		 */
		StringBuilder stringNoPunctuation = new StringBuilder( string.length() );
		
		// Lowercase the given String
		String lowerCase = string.toLowerCase();
		
		/*
		 * Loops through the given String of lowercase 
		 * characters one by one
		 */
		for ( int i = 0; i < lowerCase.length(); i++ )
		{
			/*
			 * This gets me the character in the String
			 * with the index in position "i".
			 */
			char ch = lowerCase.charAt( i );
			
			/*
			 * If, the given character falls between "a" thru "z"
			 */
			if ( ch >= 'a' && ch <= 'z' )
			{
				/*
				 * Append the character to my stringNoPunction 
				 * StringBuilder
				 */
				stringNoPunctuation.append( ch );
				
				// Push the character onto my stack
				stack.push( ch );
			}
		}
		
		
		/*
		 * Create a reverseString with the size of the 
		 * length of my stack
		 */
		StringBuilder reverseString = new StringBuilder( stack.size() );
		
		while( !stack.isEmpty() )
		{
			/*
			 * Pop every character 'a' - 'z', and append them
			 * onto my reverseString, but this time without
			 * punctuation and empty spaces
			 */
			reverseString.append( stack.pop() );
		}
		
		/*
		 * Compare the reverseString with the stringNoPunctuation 
		 * (StringNoPunctuation, is the given String), if they are
		 * equal then the String is a palindrome
		 */
		return reverseString.toString().equals( 
				stringNoPunctuation.toString() );
		
	}

}
