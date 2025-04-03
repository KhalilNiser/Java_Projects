package Stacks.demo;

import java.util.Scanner;

public class StackDemo 
{

	public static void main(String[] args) 
	{
		// Accept input from the user
		Scanner scanner = new Scanner(System.in);
		
		Stack stack = new Stack();
		
		while (true) 
		{
			System.out.println( "\nStack MENU(size -- 10)" );
			System.out.println( "1. Add an element" );
			System.out.println( "2. See the Top element." );
			System.out.println( "3. Remove top element." );
			System.out.println( "4. Display stack elements." );
			System.out.println( "5. Exit" );
			System.out.println( "Select your choice: " );
			int choice = scanner.nextInt();
			switch (choice) 
			{
			case 1:
				System.out.println("Enter an Element: ");
				stack.push(scanner.nextInt());
				break;

			case 2:
				System.out.printf("Top element is: {%d}", stack.peek());
				break;

			case 3:
				System.out.printf("Element removed: {%d}", stack.pop());
				break;

			case 4:
				stack.display();
				break;

			case 5:
			default:
				System.exit(0);
				break;
			}
			
			System.out.printf("\n");

		}
	}
}
