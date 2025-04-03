package challenges.insertionSortRecursive;

public class IsertionSort_Recursion 
{

	public static void main(String[] args) 
	{
		// Integer Array
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22, -11 };

		System.out.println( "UNSORTED ELEMENTS: " );
		
		for ( int i = 0; i < intArray.length; i++ ) 
		{
			System.out.print( intArray[ i ] + ", " );
		}

		// Call on the isertionSort method
		insertionSort( intArray, intArray.length );
		
		System.out.println();
		System.out.println( "SORTED DATA ELEMENTS:" );
		
		for ( int i = 0; i < intArray.length; i++ ) 
		{
			System.out.print( intArray[i] + ", " );
		}
		
	}
	
	/**
	 * 				---- RECURSION ----
	 * Recursion, is a method that calls itself. I want to move some 
	 * the code into such a method.
	 * 
	 * It would be a nice idea to have method that I can call with the 
	 * number of items that I want to sort. Because if I start with the
	 * first two items and I sort them, then I sort the three items, and
	 * four items, and then five items, and then six items, and then 
	 * seven items, I would have ended up sorting the entire array.
	 * 
	 * I want to move my code into a method that accepts an array and 
	 * the number of items I want to sort.
	 * 
	 * So basically, instead of using a loop to increase the sorted 
	 * partition, from left to right, I'm using recursion, to increase 
	 * the sorted partition.
	 * 
	 * @param inputArray
	 * @param numItems
	 */
	public static void insertionSort( int[] inputArray, int numItems )
	{
		/*
		 * Break Point: An Insertion Sort with 1 item will 
		 * break the recursion
		 * 
		 * If I have only one item in the array. Array is sorted
		 */
		if ( numItems < 2 )
		{
			return;
		}
		
		/*
		 * What I'm doing here is an Insertion Sort with the same 
		 * inputArray, but with one less item.
		 */
		insertionSort( inputArray, numItems - 1 );
		
		int newElement = inputArray[ numItems - 1 ];
		
		int i;
		
		for ( i = numItems - 1; i > 0 && inputArray[ i - 1 ] 
				> newElement; i-- )
		{
			inputArray[ i ] = inputArray[ i - 1 ];
		}
		
		inputArray[ i ] = newElement;
		
		//System.out.println();
		System.out.println();
		System.out.println( "Result of call when numItems = " + numItems );
		
		for ( i = 0; i < inputArray.length; i++ )
		{
			System.out.print( inputArray[ i ] );
			System.out.print( ", " );
		}
		
		System.out.println( "" );
		
		// Divider to see what happens after each iteration
		System.out.println( "-----------------------------------" );
	}

}
