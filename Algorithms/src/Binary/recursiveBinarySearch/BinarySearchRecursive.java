
/**
 * @author Niser, Khalil (2023/06/11)
 * 
 * Binary.recursiveBinarySearch: BinarySearchRecursive
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
 * For this project I will write the source code using the Recursive approach.
 */

package Binary.recursiveBinarySearch;

public class BinarySearchRecursive 
{
	private int[] arr;
	
	
	/**
	 * 				---- CLASS_CONSTRUCTOR ----
	 * @param arr
	 */
	public BinarySearchRecursive( int[] arr )
	{
		this.arr = arr;
	}
	
	/**
	 * 				---- BINARY_SEARCH_RECURSIVE_METHOD ----
	 * 
	 * @param searchElement
	 * @param low
	 * @param high
	 * @return
	 */
	public boolean binarySearchRecursive( int searchElement, int low, int high )
	{
		boolean response = false;
		
		// BASE CASE CONDITION
		if ( low <= high )
		{
			int mid = ( low + high ) / 2;
			
			if ( searchElement == arr[ mid ] )
			{
				response = true;
			}
			else if ( searchElement < arr[ mid ] )
			{
				response = binarySearchRecursive( searchElement, low, mid - 1 );
			}
			else
			{
				response = binarySearchRecursive( searchElement, mid + 1, high );
			}
				
		} // END BASE CASE CONDITION
		
		return response;
	}

	public static void main(String[] args) 
	{
		// Array of integers
		int[] sortedArray = { 10, 20, 30, 40, 50, 60, 70 };
		
		// Instantiate an object of the class: 
		// Access to all fields and data of the class
		BinarySearchRecursive search = new BinarySearchRecursive( sortedArray );
		
		int searchElement = 3;
		
		boolean result = search.binarySearchRecursive( searchElement, 0, sortedArray.length - 1 );
		
		if ( result )
		{
			System.out.println( "Element Found!" );
		}
		else
		{
			System.out.println( "Element Not Found!" );
		}

	}

}
