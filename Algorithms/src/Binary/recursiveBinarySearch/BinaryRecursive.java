
/**
 * @author Niser, Khalil (2023/06/13)
 * 
 * Binary.recursiveBinarySearch: BinaryRecursive
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
 * 				---- TIME_COMPLEXITY?SPACE_COMPLEXITY ----
 *  It's time complexity is O(n), while it's space complexity is O(1)
 * 
 * For this project I will write the source code using the Recursive method.
 */

package Binary.recursiveBinarySearch;

public class BinaryRecursive
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	
	/**
	 * 				---- SEARCH_USING_TRCURSION_METHOD ----
	 * @param numsArray
	 * @param target
	 * @return
	 */
	public int searchUsingRecursion( int[] numsArray, int target )
	{
		if ( numsArray == null || numsArray.length == 0 )
		{
			return -1;
		}
		
		return binarySearchHelper( numsArray, target, 0, numsArray.length - 1 );
	}
	
	/**
	 * 				---- BINARY_SEARCH_HELPER_METHOD ----
	 * @param numsArray
	 * @param target
	 * @param start
	 * @param end
	 * @return
	 */
	private int binarySearchHelper( int[] numsArray, int target, int start, int end )
	{
		if ( start > end )
		{
			return -1;
		}
		
		int midPointer = start + ( end - start ) / 2;
		
		if ( numsArray[ midPointer ] == target )
		{
			return midPointer;
		}
		else if ( numsArray[ midPointer ] < target )
		{
			return binarySearchHelper( numsArray, target, midPointer + 1, end );
		}
		else if ( numsArray[ midPointer ] > target )
		{
			return binarySearchHelper( numsArray, target, start, midPointer - 1 );
		}
		
		return -1;
	}

}
