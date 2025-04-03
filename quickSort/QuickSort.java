
/**
 * @author Niser, Khalil: (2022/18/11)
 * Data Structure: QuickSort Theory/Implementation
 * 
 * 				---- QUICK_SORT_THEORY ----
 *
 *I)	Divide and Conquer algorithm
 *II)	Recursive algorithm
 *III)	Uses a pivot element to partition the array into two parts
 *IV)	Elements < pivot to its left, elements > pivot to its right
 *V)	Pivot will then be in its correct sorted position
 *VI)	Process is now repeated for the left array and right array
 *VII)	Eventually, every element has been the pivot, so every element will
 *be in its correct sorted position
 *VIII)	As with Merge Sort, we'll end up partitioning the array into a series 
 *of 1-element arrays.
 *IX)	Does this in-place (unlike Merge Sort)
 *
 *				---- QUICK_SORT_PROCESS ----
 *intArray[] = { 20, 35, -15, 7, 55, 1, -22 }
 *
 *Pivot will be the first element in the array (or sub array)
 *start = 0, i = start
 *end = 7, j = end
 *pivot = 20 (intArray[start])
 *
 *
 *I)	I start with (--j) and go from right to left, looking for the first 
 *elementthat's less than the pivot element.
 *II)	-22 is less than the pivot element, so I assign to position i, which 
 *is 0
 *III)	j = 6
 *intArray[] = { -22, 35, -15, 7, 55, 1, -22 }
 *
 *
 *I)	Now, I switch to i. I start with (i++) and go from left to right, 
 *looking for the first element that's greater than the pivot
 *II)	35 is greater than the pivot, so I assign it to position j, which is 6
 *III)	i = 1
 *intArray[] = { -22, 35, -15, 7, 55, 1, -22 }
 *
 *
 *intArray[] = { -22, 35, -15, 7, 55, 1, 35 }
 *I)	Notice how I have not lost any data, because I know I've already moved 
 *whatever was at position 6 down to 0.
 *
 *II)	By alternating between going from right to left and left to right, I can
 *be sure I won't lose any values.
 *Essentially j moves from right to left looking for values that are smaller than 
 *the pivot, and i, from left to right looking for values that larger than the 
 *pivot
 *
 *
 *intArray[] = { -22, 35, -15, 7, 55, 1, 35 }
 *I)	Now I check whether the values of i and j have crossed each other. If
 *i < j, they haven't, so I switch back to j and look for the element that's less 
 *than the pivot
 *
 *i = 1
 *j = 6
 *
 *
 *intArray[] = { -22, 35, -15, 7, 55, 1, 35 }
 *I)	I check the element at (--j), which is position 5. 1 is less than the
 *pivot, so I assign it to position i.
 *
 *i = 1
 *j = 5
 *
 *
 *intArray[] = { -22, 1, -15, 7, 55, 1, 35 }
 *I)	Notice once again that I have not lost any data, because I've already 
 *moved 35 from position 1
 *
 *II) Now I switch to i and look for the first element greater than the pivot
 *III)	This will take me all the way to 55
 *
 *
 *intArray[] = { -22, 1, -15, 7, 55, 1, 35 }
 *I)	At this point, I assign 55 to position j, which is 5
 *
 *
 *intArray[] = { -22, 1, -15, 7, 55, 55, 35 }
 *I)	Once again, no data is lost, I've already moved the value of 1 from 
 *position 5
 *
 *
 *intArray[] = { -22, 1, -15, 7, 55, 55, 35 }
 *I)	Now I check to see whether i and j have crossed each other.
 *II) At this point, i = 4, and j = 5
 *
 *
 *intArray[] = { -22, 1, -15, 7, 55, 55, 35 }
 *I)	I  switch to j and look for the first element that's less than the 
 *pivot. I find it at position 3, but j has now crossed i. So I don't do 
 *anything. I stop.
 *
 *II)	At this point, the value of i will be the sorted position of the 
 *pivot value (20). So I assign 20 to position 4.
 *
 *
 *intArray[] = { -22, 1, -15, 7, 20, 55, 35 }
 *I)	Notice everything to the left of 20 is smaller than 20, and everything
 *to the right of 20 is larger than 20.
 *
 *II)	Now I repeat this process for the left partition, and the right partition
 *
 *III)	I do this until the entire array is sorted.
 *
 *
 *				---- QUICK_SORT ----
 *				---- BIG_O_NOTATION_TIME_COMPLEXITY ----
 *I)	In-place algorithm
 *
 *II)	O(nlogn) - base 2. We're repeatedly partitioning the array into two 
 *halves. 
 *One thing about Quick Sort is in the worst case, it's actually a Quadratic
 *algorithm. But, in the average case it performs with a time complexity of
 *O(nlogn) and most of the time it performs better than Merge Sort. 
 *
 *III)	Unstable algorithm
 *
 */

