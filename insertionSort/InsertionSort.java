
/**
 * @author Niser, Khalil 09/24/2022
 * Data Structure: Insertion Sort Theory/Implementation
 * 
 * 				---- INSERTION_SORT_THEORY ----
 * I)	firstUnsortedIndex = 1 - This is the first index of the unsorted 
 * partition
 * II)	i = 0 - Index used to traverse the sorted partition from right to 
 * left
 * 
 * III)	newElement = 35 - The value I want to insert into the sorted 
 * partition - array[firstUnsortedIndex]
 * 
 * 				---- BIG_O_NOTATION/TIME_COMPLEXITY ----
 * IV)	In-place algorithm
 * V)	O(n^2) time complexity Quadratic
 * VI)	It will take 100 steps to sort 10 items, 10,00 step to sort 100 
 * items, 1,000,000 steps to sort 1000 items.
 * VII)	Stable algorithm: It's stable because when I'm picking off elements 
 * I'm going from left to right. Let's say there is two 9's in the array, I
 * am going to insert the left most nine first. When it comes to the right 
 * most 9, remember that when I am looking for the inserted position, I stop 
 * when I hit an element that is less than or equal to the one I am inserting.
 * So when we're inserting the 9 we're eventually going to hit the first 9 we 
 * inserted into the sorted partition and that second 9 will be inserted to 
 * the right of the first 9.
 */

package insertionSort;

public class InsertionSort 
{

	public static void main(String[] args) 
	{
		// Integer Array
		int[] intArray = {20, 35, -15, 7, 55, 1, -22, -11};
		
		System.out.println( "Unsorted Elements: " );
		for(int i = 0; i < intArray.length; i++ )
		{
			System.out.print( ", " + intArray[ i ] + ", " );
		}
		
		/*
		 * Reason firstUnsortedIndex i.e. to 1, remember this 
		 * implementation starts out by assuming that the element 
		 * at position 0 (everything to the left of index "1"), is
		 * in the sorted partition.
		 */
		for( int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; 
				firstUnsortedIndex++ )
		{
			/*
			 * First thing I am going to do is save the value of the
			 * element we're going to insert into newElement. Because 
			 * when it's doing the shifting that position the element
			 * is going to be overridden
			 */
			int newElement = intArray[ firstUnsortedIndex ];
			
			int i;
			
			/*
			 * Reason "i" i.e. to unsorteIndex, because when I start the 
			 * element I want to insert is in the unsortedIndex "i". Keep 
			 * scrolling through the array as long as "i" > 0, that means 
			 * I haven't the front of the array. Assuming everything to the 
			 * left of the Element at position "1" is in the sorted position. 
			 * I want to keep looking as long as the element I am looking at 
			 * in the sorted partition > than the element I'm trying to insert.
			 */
			for( i = firstUnsortedIndex; i > 0 && intArray[ i - 1 ] > newElement; 
					i-- )
			{
				/*
				 * Assume I have done the first iteration and I want to shift 
				 * "-15" (The smallest element seeing so far), to the front of 
				 * the array at position "0". So I am effectively going to shift 
				 * 35 to position 2 of the array
				 */
				intArray[ i ] = intArray[ i - 1 ];
			}
			
			intArray[ i ] = newElement;
			
		}
		
		
		
		System.out.println();
		System.out.println( "Sorted Data Elements:");
		for( int i = 0; i < intArray.length; i++ )
		{
			System.out.print( ", " + intArray[ i ] );
		}

	}

}
