
/**
 * @author Niser, Khalil 09/24/2022:
 * 
 * Data Structures ( ARRAYS )
 * 
 * 					---- ARRAYS ----
 * ->	All the elements in the "array" are allocated in one contiguous
 * block of memory in that array:
 * So that the elements in that array are not scattered all over the 
 * place in the memory.
 * 
 * ->	Every element occupies the same amount of space in memory:
 * When you create an "intArray", every element in that array will be 
 * an integer. In Java an integer consists of 4 Bytes, so every value 
 * in the intArray was occupying 4 Bytes.
 * 
 * ->	If an array starts at memory address x, and the size of each 
 * element in the array is y, we can calculate the memory address of
 * the ith element by using the following expression: (x + (i * y))
 * 
 * ->	With that being said what that means is. If we know the index 
 * of an element, the time to retrieve the element will be the same, 
 * regardless of where it is in the array: Because all we have to do
 * to get to the memory address of that element is (x + (i * y)).
 * 
 * 
 * 					---- CREATED_ARRAY_EXAMPLE ----
 * 20, 35, -15, 7, 55, 1, -11, -22
 * 
 * ->	Start address of Array = 12
 * ->	Element size = 4 bytes
 * 
 * 		address of array[ 0 ] = 12;
 * 		address of array[ 1 ] = 12 + (1 * 4) = 16;	
 * 		address of array[ 2 ] = 12 + (2 * 4) = 20;
 * 		address of array[ 3 ] = 12 + (3 * 4) = 24;
 * 		address of array[ 4 ] = 12 + (4 * 4) = 28;
 * 		address of array[ 5 ] = 12 + (5 * 4) = 32;
 * 		address of array[ 6 ] = 12 + (6 * 4) = 36;
 * 		address of array[ 7 ] = 12 + (7 * 4) = 40;
 * 
 * 					---- RETRIEVE_AN_ELEMENT_FROM_AN_ARRAY ----
 * ->	Multiply the size of the element by its index
 * ->	Get the start address of the array
 * ->	Add the start address to the result of the multiplication
 * 
 * 		for an int array, assume the element starts at address 12. 
 * Each int is 4 bytes
 * 
 * 		To get intArray[ 0 ] = 12 + (0 * 4) = 12;
 * 		To get intArray[ 1 ] = 12 + (1 * 4) = 16;
 *		To get intArray[ 2 ] = 12 + (2 * 4) = 20; 
 *		To get intArray[ 2 ] = 12 + (3 * 4) = 24;
 *->	Regardless of the number of elements in the array. We do 
 *the 3 step calculation to retrieve the size of the array
 *
 *		Number of Elements 			Steps to Retrieve
 *				1							3
 *			   1000							3
 *			  100000						3
 *			 10000000						3
 *			1000000000						3	
 */		

package array;

public class ReviewArrays 
{

	public static void main(String[] args) 
	{
		// Array of size 7 integers
		int[] intArray = new int[ 8 ];
		
		// Values in the array slots
		intArray[ 0 ] = 20;
		intArray[ 1 ] = 35;
		intArray[ 2 ] = -15;
		intArray[ 3 ] = 7;
		intArray[ 4 ] = 55;
		intArray[ 5 ] = 1;
		intArray[ 6 ] = -22;
		intArray[ 7 ] = -11;
		
		/*
		 * Print-out the array of integers on the display
		 * 
		 * I will use the for-loop set the arrays in memory
		 */
		/*for( int i = 0; i < intArray.length; i++ )
		{
			System.out.println( intArray[ i ] );
		}*/
		
		// Disadvantage of an array
		int index = 0;
		for( int i = 0; i < intArray.length; i++ )
		{
			if( intArray[ i ] == 7 )
			{
				index = i;
				
				break;
			}
			
		}
		
		System.out.println( "Index = " + index );

	}

}
