
/**
 * @author Niser, Khalil (2023/06/10)
 * 
 * Binary.iterativeBinarySearch: IterativeBinarySearch
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
 * For this project I will write the source code using the Iterative approach.
 */

package Binary.iterativeBinarySearch;

public class IterativeBinarySearch 
{

	public static void main(String[] args) 
	{
		
		// Array of integers
		int[] intsArray = { 1, 2, 4, 5, 7, 9, 11 };

		/*
		 * Call the binarySearch method and pass in the intsArray, and call on the
		 * number looking for
		 */
		System.out.println( binarySearch(intsArray, 5 ) );

	}

	/**
	 * ---- BINARY_SEARCH_METHOD ---- My binarySearch takes in two parameters.
	 * First, it will take in the actual array of integers that it's searching in.
	 * It will also take in the value that it's searching for..
	 * 
	 * @param numbersArray
	 * @param numberToFind
	 * @return
	 */
	private static int binarySearch( int[] numbersArray, int numberToFind ) 
	{
		// First index in the array
		int start = 0;

		// Last index in the array
		int end = numbersArray.length - 1;

		while ( start <= end ) 
		{
			int middleIndex = ( start + end ) / 2;

			// Identify the value at that index
			int pointer = numbersArray[middleIndex];

			/*
			 * Check whether the value I'm searching for is equal to that number, or less
			 * than, or greater than that value.
			 * 
			 * 1. Is the numberToFind equal to hat middle number 2. What if numberToFind is
			 * less than middle number 3. What if numberTofind is greater than middle number
			 */
			// 1: return index of value
			if ( numberToFind == pointer ) 
			{
				// Return index
				return middleIndex;
			} 
			else if ( numberToFind < pointer ) 
			{
				// 2: Move pointer to the left of the middle value
				end = middleIndex - 1;
			} 
			else if ( numberToFind > pointer ) 
			{
				// 3. Move pointer to the right of the middle number
				start = middleIndex + 1;
			}

		}
		
		return -1;

	}
}
