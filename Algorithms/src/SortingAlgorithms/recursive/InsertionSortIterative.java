
/**
 * @author Niser, Khalil (05/08/2023)
 * 
 * Sorting Algorithms: Recursive Insertion: InsertionSort
 * 
 * 				---- RECURSIVE_INSERTION_SORT ----
 * Insertion sort is a simple sorting algorithm that works the way
 * we sort playing cards in our hands. 
 * Below is an iterative algorithm for insertion sort
 * 
 * Algorithm:
 * 
 * // Sort an arr[] of size n
 * insertionSort(arr, n) 
 * 	 Loop from i = 1 to n-1.
 * 	   a) Pick element arr[i] and insert
 * 	      it into sorted sequence arr[0..i-1] 
 * 
 * 
 * Example:
 * 
 * [9][7][6][15][17][5][10][11]
 * [9][7][6][15][17][5][10][11] compare 7 & 9; switch if applicable
 * 
 * [7][9][6][15][17][5][10][11] compare 6 & 7; switch if applicable
 * [6][7][9][15][17][5][10][11] compare 15 & 6; switch if applicable
 * [6][7][9][15][17][5][10][11] compare 17 & 6; switch if applicable
 * [5][6][7][15][17][5][10][11] compare 5 & 6; switch if applicable
 * [5][6][7][9][10][15][17][11] compare 10, 15, & 17; switch if applicable
 * [5][6][7][9][10][11][15][17] compare 11, 15, & 17; switch if applicable
 * [5][6][7][9][10][11][15][17] Assorted array
 * 
 * How to implement "Insertion Sort Recursively":
 * Recursive Insertion Sort has no performance/implementation advantages, 
 * but can be a good question to check one’s understanding of Insertion 
 * Sort and recursion. 
 * If we take a closer look at Insertion Sort algorithm, we keep processed 
 * elements sorted and insert new elements one by one in the sorted array.
 * 
 * Recursion Idea:
 * 1.	Base Case: If array size is 1 or smaller, just nothing return 
 * 2.	Recursively sort first n - 1 elements
 * 3.	Insert last element at its correct position in the sorted array
 * 
 * 
 * 				---- TIME_COMPLEXITY ----
 * Time complexity for the "recursive Insertion Sort" program is 
 * "Quadratic time (O(n^2))
 * 
 * 
 * Below is the code implementation of the above idea:
 * 
 * Recursive Java program for Insertion Sort
 */

package SortingAlgorithms.recursive;

import java.util.Arrays;

public class InsertionSortIterative 
{

	/**
	 * ---- INSERTION_SORT_RECURSIVE ---- 
	 * Recursive method to Sort an Array using
	 * Insertion Sort
	 * 
	 * @param arrayInt
	 * @param n
	 */
	static void insertionSortRecursive(int[] arrayInt, int n) 
	{
		// Base Case
		if (n <= 1) 
		{
			return;
		}

		// Sort first n - 1 elements
		insertionSortRecursive(arrayInt, n - 1);

		/*
		 * Insert the last element in its correct position in the sorted array
		 */
		int last = arrayInt[n - 1];
		int j = n - 2;

		/*
		 * Move the elements of arrayInt[ 0..i - 1], that are greater than the key, to
		 * one position ahead of their current position
		 */
		while (j >= 0 && arrayInt[j] > last) 
		{
			arrayInt[j + 1] = arrayInt[j];

			// Decrement j
			j--;
		}

		arrayInt[j + 1] = last;
	}

	public static void main(String[] args) 
	{
		// Recursive Java program for Insertion Sort
		int[] intArr = { 9, 7, 6, 15, 17, 5, 10, 11 };

		System.out.println("Unsorted Elements: " + Arrays.toString(intArr));

		insertionSortRecursive(intArr, intArr.length);

		System.out.println();
		System.out.println("Sorted Elements: " + Arrays.toString(intArr));

	}

}
