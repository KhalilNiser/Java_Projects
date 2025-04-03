
/**
 * @author Niser, Khalil (2023/06/11)
 * 
 * Binary.recursiveBinarySearch: RecursiveBinarySearch
 * 
 * 
 * 				---- BINARY_SEARCH ----
 * Binary search is a searching algorithm that finds the position of a target 
 * value within a "sorted array". It works by repeatedly dividing the array in 
 * half and comparing the target value to the middle element of each subarray. 
 * It reduces the time complexity to O(log N), where N is the number of 
 * elements in the array.
 * 
 * 				---- ITERATIVE_VS_RECURSIVE ----
 * There are two ways to implement binary search: iterative and recursive. The 
 * iterative method uses a while loop to continue the process of comparing and 
 * splitting, while the recursive method uses a function that calls itself with 
 * smaller subarrays until the base case is reached.
 * 
 * For this project I will write the source code using the Recursive method.
 */

package Binary.recursiveBinarySearch;

public class RecursiveBinarySearch 
{

	public static void main(String[] args) 
	{
		// Array of integers
		int[] intsArray = { 1, 2, 4, 5, 7, 9, 11 };
		
//		System.out.println( "0, is at Position: " + binarySearch( intsArray, 0, 0, intsArray.length ) );
		System.out.println( "1, is at Position: " + binarySearch( intsArray, 1, 0, intsArray.length ) );
//		System.out.println( "2, is at Position: " + binarySearch( intsArray, 2, 0, intsArray.length ) );
//		System.out.println( "3, is at Position: " + binarySearch( intsArray, 3, 0, intsArray.length ) );
//		System.out.println( "4, is at Position: " + binarySearch( intsArray, 4, 0, intsArray.length ) );
//		System.out.println( "5, is at Position: " + binarySearch( intsArray, 5, 0, intsArray.length ) );
//		System.out.println( "6, is at Position: " + binarySearch( intsArray, 6, 0, intsArray.length ) );
//		System.out.println( "7, is at Position: " + binarySearch( intsArray, 7, 0, intsArray.length ) );
//		System.out.println( "8, is at Position: " + binarySearch( intsArray, 8, 0, intsArray.length ) );
//		System.out.println( "9, is at Position: " + binarySearch( intsArray, 9, 0, intsArray.length ) );
//		System.out.println( "10, is at Position: " + binarySearch( intsArray, 10, 0, intsArray.length ) );
//		System.out.println( "12, is at Position: " + binarySearch( intsArray, 12, 0, intsArray.length ) );

	}
	
	
	private static int binarySearch( int[] numbersArray, int numberToFind, int low, int high ) 
	{
		if ( high >= low && low <= numbersArray.length - 1 ) 
		{
//			int middleIndex = ( low + high ) / 2;
			int middleIndex = low + ( high - low ) / 2;
			int pointer = numbersArray[ middleIndex ];

			if ( numberToFind == pointer ) 
			{
				return middleIndex;
			} 
			else if ( numberToFind < pointer ) 
			{
				binarySearch( numbersArray, numberToFind, low, middleIndex - 1 );
			} 
			else 
			{
				binarySearch( numbersArray, numberToFind, middleIndex + 1, high) ;
			}

		}

		return -1;

	}

}
