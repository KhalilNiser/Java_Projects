
/**
 * @author Niser, Khalil (2023/06/13)
 * 
 * Binary.iterativeBinarySearch: BinaryIterativeApproach
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
 * 				---- TIME_COMPLEXITY/SPACE_COMPLEXITY ----
 * 				
 * Its time complexity is O(n) while it's space complexity is O(1)
 * For this project I will write the source code using the Iterative approach.
 */

package Binary.iterativeBinarySearch;

public class BinaryIterativeApproach 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	
	/**
	 * 				---- BINARY_SEARCH_METHOD ----
	 * 
	 * i)	Binary search works with the sorted array
	 * ii)	first we compute the mid, and i, target value is found
	 * at the mid index. We return that mid index.
	 * Else if, target value is greater than mid, then we search the 
	 * right half of the array, else we search in the left half of 
	 * the array
	 * @param numsArray
	 * @param target
	 * @return
	 */
	public int binarySearch( int[] numsArray, int target )
	{
		if ( numsArray == null || numsArray.length == 0 )
		{
			return -1;
		}
		
		int start = 0;
		
		int end = numsArray.length - 1;
		
		while ( start <= end )
		{
			
			/*
			 * NOTE: The mid pointer can also be calculated 
			 * (midPopinter = (start + end) / 2). But to prevent overflow
			 * I am using (midPointer = start + (end - start) / 2)
			 */
			int midPointer = start + ( end - start ) / 2;
			
			if ( numsArray[ midPointer ] == target )
			{
				return midPointer;
			}
			else if ( numsArray[ midPointer ] < target )
			{
				end = midPointer - 1;  
			}
			else
			{
				start = midPointer + 1;
			}
		}
		
		return -1;
	}

}
