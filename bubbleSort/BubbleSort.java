
/**
 * @author Niser, Khalil 09/24/2022
 * Data Structure: Bubble Sort Theory/Implementation
 * 
 * 				---- BUBBLE_SORT_THEORY ----
 * Outer loop, Start at the last index decrement. In other  words the sorted
 * partition is moving from right to left. The largest value in the array will 
 * be moved to the last index of the array, the index array shifts to one spot 
 * less. For example, if the array has 6 indices. Index 6 is sorted, while 
 * indices 0 - 5, are unsorted and so on, ..., . Until the loop reaches index 0, 
 * we stop. At this point all the values in the array are now sorted.
 * 
 * 				---- BIG_O_NOTATION/TIME_COMPLEXITY ----
 * ->	In-place algorithm
 * ->	O(n^2) time complexity Quadratic
 * ->	Stable algorithm
 */

package bubbleSort;

public class BubbleSort 
{

	public static void main(String[] args) 
	{
		// Array of integers
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22, -11 };
		
		// Print unsorted array
		System.out.println( "Unsorted Index: ");
		for( int i = 0; i < intArray.length; i++ )
		{
			System.out.print( intArray[ i ] + ", " );
		}
		System.out.println();
		
		/*
		 * Outer loop, Start at the last index decrement. In other 
		 * words the sorted partition is moving from right to left.
		 * The largest value in the array will be moved to the last
		 * index of the array, the index array shifts to one spot 
		 * less. For example, if the array has 6 indices. Index 6 is 
		 * sorted, while indices 0 - 5, are unsorted and so on, ..., .
		 * Until the loop reaches index 0, we stop. Meaning all the 
		 * values in the array are now sorted.
		 */
		for( int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0;
				lastUnsortedIndex-- )
		{
			/*
			 * Inner loop: I want to bubble the largest value in the array to the
			 * sorted position (which means the largest value is traversed to the 
			 * end of the array). Moving left to right. 
			 */
			for( int i = 0; i < lastUnsortedIndex; i++ )
			{
				/*
				 * If, i is greater than the value next to it, swap the values. 
				 * Because I want to bubble the largest value to the end of the 
				 * array.
				 */
				if( intArray[ i ] > intArray[ i + 1 ] )
				{
					swap( intArray, i, i + 1 );
				}
			}
		}
		
		// Print the sorted array
		System.out.println( "Sorted Array: ");
		for( int i = 0; i < intArray.length; i++ )
		{
			System.out.print( ", " + intArray[ i ]);
		}

	}
	
	// Swap method
	public static void swap( int[] intArray, int i, int j )
	{
		
		// Variables
		int temp;
		
		/* If, i == j, don't do anything, just return */
		if( i == j )
		{
			return;
		}
		
		/*
		 * Created a temporary variable called "temp". Let the value
		 * at "array[i]" equal to "temp". What was in "array[i]" now is in 
		 * "temp", "i" i.e. to "null". "Array[i]" == "array[j]": Now, the value 
		 * at "j" i.e. to "i", "j" i.e. to null. "array[j]" == temp: Now, the 
		 * value that was initially assigned to temp from "i" is now assigned to 
		 * "j", and "temp" is back to null.
		 * In conclusion what was in "array[j]", is now in "array[i]" and what was
		 * in "array[i]", is now in "array[j]".
		 */
		temp = intArray[ i ];
		intArray[ i ] = intArray[ j ];
		intArray[ j ] = temp;
	}

}
