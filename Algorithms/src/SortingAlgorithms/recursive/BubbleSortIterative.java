
/**
 * @author Niser, Khalil 05/25/2023
 * 
 * SortingAlgorithms.recursive: BubbleSort
 * 
 * 				---- BUBBLE_SORT_ITERATIVE ----
 * Java Bubble Sort using Iterative approach
 * 
 * Bubble Sort is the simplest sorting algorithm that works by 
 * repeatedly swapping the adjacent elements if they are not 
 * in a Sorted order
 * 
 * 
 * 				---- TIME_COMPLEXITY_ANALYSIS_OF_BUBBLE_SORT ----
 * 1.	Best Case: The best case occurs when the array is already 
 * sorted. So the number of comparisons required is N-1 and the 
 * number of swaps required = 0. Hence the best case complexity 
 * is O(N).
 * 2.	Worst Case: The worst-case condition for bubble sort occurs 
 * when elements of the array are arranged in decreasing order.
 * In the worst case, the total number of iterations or passes 
 * required to sort a given array is (N-1). where ‘N’ is the number 
 * of elements present in the array.
 * 
 * In this algorithm: 
 * 
 * 1.	traverse from left and compare adjacent elements and the higher 
 * one is placed at right side. 
 * 2.	In this way, the largest element is moved to the rightmost end 
 * at first. 
 * 3.	This process is then continued to find the second largest and 
 * place it and so on until the data is sorted.
 * 
 * At pass 1:
 * Number of comparisons = (N-1)
 * Number of swaps = (N-1)
 * 
 * At pass 2:
 * Number of comparisons = (N-2)
 * Number of swaps = (N-2)
 * 
 * At pass 3:
 * Number of comparisons = (N-3)
 * Number of swaps = (N-3)
 * 
 * At pass N-1:
 * Number of comparisons = 1
 * Number of swaps = 1
 * 
 * Now, calculating total number of comparison required to sort the array
 * = (N-1) + (N-2) +  (N-3) + . . . 2 + 1
 * = (N-1)*(N-1+1)/2  { by using sum of N natural Number formula }
 * = (N * (N-1)) / 2
 * 
 * 1.	In worst case, Total number of swaps = Total number of comparison
 * 2.	Total number of comparison (Worst case) = N(N-1)/2
 * 3.	Total number of swaps (Worst case) = N(N-1)/2
 * 
 * For the number of swaps, consider the following points:
 * 
 * 1.	If an element is in index I1 but it should be in index I2, then it 
 * will take a minimum of (I2-I1) swaps to bring the element to the 
 * correct position.
 * 2.	Consider an element E is at a distance of I3 from its position in 
 * sorted array. Then the maximum value of I3 will be (N-1) for the edge 
 * elements and N/2 for the elements at the middle.
 * 3.	The sum of maximum difference in position across all elements will be:
 * 
 * (N – 1) + (N – 3) + (N – 5) . . . + 0 + . . . + (N-3) + (N-1)
 * = N x (N – 2) x (1 + 3 + 5 + … + N/2)
 * = N2 – (2 x N2 / 4)
 * = N2 – N2 / 2
 * = N2 / 2
 * 
 * Therefore, in average case the number of comparisons is O(N^2)
 * 
 * 				---- TIME_COMPLEXITY_CHART ----
 * 
 * Constant: O(1)
 * Linear time: O(n)
 * Logarithmic time: O(n log n)
 * Quadratic time: O(n^2)
 * Exponential time: O(2^n)
 * Factorial time: O(n!)
 * 
 * 1.	O(1) - Excellent/Best
 * 2.	O(log n) - Good
 * 3.	O(n) - Fair
 * 4.	O(n log n) - Bad
 * 5.	O(n^2), O(2^n) and O(n!) - Horrible/Worst
 * 
 * 
 * 1.	When your calculation is not dependent on the input size, it 
 * is a constant time complexity (O(1)).
 * 2.	When the input size is reduced by half, maybe when iterating, 
 * handling recursion, or whatsoever, it is a logarithmic time 
 * complexity (O(log n)).
 * 3.	When you have a single loop within your algorithm, it is linear 
 * time complexity (O(n)).
 * 4.	When you have nested loops within your algorithm, meaning a loop 
 * in a loop, it is quadratic time complexity (O(n^2)).
 * 5.	When the growth rate doubles with each addition to the input, it 
 * is exponential time complexity (O2^n).
 */

package SortingAlgorithms.recursive;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortIterative 
{

	public static void main(String[] args) 
	{
		// Variables
		int inputArraySize;
		
		// Object of Scanner class
		Scanner scanner = null; 
		
		try
		{
			System.out.println( "Enter the Size of the Input Array" );
			
			scanner = new Scanner( System.in );
			
			inputArraySize = scanner.nextInt();
			
			int[] inputArray = new int[ inputArraySize ];
			
			System.out.println( "Enter " + inputArraySize + " Array Elements: " );
			
			for ( int i = 0; i < inputArray.length; i++ )
			{
				inputArray[ i ] = scanner.nextInt();
			}
			
			System.out.println( "Original Array: " );
			System.out.println( Arrays.toString( inputArray ));
			
			int[] sortedArray = bubbleSort( inputArray );
			
			System.out.println( "Sorted Array: " );
			System.out.println( Arrays.toString(inputArray));
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			if ( scanner != null )
			{
				scanner.close();
			}
		}

	}

	private static int[] bubbleSort( int[] inputArray )
	{
		boolean sorted = false;
		
		for ( int i = 0; i < inputArray.length - 1; i++ )
		{
			for ( int j = 0; j < inputArray.length - 1; j++ )
			{
				if ( inputArray[ j ] > inputArray[ j + 1 ] )
				{
					// Swap the Ij elements
					int temp = inputArray[ j ];
					inputArray[ j ] = inputArray[ j + 1 ];
					inputArray[ j + 1 ] = temp;
					
					sorted = true;
				}
			}
			
			if ( sorted != true )
			{
				break;
			}
		}
		
		return inputArray;
		
	}
}
