
/**
 * @author Niser, Khalil: (01/21/2023)
 * 
 * Data Structure: RadixSortStrings
 * 
 * 				---- RADIX_SORT_STRINGS ----
 * 
 * I)	Sort the following values using Radix Sort: "bcdef", "dbaqc", 
 * "abcde", "omadd", "bbbbb"
 * II)	All the values are in lowercase, so don't worry about upper-
 * casing/lowercasing the values
 * III)	You can start with the project in the resources section
 * 
 */

package challenges.stringRadixSort;

public class RadixSortStrings 
{

	public static void main(String[] args) 
	{
		// Array os Strings
		String[] strArray = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb" };
		
		System.out.println( "UNSORTED DATA:" );
		
		/*
		 * Traverse through the entire array
		 */
		for ( int i = 0; i < strArray.length; i++ )
		{
			System.out.print( strArray[ i ] + ", ");
		}
		
		System.out.println();
		
		System.out.println( "SORTED DATA:" );
		
		rdxSortStrings( strArray, 26, 5 );
		
		for ( int i = 0; i < strArray.length; i++ )
		{
			System.out.print( strArray[ i ] + ", " );
		}

	}
	
	/**
	 * /**
	 * 				---- CALL_METHOD (radixSingleSort) ----
	 * Here I will call radix SingleSort for each position in the 
	 * said values. So, I have a width of 5, so I'm going to loop
	 * four times and each time I call radixSingleSort it'll do 
	 * the sort based on one of the positions. (least significant 
	 * to most significant [going from right to left])
	 * 
	 * @param inputArray
	 * @param rdx
	 * @param width
	 */
	public static void rdxSortStrings( String[] inputArray, int rdx, int width )
	{
		for ( int i = width - 1; i >= 0; i-- )
		{
			rdxSingleSort( inputArray, i, rdx );
		}
	}
	
	public static void rdxSingleSort( String[] inputArray, int position, int rdx )
	{
		// Stores as many values as I am sorting
		int strItems = inputArray.length;
		
		/*
		 * Create a countArray large enough to hold all possible values.
		 * My countArray will consist of length 17 (0 - 16)
		 */
		int[] countArray = new int[ rdx ];
		
		/*
		 * For every value in my inputArray, I am going to count 
		 * how many values have a certain digit in whatever position 
		 * it is looking at. 
		 */
		for ( String value: inputArray )
		{
			/*
			 * Going to call getDigit method (0-9: For this specific
			 * formula I will be calling on the value in the 10's 
			 * position) and increment the count by one. I will pass 
			 * the position, the value, and the radix
			 */
			countArray[ getIndex( position, value ) ]++;
		}
		
		/*
		 * Adjusts the count array. At the end of this loop, the
		 * count would have been adjusted. Instead of containing 
		 * raw counts, it now contains the number of values that
		 * have that digit or less than that digit. In the 
		 * position we're working with
		 * 
		 * ---- STABLE_COUNTING_SORT ---- Part of Code
		 */
		for ( int j = 1; j < rdx; j++ )
		{
			countArray[ j ] += countArray[ j - 1 ]  ;
		}
		
		String[] temp = new String[ strItems ]; 
		
		for ( int tempIndex = strItems - 1; tempIndex >= 0; tempIndex-- )
		{
			temp[ --countArray[ getIndex( position, inputArray[ tempIndex ] 
					) ] ] = inputArray[ tempIndex ];
		}
		
		for ( int tempIndex = 0; tempIndex < strItems; tempIndex++ )
		{
			inputArray[ tempIndex ] = temp[ tempIndex ];
		}
		
	}
	
	/*
	 * Retrieves the first letter going right to left
	 * (letter with the least significant value)
	 */
	public static int getIndex( int position, String value )
	{
		return value.charAt( position ) - 'a';
	}

}
