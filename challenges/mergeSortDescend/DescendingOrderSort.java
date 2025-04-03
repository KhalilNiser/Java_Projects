package challenges.mergeSortDescend;

public class DescendingOrderSort {

	// Merge sort method! Splitting phase
	public static void mergeSort(int[] inputArray, int start, int end) 
	{
		// Break point. If there is only 1 element. Return
		if (end - start <= 1) 
		{
			return;
		}

		// Partitioning phase
		int mid = (start + end) / 2;

		// Merge sort the left partition
		mergeSort(inputArray, start, mid);

		// Merge sort the right partition
		mergeSort(inputArray, mid, end);

		// Merge, both left/right partitions of the array
		merge(inputArray, start, mid, end);
	}

	// Merge method
	public static void merge(int[] inputArray, int start, int mid, int end) 
	{

		// Variables
		int i = start;
		int j = mid;
		int tempIndex = 0;
		/*
		 * input[mid - 1] is the last element of the left partition, while input[mid],
		 * is the first element of the right partition. 
		 * If input[mid - 1]  is greater than or equal to input[mid]: If all 
		 * the elements of the left partition are greater than or equal to all the 
		 * elements of the right partition. "Because both partitions are sorted". No
		 * shifting of values is necessary, the work is done
		 */
		if (inputArray[mid - 1] >= inputArray[mid]) 
		{
			return;
		}

		// Temp, large enough hold all the elements in the array
		int[] temp = new int[end - start];
		/*
		 * When i = mid we have finished traversing the left array, 
		 * finish traversing the right array and drop out
		 */
		while (i < mid && j < end) {
			/*
			 * Here I will step through the left and right arrays and compare 
			 * whatever is in the index (i) of the left array with whatever is
			 * in the index j of the right array, and I will write the greater 
			 * of the two into the current position in "temp". Which I am keeping 
			 * track of with tempIndex. 
			 * If input[i] is greater than or equal to input[j], then I want to 
			 * write whatever is in "i" into the temp, and increment "i". 
			 * Otherwise I want to assign input[j++] into temp, and increment 
			 * "j". 
			 * NOTE: Because Merge Sort is stable that's why the "=" sign is 
			 * there, if the element in the left array i.e. to the element in 
			 * the right array, then the element in the left goes first. Making 
			 * it a "stable" algorithm.
			 */
			temp[tempIndex++] = inputArray[i] >= inputArray[j] ? 
					inputArray[i++] : inputArray[j++];
		}

		// Copy merged (left/right partition) values back to the same position
		System.arraycopy(inputArray, i, inputArray, start + tempIndex, mid - i);

		System.arraycopy(temp, 0, inputArray, start, tempIndex);

	}

	public static void main(String[] args) 
	{
		// Array of unsorted elements
		int[] numsArray = { 20, 35, -15, 7, 55, 1, -22 };

		System.out.println("UNSORTED ELEMENTS:");

		for (int i = 0; i < numsArray.length; i++) 
		{
			System.out.print(numsArray[i] + ", ");
		}
		System.out.println();

		mergeSort(numsArray, 0, numsArray.length);

		System.out.println();

		System.out.println("SORTED ELEMENTS IN DESCENDING ORDER:");

		for (int i = 0; i < numsArray.length; i++) 
		{
			System.out.print(numsArray[i] + ", ");
		}

	}

}
