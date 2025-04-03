
/**
 * @author Niser, Khalil (2023/05/31)
 * Lottery.lottery: Lottery 
 * 
 * 				---- LOTTERY ----
 * I am going to write a complete program from scratch to play the "Lottery"
 * in Java. It will randomly generate six winning numbers, and allow the user 
 * to input their six lottery numbers. See Specifications below:
 * 
 * 				---- PLAY_THE_LOTTO ----
 * 1.	Please enter your 6 numbers between 1 - 49
 * Your current numbers are: []
 * Please enter a number (1 - 49): 
 * 16
 * 
 * 2.	Your current numbers are: [ 16 ]
 * Please enter a number (1 - 49): 
 * 24
 * 
 * 3.	Your current numbers are: [ 16, 24 ]
 * Please enter a number (1 - 49): 
 * 35
 * 
 * 4.	Your current numbers are: [ 16, 24, 35 ]
 * Please enter a number (1 - 49): 
 * 49
 * 
 * 5.	Your current numbers are: [ 16, 24, 35, 49, 1 ]
 * Please enter a number (1 - 49): 
 * 1
 * 
 * 6.	Your current numbers are: [ 16, 24, 35, 49, 1 ]
 * Please enter a number (1 - 49): 
 * 13
 * 
 * 7.	The Winning Numbers are: [ 31, 42, 1, 39, 3, 4 ]
 * Your Numbers are: [16, 24, 35, 49, 1, 13 ]
 * Your Matching Numbers are: [ 1 ]
 * Sorry, You Did Not Win
 * 
 * NOTE:  I will also go over the ODDS of you winning the lottery.
 * Repeated Numbers are Not Allowed
 * 
 */

package Lottery.lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lottery 
{

	/**
	 * 				---- ODDS_OF_WINNING_LOTTO ----
	 * ODDS of getting all the numbers correct and in the correct order
	 * 1 in (49 * 48 * 47 * 46 * 45 * 44) = 10,068,347,520
	 * 
	 * Number of ways that these six numbers can be ordered are Factorial of 6
	 * 6! 6 * 5 * 4 * 3 * 2 * 1 = 720
	 * 
	 * ODDS of getting all the numbers correct regardless of the correct order
	 * 10,068,347,520 / 720 = 13,983,816
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		/*
		 * 				---- VARIABLES/PARAMETES/ARGUMENT ----
		 * List of integers (winningNumbers): Holds the winning numbers 
		 * that Java randomly creates
		 */
		int userInputLotteryNumber;
		
		List< Integer > compGeneratedWinningNumbers = new ArrayList<>();
		
		// Random Class: Generates the random numbers
		Random random = new Random( );
		
		
		// Generate 6 different random numbers from 1 - 49, six times
		for ( int i = 0; i < 6; i++ )
		{
			/*
			 * Now that I have my new random winning number, I have to check 
			 * whether this winning number is already in this list, and if it 
			 * is in the list then, I don't want to add it. But I want to make
			 * sure to try again until I get a different number. To do that I
			 * wrap the code around a "while-loop" statement
			 * 
			 * Basically I'm just saying if this value is Not in the "List",
			 * then it is not a duplicate, so it can be added to the list of
			 * winning numbers.
			 * Relate to parameter.add( argument ) part of code below
			 */
			while ( true )
			{
				/*
				 * What I am doing here: By default in Java the "nextInt" method 
				 * generates 6 random numbers (1 - 49), always starting from 0 - 48.
				 * So when I type the code "random.nextInt( 49 ) + 1;". I am asking
				 * Java to give me 6 random numbers but this time start from 1, and 
				 * end at 49. And store the userInputNumber in userInputLotteryNumber
				 */
				userInputLotteryNumber = random.nextInt( 49 ) + 1; 
				
				if ( !compGeneratedWinningNumbers.contains( userInputLotteryNumber ) )
				{
					compGeneratedWinningNumbers.add( userInputLotteryNumber );
					
					break;
				}
			}
			
		}
		
		/*
		 * Computer generated (compGeneratedWinningNumbers)
		 */
//		System.out.println( compGeneratedWinningNumbers );
		
		/*
		 * User generated 6 random numbers (userInputLotteryNumbers)
		 */
		System.out.println( "Please Enter your 6 numbers between 1 - 49 Inclusively" );
		
		Scanner scanner = new Scanner( System.in );

		List< Integer > guessedNumbers = new ArrayList<>();
		
		for ( int i = 0; i < 6; i++ )
		{
			
			System.out.println( "Current Numbers you Have Entered are: " + guessedNumbers );
			System.out.println( "Please Enter another Number (1 - 49");
			
			while ( true )
			{
				try
				{
					// Scanner class accepts keyboard input from the user
					// Assigning the user's input to numberString
					String numberString = scanner.nextLine();
					
					/*
					 * This "Integer.parseInt" method, takes the user's input 
					 * as a String and convert's to them to an integer
					 */
					int number = Integer.parseInt( numberString );
					
					if ( number >= 1 && number <= 49 )
					{
						/*
						 * Assign/Add the parsed user's input to guessedNumber
						 */
						guessedNumbers.add(number);
						
						break;
					}
					else
					{
						System.out.println( number + ", Is Not (1 - 49). Please try Again!" );
					}
				}
				catch ( NumberFormatException nfe )
				{
					System.out.println( "Invalid Number Entered. Please Try Again!" );
				}
			}
		}
		
		System.out.println( "The Winning Numbers Are: " + compGeneratedWinningNumbers );
		
		System.out.println( "Your Numbers are: " + guessedNumbers );
		
		/*
		 * Takes our winningNumbers list and filters-out all the
		 * elements in the list that are not in the winning list
		 */
		guessedNumbers.retainAll(compGeneratedWinningNumbers);
		
		System.out.println( "Your matching Numbers are: " + guessedNumbers );
		
		if ( guessedNumbers.containsAll( compGeneratedWinningNumbers ) )
		{
			System.out.println( "Congradulations! You are a Winner! " );
			
		}
		else
		{
			System.out.println( "Sorry, you Lost!" );
		}
		
		scanner.close();
	
	}

}
