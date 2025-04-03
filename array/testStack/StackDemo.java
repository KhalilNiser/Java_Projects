package array.testStack;

import java.util.Scanner;

public class StackDemo 
{

	public static void main(String[] args) 
	{
		// Accept input from the user
		Scanner scanner = new Scanner( System.in );
		
		int userChoice;
		
		Stack stack = new Stack();
		
		while ( true )
		{
			System.out.println( "\nSTACK MENU(Size -- 10)" );
			System.out.println( "1. Add an Element:" );
			System.out.println( "2. View the Top Element:" );
			System.out.println( "3. Remove the Top Element:" );
			System.out.println( "4. Display Stack Elements:" );
			System.out.println( "5. EXIT!" );
			System.out.println( "Select Your Choice: " );
			userChoice = scanner.nextInt();
			
			switch ( userChoice )
			{
			case 1:
				System.out.println( "Enter an Element: " );
				stack.push( scanner.nextInt() );
				break;
				
			case 2:
				System.out.printf( "The Top Element is: {%d}", stack.peek() );
				break;
				
			case 3:
				System.out.printf( "The Removed Element: {%d}", stack.pop() );
				break;
				
			case 4:
				stack.display();
				break;
				
			case 5:
				default:
				System.exit( 0 );
				break;
			}
			
			System.out.printf( "\n" );
		}

	}

}
