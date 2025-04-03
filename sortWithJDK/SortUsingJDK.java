
/**
 * @author Niser, Khalil (01/14/2023)
 * 
 * Data Structure: SortUsingJDK
 * 
 * 				---- ARRAYS.SORT_USING_JDK ----
 * Array class is a class containing static methods that are used with 
 * arrays in order to search, sort, compare, insert elements, or return 
 * a string representation of an array. So let us specify the functions 
 * first and later onwards we will be discussing the same. They are as 
 * follows being present in java.util.Arrays class. Here we will be 
 * discussing different plots using the sort() method of the Arrays class.
 * 
 * Arrays.sort() method consists of two variations one in which we do not 
 * pass any arguments where it sort down the complete array be it integer 
 * array or character array but if we are supposed to sort a specific part 
 * using this method of Arrays class then we overload it and pass the 
 * starting and last index to the array.
 * 
 */

package sortWithJDK;

import java.util.Arrays;

public class SortUsingJDK 
{

	public static void main(String[] args) 
	{
		// Integer array
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
		
		System.out.println( "UNSORTED DATA:" );
		
		for ( int i = 0; i < intArray.length; i++ )
		{
			System.out.print( intArray[ i ] + ", " );
		}
		
		System.out.println();
		
		/*
		 * Sorting using Java's class of methods.
		 * Arrays.sort ( Pass on the array of values, you 
		 * want to sort). 
		 * 
		 * Arrays.parallelSort ( Pass on the array of values, you 
		 * want to sort).
		 * 
		 * NOTE: parallelSort is used for larger data sets 
		 * The sorting method Java uses to sort it's values 
		 * is QuickSort. 
		 */
		Arrays.parallelSort( intArray );
		
		System.out.println( "SORTED DATA:" );
		
		for ( int i = 0; i < intArray.length; i++ )
		{
			System.out.print( intArray[ i ] + ", ");
		}
		
		
		
		

	}

}
