
/**
 * @author Niser, Khalil: (2022/09/12)
 * Data Structure: CountSort Theory/Implementation
 * 
 * 				---- COUNT_SORT_THEORY ----
 * NOTE: Every Algorithm looked at so far don't make any assumptions 
 * about the data their sorting. They can sort integers, floats, 
 * doubles, Strings, objects, anything. The algorithms don't assume 
 * a certain data type, specific implementations do, but not the 
 * algorithms themselves. They also don't assume that the data being 
 * sorted is bound in any way. For example, they don't assume that
 * the values being sorted will be less than 100. 
 * There are algorithms that do make assumptions about the data being 
 * sorted, and because they make assumptions they can sort the data  
 * more efficiently. In fact they can achieve linear time O(n) 
 * complexity. So the next couple of algorithms we're going to look at 
 * "make assumptions" about the data their sorting. And the first 
 * algorithm is "CountSort".
 * 
 * I)	Makes assumption about the data: It assumes that all the values 
 * are discrete, and they're within a specific range. So this algorithm
 * with non-negative discrete values. We can't sort floats, Strings, 
 * because they don't have discrete values. So practically speaking 
 * you only use this algorithm with whole numbers
 * 
 * II)	Doesn't use comparisons 
 * III) Counts the number of occurrences of each value
 * IV)	Only works with non-negative discrete values (Cannot work with
 * floats, doubles, Strings)
 * V)	Values must be within a specific range
 * 
 * 
 * 				---- COUNTING_SORT ----
 * I)	Assume we have values between 1 and 10 inclusive
 * II)	We have 10 possible values, so we create a counting array of 
 * length 10
 * III)	Traverse the input array from left to right
 * IV)	Use the counting array to track how many of each value are in 
 * the input array
 * V)	Using the counts in the counting array, write the values in 
 * sorted order to the input array
 * 
 * 
 * 				---- TIME_COMPLEXITY_BIG-O_NOTATION ----
 * I)	NOT an in-place algorithm
 * II)	O(n) -- Can achieve this because we're making assumptions 
 * about the data we're sorting: Because this algorithm is making 
 * assumptions about the data it's sorting, it can achieve this in 
 * linear time.
 * III)	If we want the sort to be stable, we have to do some extra 
 * steps
 */
 
package countSort;

public class CountSort 
{

	public static void main(String[] args) 
	{
		// Array of unsorted data values
		int[] intArray = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };
		
		System.out.println( "UNSORTED DATA:" );
		
		/*
		 * Traverses through the entire array 
		 */
		for ( int i = 0; i < intArray.length; i++ )
		{
			// Displays the output of data
			System.out.print( intArray[ i ] + ", " );
		}
		System.out.println();
		
		countingSort( intArray, 1, 10 );
		
		System.out.println( "SORTED DATA:" );
		
		for ( int i = 0; i < intArray.length; i++ )
		{
			System.out.print( intArray[ i ] + ",  ");
		}

	}
	
	// Method for counting sort
	public static void countingSort( int[] inputArray, int min, int max )
	{
		/*
		 * Counting Array: This array keeps track of the count.
		 * This array has to be large enough to count each possible
		 * value. 
		 * For example: I have an array of 10 values. My "max" is 10 and
		 * my "min" is 1, This method will work as ( (10 - 1) + 1) = 10
		 */
		int[] countArray = new int[ ( max - min ) + 1 ];
		
		/*
		 * traverses the array counting the amount of values it carries.
		 * Translating the value being counted it's original index, and  
		 * increment the current position.
		 */
		for ( int i = 0; i < inputArray.length; i++ )
		{
			countArray[ inputArray[ i ] - min ]++; 
		}
		
		/*
		 * Finished counting now, I want to write the values back 
		 * to the inputArray.
		 */
		int j = 0;
		
		for ( int i = min; i <= max; i++ )
		{
			while( countArray[ i - min ] > 0 )
			{
				inputArray[ j++ ] = i;
				countArray[ i - min ]--;
			}
		}
	}
}
