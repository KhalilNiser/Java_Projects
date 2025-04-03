package SortingAlgorithms.recursive;

public class InsertionSortRecursive 
{

	public static void main(String[] args) 
	{
		// Variables Array
		int[] arr = { 56, 43, 23, 78, 12 };
		
		System.out.println( "---- INITIAL_ARRAY_VALUES ---- ");
		
		printArray( arr );
		
		int n = arr.length;
		
		insertionSortRecursive( arr, n );
		
		System.out.println( "---- SORTED_ARRAY_VALUES ---- " );
		printArray( arr );

	}
	
	/**
	 * 				---- INSERTION_SORT_RECURSIVE_METHOD ----
	 * @param array (Array of integers)
	 * @param n (Length of the Values)
	 */
	public static void insertionSortRecursive( int[] arr, int n )
	{
		if ( n <= 1 )
		{
			return;
		}
		
		insertionSortRecursive( arr, n - 1 );
		
		// First value counting backwards right to left
		int key = arr[ n - 1 ];
		
		// Second value counting backwards right to left
		int j = n - 2;
		
		System.out.println( "STEP " + (n - 1) + ": KEY VALUES (" + key + ")" );
		printArray( arr );
		
		while ( j >= 0 && arr[ j ] > key )
		{
			arr[ j + 1 ] = arr[ j ];
			
			j--;
			printArray( arr );
		}
		
		arr[ j + 1 ] = key;
		printArray( arr );
		
	}
	
	/**
	 * 				---- PRINTARRAY_METHOD ----
	 * @param arr
	 */
	public static void printArray( int[] arr )
	{
		
		for ( int i = 0; i < arr.length; i++ )
		{
			System.out.print( arr[ i ] + "   ");
		}
		
		System.out.println();
		
	}

}
