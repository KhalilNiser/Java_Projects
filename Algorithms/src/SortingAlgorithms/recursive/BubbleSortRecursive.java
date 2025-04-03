
/**
 * @author Niser, Khalil: 05/25/2023
 * 
 * SortingAlgorithms.recursive: BubbleSort
 * 
 * 
 * 				---- BUBBLE_SORT ----
 * 
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly 
 * swapping the adjacent elements if they are in wrong order.
 * 
 * Java program for Recursive implementation of BubbleSort		
 * 
 * For Example: 
 * First Pass: 
 * ( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two 
 * elements, and swaps since 5 > 1. 
 * ( 1 5 4 2 8 ) –> ( 1 4 5 2 8 ), Swap since 5 > 4 
 * ( 1 4 5 2 8 ) –> ( 1 4 2 5 8 ), Swap since 5 > 2 
 * ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in 
 * order (8 > 5), algorithm does not swap them.
 * 
 * Second Pass: 
 * ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
 * ( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2 
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) 
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) 
 *
 * Now, the array is already sorted, but our algorithm does not know if it 
 * is completed. The algorithm needs one whole pass without any swap to 
 * know it is sorted.
 * 
 * Third Pass: 
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) 
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) 
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) 
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 * 
 * See Bubble Sort for more details.
 * How to implement it recursively? 
 * Recursive Bubble Sort has no performance/implementation advantages, but can 
 * be a good question to check one’s understanding of Bubble Sort and recursion.
 * If we take a closer look at Bubble Sort algorithm, we can notice that in 
 * first pass, we move largest element to end (Assuming sorting in increasing 
 * order). In second pass, we move second largest element to second last 
 * position and so on. 
 * 
 * Recursion Idea.  
 * 1.	 Base Case: If array size is 1, return.
 * 2.	Do One Pass of normal Bubble Sort. This pass fixes last element of 
 * current subarray.
 * 3.	Recur for all elements except last of current subarray.
 * 
 * Below is the implementation of above idea.
 * 
 */

package SortingAlgorithms.recursive;

public class BubbleSortRecursive 
{

	/**
	 * ---- BUBBLE_SORT_METHOD ---- 
	 * This method will implement the BubbleSort
	 * 
	 * @param arr
	 * @param n
	 */
	static void bubbleSort(int[] arr, int n) 
	{
		// BASE CASE
		if (n == 1) 
		{
			return;
		}

		int count = 0;

		/*
		 * First Pass of BubbleSort. After this pass, the 
		 * largest element is moved (bubbled) to the end 
		 * of the list array
		 */
		for (int i = 0; i < n - 1; i++) 
		{
			if (arr[i] > arr[i + 1]) 
			{
				// Swap arr[ i ], arr[ i + 1 ]
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;

				count = count + 1;
			}
		}

		/*
		 * Check if any recursion happens or not. If, 
		 * no recursion is happening return
		 */
		if (count == 0) 
		{
			return;
		}

		/*
		 * Largest element is fixed, recur for the 
		 * remaining elements in the array
		 */
		bubbleSort(arr, n - 1);
	}

	public static void main(String[] args) 
	{
		// Array of integers
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

		System.out.println("---- UNSORTED_DATA_ELEMENTS ----");
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.print(arr[i] + ", ");
		}

		System.out.println();
		bubbleSort(arr, arr.length);

		System.out.println();
		System.out.println("---- SORTED_DADA_ELEMENTS ----");

		// Print output iteratively
		// System.out.println( Arrays.toString( arr ) );

		// Print output using for-loop statement
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.print(arr[i] + ", ");
		}

	}

}
