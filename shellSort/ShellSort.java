
/**
 * @author Niser, Khalil (2022/10/29);
 * 
 * Data Structure: ShellSort Algorithm Theory/Implementation
 * 
 * 				---- SHELL_SORT_THEORY ----
 * I)	Variation of Insertion Sort
 * II)	Insertion Sort chooses which element to insert using a gap of 1
 * III)	Shell Sort starts out using a larger gap value
 * IV)	As the algorithm runs, the gap is reduced
 * V)	Goal is to reduce the amount of shifting required
 * VI)	As the algorithm progresses, the gap is reduced
 * VII)	The last gap value is always 1
 * VIII)	A gap value of 1 is equivalent to insertion sort
 * IX)	So, the algorithm does some preliminary work (using gap values 
 * greater than 1), and then it becomes insertion sort
 * X)	By the time we get to Insertion Sort, the array has been partially 
 * sorted, so there's less shifting required
 * 
 * 				---- KNUTH_SEQUENCE ----
 * I)	Gap is calculated using (3^k - 1) / 2
 * II)	We set k based on the length of the array
 * III)	We want the gap to be as close as possible to the length of the array
 * we want to sort, without being greater than the length.
 * 
 * 				---- SHELL_SORT_ALGORITHM_SEQUENCE ----
 * intArray[] = { 20, 35, -15, 7, 55, 1, -22 }
 * 
 * !)	I'll base our gap based on the arrray's length. I'll initialize my gap
 * (or interval) to array.length / 2
 * II)	On each iteration, I'll divide the gap value by 2 to get the next gap
 * value
 * III)	For this array, the gap will be initialized to 3
 * IV)	On the next iteration, it will be 1: insertion sort
 * 
 * i = gap = 3
 * j = i = 3
 * newElement = intArray[i] = 7
 * Compare intArray[ j - gap ] with new element
 * 
 * 				---- FIRST_ITERATION ----
 * 
 * intArray[] = { -22, 35, -15, 7, 55, 1, 20 }
 * I)	I have completed the first iteration with gap = 3
 * II)	Notice how the array is more sorted
 * III)	I have moved -22, to the front of the array
 * IV)	I have also moved 20, closer to it's sorted position
 * 
 * 				---- UPDATE_GAP ----
 * I)	Now I have updated the gap ( gap / 2 ).
 * 
 * II)	The gap will become 1. At this point we will be switching to insertion 
 * sort. But, we're doing Insertion Sort on an array that has had some preliminary 
 * work done on it. So there is going to be a lot less shifting.
 * 
 * 				---- SHELL_SORT ----
 * I)	Shell Sort is an in-place algorithm
 * 
 * II)	Difficult to nail down the time complexity, because it will depend on the 
 * gap. Worst case scenario: O(n^2), but it can perform much better than that.
 * 
 * III) Doesn't require as much shifting as Insertion Sort, so it usually performs
 * better than Insertion Sort.
 * 
 * IV)	Unstable algorithm: Unstable Algorithm because, in the pre-insertion sort 
 * phase when we are comparing elements that are farther away from each other it's
 * very possible that when there is a duplicate element the right most element will
 * be shifted in-front of the left most element.
 * 
 */

package shellSort;

public class ShellSort 
{

	public static void main(String[] args) 
	{
		
		// Variables 
		int newElement;
		
		// Array of Unsorted elements
		int[] numsArray = {20, 35, -15, 7, 55, 1, -22};
		
		System.out.println( "Unsorted Elements:");
		for ( int i = 0; i < numsArray.length; i++ )
		{
			System.out.print( numsArray[ i ] + ", " );
		}
		System.out.println();
		
		/*
		 * This loop is going to initialize the "gap" value
		 * and then reduce it after each iteration, until 
		 * the gap i.e. to 1 (dividing by 2 every time)
		 */
		for ( int gap = numsArray.length / 2; gap > 0;
				gap = gap / 2 )
		{
			/*
			 * Now, I'm going to code the actual comparing and 
			 * shifting. This is Insertion Sort!
			 */
			for ( int i = 0; i < numsArray.length; i++ )
			{
				newElement = numsArray[ i ];
				
				int j = i;
				
				while ( j >= gap && numsArray[ j - gap ] > newElement )
				{
					numsArray[ j ] = numsArray[ j - gap ];
					
					j -= gap;
				}
				
				numsArray[ j ] = newElement;
			}
		}
		
		System.out.println();
		System.out.println( "Sorted Data Elements" );
		for ( int i = 0; i < numsArray.length; i++ )
		{
			System.out.print( numsArray[ i ] + ", " );
		}

	}

}