package quickSort;

public class QuickSort 
{

	public static void main(String[] args) 
	{
		// Array of Unsorted data values
		int[] numsArray = { 20, 35, -15, 7, 55, 1, -22 };
		
		System.out.println( "UNSORTED DATA ELEMENTS:");
		
		for ( int i = 0; i < numsArray.length; i++ )
		{
			System.out.print( numsArray[ i ] + ", " );
		}
		System.out.println();
		
		/*
		 * Passing as an argument (intArray, "0" (to START),
		 * and intArray.length, to END
		 */
		quickSort( numsArray, 0, numsArray.length );
		
		System.out.println();
		System.out.println( "SORTED DATA ELEMENTS:" );
		
		for( int i = 0; i < numsArray.length; i++ )
		{
			System.out.print( numsArray[ i ] + ", " );
		}

	}
	
	// Method for Quick Sort
	public static void quickSort( int[] arrayToSort, int start, int end )
	{
		// Check whether the array consists of 1-element
		if ( end - start <= 1 )
		{
			return;
		}
		
		// This will return the position index of the pivot. 
		int pivotIndex = partition( arrayToSort, start, end );
		
		/*
		 * Now I have located the pivot. At that position where the 
		 * pivot stands, every element to the left of the pivot is 
		 * smaller than the pivot, while every element to the right, 
		 * is larger than the pivot.
		 */
		// QuickSort, the left subArray of the pivot
		quickSort( arrayToSort, start, pivotIndex );
		
		// QuickSort, the right subArray of the pivot
		quickSort( arrayToSort, pivotIndex + 1, end );
	}
	
	/*
	 * 				---- PARTITION_METHOD ----
	 * This is going to return the correct position of the pivot.
	 */
	public static int partition( int[] arrayToSort, int start, int end )
	{
		/*
		 * This is using the first element as the pivot 
		 * (index at position zero (0))
		 */
		int pivot = arrayToSort[start];
		
		// Index "i", is going to traverse from left to right
		int i = start;
		// Index "j", is going to traverse from right to left
		int j = end;

		// As long as "i" is less than "j"
		while (i < j) 
		{

			/*
			 * NOTE: Empty loop body. Using this loop to keep decrementing "j". 
			 * Moving right to left finding an element that's less than the 
			 * pivot, or i & j over cross each other
			 */
			while ((i < j) && arrayToSort[--j] >= pivot);

			/*
			 * If, i is still less than j, then I want to move the element at
			 * j into position i. 
			 * Because it means I have an element that is less than the pivot, 
			 * so I want to move that element to the left of the pivot
			 */
			if (i < j) 
			{
				// Move the element at position j into position i
				arrayToSort[i] = arrayToSort[j];
			}

			/*
			 * NOTE: Empty loop body. Using this loop to keep Incrementing "i". 
			 * Moving left to right finding an element that's greater than the 
			 * pivot, or i & j over cross each other
			 */
			while ((i < j) && arrayToSort[++i] <= pivot);

			/*
			 * If, i less than j. Then I want to move the element at i into 
			 * position j. 
			 * Because it means I have found an element that is greater than 
			 * the pivot, I want to move that element to the right of the 
			 * pivot
			 */
			if (i < j) 
			{
				// Move the element at position i into position j
				arrayToSort[j] = arrayToSort[i];
			}

		}

		arrayToSort[j] = pivot;

		return j;

	}
	
}
