package SortingAlgorithms.recursive;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortRecursiveApproach 
{

	public static void main(String[] args) 
	{
		// Variables
		int inputArraySize;

		// Object of Scanner class
		Scanner scanner = null;

		try 
		{
			System.out.println("Enter the Size of the Input Array");

			scanner = new Scanner(System.in);

			inputArraySize = scanner.nextInt();

			int[] inputArray = new int[inputArraySize];

			System.out.println("Enter " + inputArraySize + " Array Elements: ");

			for (int i = 0; i < inputArray.length; i++) 
			{
				inputArray[i] = scanner.nextInt();
			}

			System.out.println("Original Array: ");
			System.out.println(Arrays.toString(inputArray));

			int[] sortedArray = bubbleSort(inputArray, inputArraySize);

			System.out.println("Sorted Array: ");
			System.out.println(Arrays.toString(inputArray));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (scanner != null) 
			{
				scanner.close();
			}
		}

	}

	private static int[] bubbleSort(int[] inputArray, int inputArraySize) 
	{

		if (inputArraySize == 1) 
		{
			return inputArray;
		}
		
			for (int i = 0; i < inputArray.length - 1; i++) 
			{
				if (inputArray[i] > inputArray[i + 1])
				{
					// Swap the Ij elements
					int temp = inputArray[i];
					inputArray[i] = inputArray[i + 1];
					inputArray[i + 1] = temp;

				}
			}

		return bubbleSort( inputArray, inputArraySize - 1 );
	}

}
