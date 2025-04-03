
/**
 * @author Niser, Khalil 09/24/2022
 * Data Structure: Bubble Sort
 * 
 * 				---- UNSORTED_ARRAY ----
 * intArray[] = {20, 35, -15, 7, 55, 1, -22}
 * ->	lastUnsortedIndex = 6 -- this is the last index of the unsorted 
 * partition.
 * ->	i = 1 -- index used to traverse the array form left to right.
 * ->	Largest = 0 -- index of largest element in unsorted partition.
 * 
 * Just like the Bubble sort the array will be partitioned from right to
 * left. So the lastUnsortedIndex is in index 6, "i" will be at 
 * position index "1", and the largest field will be at index "0", so at
 * first Java is like, 20 is the largest element I know of so far. So we 
 * start by comparing the element at position 1, to the element at position 
 * 0, "i" will be equal to 1. 35, is larger than 20 and because of that we 
 * will change largest field to index 1, and "i" will be at position 2.
 * 
 * ->	lastUnsortedIndex = 6 -- this is the last index of the unsorted 
 * partition.
 * ->	i = 2 -- index used to traverse the array form left to right.
 * ->	Largest = 1 -- index of largest element in unsorted partition.
 * 
 * Now, we compare -15 to the largest which is at position 1, -15, less 
 * than 35, so we are just going to increment "i" to 3. Now we compare 
 * 7 to 35, 7 is less than 35, so we are just going to increment "i" to 4.
 * Now, we compare 55 to 35, and 55 is greater than 35, so at this point we
 * are going to assign 55 to index 4, "i" will moved to position 5.
 * 
 * ->	lastUnsortedIndex = 6 -- this is the last index of the unsorted 
 * partition.
 * ->	i = 5 -- index used to traverse the array form left to right.
 * ->	Largest = 4 -- index of largest element in unsorted partition.
 * 
 * Now, we compare 1 to 55, well 1 is less than 55, so just increment "i"
 * to 6. Now, we compare -22 to 55, -22 is less than 55, so we don't do 
 * anything. So we move 55 to the lastUnsortedIndex spot and -22 to 
 * position "4". Now, our array length will shrink to 5, because 6 carry
 * the sorted element.
 * 
 * ->	lastUnsortedIndex = 5 -- this is the last index of the unsorted 
 * partition.
 * ->	i = 1 -- index used to traverse the array form left to right.
 * ->	Largest = 0 -- index of largest element in unsorted partition.
 * 
 * Then we will repeat the process until all the elements are in 
 * correct sorted position going from right to left.
 * 
 * ->	In-place algorithm 
 * ->	O(n^2) time complexity -- Quadratic.
 * ->	Doesn't require as much swapping as Bubble Sort. We only swap once 
 * per traversal.
 * ->	Unstable algorithm
 */

package selectionSort;

public class SelectionSort 
{

	public static void main(String[] args) 
	{
		// Array of integers
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22, -11 };
		
		System.out.println( "Unsorted Elements: " );
		for ( int i = 0; i < intArray.length; i++ )
		{
			System.out.print( ", " + intArray[ i ] );
		}
		
		for( int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0;
				lastUnsortedIndex-- )
		{
			// position of largest element in unsorted partition.
			int largest = 0;
			
			// Start with "i" at position "1", increment along the way
			for( int i = 1; i <= lastUnsortedIndex; i++ )
			{
				/*
				 * If, intArray[ i ], is greater than the largest value
				 * we know of so far. Let the largest equal to "i"
				 */
				if( intArray[ i ] > intArray[ largest ] )
				{
					largest = i;
				}
			}
			
			// Swap method swaps the values around
			swap( intArray, largest, lastUnsortedIndex );
		}
		
		System.out.println();
		System.out.println( "Sorted Elements: " );
		for( int i = 0; i < intArray.length; i++ )
		{
			System.out.print( ", " + intArray[ i ] );
		}

	}
	
	public static void swap( int[] intArray, int i, int j )
	{
		// Variable
		int temp;
		/* If, i == j, don't do anything, just return */
		if( i == j)
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
