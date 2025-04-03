
/**
 * @author Niser, Khalil: (2022/18/11)
 * Data Structure: MergeSort Theory/Implementation
 * 
 * 				---- MERGE_SORT_THEORY ----
 * I)	Divide and Conquer Algorithm
 * 
 * II)	Recursive Algorithm
 * 
 * III)	Two phases: Splitting and Merging
 * 
 * IV)	Splitting phase leads to faster sorting during the Merging phase.
 * The sorting is done during the Merging phase. The splitting phase is a
 * preparation phase, to make sorting faster during the Merging phase.
 * 
 * V)	Splitting is logical. No need to create new arrays. We use indices 
 * to keep track of where the array has been split.
 * 
 * 				---- MERGE_SORT - SPLITTING_PHASE ----
 * I)	Start with an Unsorted array
 * 
 * II)	Divide the array into 2 arrays, which are unsorted. The first array
 * is the left array. And the second array is the right array.
 * 
 * III)	Split the left and right array into two arrays each
 * 
 * IV)	Keep splitting until all the arrays have only one element each -
 * these arrays are sorted.
 * 
 * 				---- MERGE_SORT - MERGING_PHASE ----
 * I)	Merge every left /right pair of sibling array into a sorting array
 * 
 * II)	After the first merge, we'll have a bunch of 2-element sorted arrays
 * 
 * III)	Then merge those those sorted arrays (left/right siblings)to end-up 
 * with a bunch of 4-element sorted arrays
 * 
 * IV)	Repeat until you have a single sorted array
 * 
 * V)	Not in-place. Uses temporary arrays
 * 
 * 				---- MERGE_SORT_ALGORITHM_SEQUENCE ----
 * intArray[] = {20, 35, -15, 7, 55, 1, -22}
 * 
 * I)	Start = 0, end = 7 (array.length)
 * II)	Midpoint = (start + end ) / 2 = 3
 * III)	Elements 0 to 2 will go into the left array, and elements 3 to 6 
 * will go into the right array
 * 
 * 				---- LEFT_ARRAY ----
 * intArray[] = {20, -15, 35} {7, 55, 1, -15}
 * 
 * I)	Start = 0, end = 3 (array.length)
 * II)	Midpoint = (start + end ) / 2 = 1
 * III)	Elements 0 to 0 will go into the left array, and elements 1 to 2 
 * will go into the right array
 * 
 * intArray[] = {20, 35, -15} {7, 55, 1, -15}
 * 
 * I)	Start = 1, end = 3 (array.length)
 * II)	Midpoint = (start + end ) / 2 = 2
 * III)	Elements 1 to 1 will go into the left array, and elements 2 to 2 
 * will go into the right array
 * 
 * intArray[] = {20} {35} {-15} {7, 55, 1, -15}
 * 
 * We have completed the split of the left array into 1-elements array
 * 
 * 
 * 				---- RIGHT_ARRAY ----
 * intArray[] = {20, 35, -15} {7, 55, 1, -22}
 * 
 * I)	Start = 3, end = 7 (array.length)
 * II)	Midpoint = (start + end ) / 2 = 5
 * III)	Elements 3 to 4 will go into the left array, and elements 5 to 6 
 * will go into the right array
 * 
 * intArray[] = {20, 35, -15} {7, 55, 1, -22}
 * 
 * I)	Start = 3, end = 5 (array.length)
 * II)	Midpoint = (start + end ) / 2 = 4
 * III)	Elements 3 to 3 will go into the left array, and elements 4 to 4 
 * will go into the right array
 * 
 * intArray[] = {20, 35, -15} {7, 55, 1, -15}
 * 
 * I)	Start = 5, end = 7 (array.length)
 * II)	Midpoint = (start + end ) / 2 = 6
 * III)	Elements 5 to 5 will go into the left array, and elements 6 to 6 
 * will go into the right array
 * 
 * intArray[] = {20} {35} {-15} {7, 55, 1, -22}
 * 
 * We have completed the split of the left array into 1-elements array
 * 
 * intArray[] = {20, 35, -15, 7, 55, 1, -15}
 * 
 * ->	Splitting phase is complete
 * 
 * I)	35 and -15 are in sibling left/right arrays
 * II)	7 and 55 are in sibling left/right arrays
 * III)	1 and -22 are in sibling left/right arrays
 * IV)	Every left/right array is sorted (consisting of 1 element)
 * 
 * 
 * intArray[] = {20, 35, -15, 7, 55, 1, -22}
 * 
 * leftArray[] = {20, 35, -15}			rightArray[] = {7, 55, 1, -22}
 * 
 * leftArrayOfLeft[] = {20} rightArrayOfLeft[] = {35, -15}	
 * 
 * leftArrayOfRight[] = {7, 55} rightArrayOfRight[] = {1, -22}	
 * 
 * rightArrayOfLeftSplitLeftRight[] = {35} {-15}
 * 
 * leftArrayOfRightSplitLeftRight[] = {7} {55}
 * 
 * rightArrayOfRightSplitLeftRight[] = {1} {-22}
 * 
 * Merge all 1-element arrays {20, 35, -15, 7, 55, 1, -22}
 * 
 * I)	Now we have to merge all these 1-element arrays
 * II)	We always merge sibling left/right arrays
 * III)	Each merge array will be sorted
 * IV)	20 doesn't have a sibling
 * 
 * 				---- MERGING_PROCESS ----
 * I)	We merge sibling left and right arrays
 * 
 * II)	We create a temporary array large enough to hold all the elements
 * in the arrays we're merging: So on the first round our temporary arrays 
 * will be of length 2, because we are going to be merging two 1-element
 * arrays
 * 
 * III)	We set i to the first index of the left array, and j to the first
 * index of the right array. And when I say left and right array I mean
 * the two elements we're merging
 * 
 * IV)	We compare left[i] to right[j]. If left is smaller, we copy it to 
 * the temp array and increment i by 1. If right is smaller, we copy it to
 * the temp array and increment j by 1. 
 * 
 * V)	Repeat this process until all elements in the two arrays have been 
 * processed 
 * 
 * VI)	At this point, the temporary array contains the merged values in 
 * assorted order.
 * 
 * VII)	We then copy this temporary array back to the original input array,
 * at the correct position.
 * 
 * VIII)	If the left array is at positions x to y, and the right array is 
 * at positions y + 1 to z, then after the copy, positions x to z, will be
 * sorted in the original array.
 * 
 * intArray[] = {20, 35, -15, 7, 55, 1, -22}
 * 
 * I)	Start by merging the two siblings on the left (35 and -15)
 * II)	We'll create a temporary 2-element array
 * III)	"i" will be initialized to 1, and "j" to 2
 * IV)	We compare array[i] to array[j]. -15 is smaller than 35, so we copy 
 * it to the temp array.
 * V)	Then we copy 35 to the temp array
 * VI)	At this point, the temporary array is {-15, 35}
 * VII)	We now copy this temporary array back into positions 1 and 2 in the 
 * original array
 * 
 * 				---- BIG_O_NOTATION/TIME_COMPLEXITY ----
 * 				---- HOW_MERGE_SORT_PERFORMS ----
 * I)	NOT an in-place algorithm
 * II)	O(nlogn) - base 2. We are repeatedly dividing the array in half during
 * the splitting phase (logarithmic algorithm).
 * III)	Stable algorithm 
 */

package mergeSort;

public class MergeSort 
{
	// Merge sort method
	public static void mergeSort( int[] inputArray, int start, int end )
	{
		// Break point. If there is only 1 element. Return
		if ( end - start <= 1 )
		{
			return;
		}
		
		// Partitioning phase
		int mid = (start + end ) / 2;
		
		// Merge sort the left partition
		mergeSort( inputArray, start, mid );
		
		// Merge sort the right partition
		mergeSort(inputArray, mid, end );
		
		// Merge, both left/right partitions of the array
		merge( inputArray, start, mid, end );
	}
	
	// Merge method
	public static void merge( int[] inputArray, int start, int mid, int end )
	{
		
		// Variables
		int i = start;
		int j = mid;
		int tempIndex = 0;
		/*
		 * input[mid - 1] is the last element of the left partition, 
		 * while input[mid], is the first element of the right partition.
		 * If input[mid - 1] is less than or equal to input[mid], then 
		 * that means all the elements of the left partition are less than
		 * or equal to the smallest element of the right partition. Because 
		 * both partitions are "sorted", so the work is done
		 */
		if ( inputArray[ mid - 1 ]  <= inputArray[ mid ] )
		{
			return;
		}
		
		// Temp, is large enough hold all the elements in the array
		int[] temp = new int[ end - start ];
		/*
		 * When i = mid we have finished traversing the left array,
		 * drop out, or as soon as we finish traversing the right 
		 * array we want to drop out
		 */
		while ( i < mid && j < end )
		{
			/*
			 * Here I will step through the left and right arrays and 
			 * compare whatever is in index i of the left array with 
			 * whatever is in index j of the right array, and I will
			 * write the smaller of the two into the current position 
			 * in "temp". Which I am keeping track of with tempIndex.
			 * -----------------------------------------------------
			 * If input[i] is less than or equal to input[j], then I 
			 * want to write whatever is in "i" into the temp, and 
			 * increment "i". Otherwise I want to assign input[j++] 
			 * into temp, and increment "j".
			 * -----------------------------------------------------
			 * NOTE: Because Merge Sort is stable that's why the "=" 
			 * sign is there, if the element in the left array i.e. to 
			 * the element in the right array, then the element in the 
			 * left goes first. Making it a "stable" algorithm.
			 */
			temp[ tempIndex++ ] = inputArray[ i ] <= inputArray[ j ] ? 
					inputArray[ i++ ] : inputArray[ j++ ];
		}
		
		// Copy merged (left/right partitions) values back into the same positions
		System.arraycopy( inputArray, i, inputArray, start + tempIndex, mid - i );
		
		System.arraycopy( temp, 0, inputArray, start, tempIndex );
		
	}
	
	public static void main(String[] args) 
	{
		// Array of unsorted elements
		int[] numsArray = { 20, 35, -15, 7, 55, 1, -22 };
		
		System.out.println( "UNSORTED ELEMENTS:" );
		
		for ( int i = 0; i < numsArray.length; i++ )
		{
			System.out.print( numsArray[ i ] + ", " );
		}
		System.out.println();
		
		mergeSort( numsArray, 0, numsArray.length );
		
		System.out.println();
		
		System.out.println( "SORTED ELEMENTS:" );
		
		for ( int i = 0; i < numsArray.length; i++ )
		{
			System.out.print( numsArray[ i ] + ", ");
		}
		
	}

}
