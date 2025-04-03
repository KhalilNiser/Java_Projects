
/**
 * @author Niser, Khalil: (01/13/2023)
 * 
 * Data Structure: RaixSort Theory/Implementation
 * 
 * 				---- RADIX_SORT_THEORY ----
 * I)	Makes assumption about the data
 * II)	Data must have the same radix and width; The Radix, is the number 
 * of unique digits or values in the case of characters that a  numbering
 * system or alphabet has. For example the radix for the decimal system is 
 * 10, for binary numbers the radix is 2 (0 & 1), for the English alphabet
 * the radix is 26, because there is 26 letters in the English alphabet. 
 * By width it's the number of digits or letters. For example: For the 
 * number 5 the width is 4 (0, 1, 2, 3, 4), the String "HELLO" has a width 
 * of 5, the number 10 has a width of 2, so 1,235, has 4 digits, so it has 
 * a width of 4. 
 * III)	Because of this, data must be integers or Strings
 * IV)	Sort based on each individual digit or letter position
 * V)	Start at the rightmost position
 * VI)	Must use a stable sort algorithm at each stage
 * 
 * 
 * 				---- RADIX_SORT ----
 * [] = {4725, 4586, 1330, 8792, 1594, 5729}
 * First, we'll sort this array based on the 1s position
 * {1330, 8792, 1594, 4725, 4586, 5729}
 * 
 * [] = {1330, 8792, 1594, 4725, 4586, 5729}
 * Now, we'll sort this array based on the 10s position 
 * (Must be a stable sort)
 * {4725, 5729, 1330, 4586, 8792, 1594}
 * 
 * [] = {4725, 5729, 1330, 4586, 8792, 1594}
 * Now, we'll sort this array based on the 100s position 
 * (Must be a stable sort)
 * {1330, 4586, 1594, 4725, 5729, 8792}
 * 
 * [] = {1330, 4586, 1594, 4725, 5729, 8792}
 * Finally, we'll sort this array based on the 1000s position 
 * (Must be a stable sort)
 * {1330, 1594, 4586, 4725, 5729, 8792}
 * 
 * 
 * 				---- RADIX_SORT ----
 * I)	Counting Sort is often used as the Sort algorithm for the Radix Sort.
 * Must be a stable Counting Sort
 * II)	O(n) (Linear time) - can achieve this because we're making assumptions 
 * about the data we're sorting
 * III)	Even so, it often runs slower than O(nlogn) algorithms because of the 
 * overhead involved
 * IV)	In-place depends on which Sort algorithm you use
 * V)	Stable algorithm
 * 
 * 
 * 
 * 				---- STABLE_COUNTING_SORT ----
 * I)	Requires extra steps
 * II)	Can calculate where values should be written back to the original 
 * array
 * III)	Writing the values into the array in backwards order assures stability
 * 
 * 				
 * 				---- STABLE_COUNTING_SORT ----
 * {1330, 8792, 1594, 4725, 4586, 5729}
 * 
 * I'll Sort this array base on the 10s position: Must be a Stable Sort
 * 
 * 1594 Must remain after 8792
 * 5729 Must remain after 4725
 * 
 * 
 * 				---- STABLE_COUNTING_SORT ----
 * {1330, 8792, 1594, 4725, 4586, 5729}
 * 
 * I)	I'll do the counting as I did before
 * II)	I will end up with the counting array below
 *  [0]  [1]  [2]  [3]  [4]  [5]  [6]  [7]  [8]  [9] Index
 * {[0], [0], [2], [1], [0], [0], [0], [0], [1], [2]} Position
 * 
 * I)	I want the Sort to be stable. In addition I don't have 
 * the values in the countingArray.
 * 
 * {1330, 8792, 1594, 4725, 4586, 5729}
 * {[0], [0], [2], [1], [0], [0], [0], [0], [1], [2]}
 * 
 * I create a temporary array that matches the length of the
 * array I'm Sorting. I'm going to create a temporary array of 
 * length six, because I have six values
 * 
 * NOTE: I can use the counts to figure out which range of indices in the
 * temporary array will be occupied by each value. For example: I can 
 * figure out that the two values with 2s in the 10s position will 
 * occupy indices 0 and 1 in the temporary array. The value with "3" 
 * in the 10s position will occupy index 2. The value with 8 in the 
 * 10s position will occupy index 3. The values with 9 in the 10s 
 * position will occupy index 4 and 5.
 * 
 * I)	After the first pass, I adjust the counts. Instead the number of 
 * values that have a specific 10's value, I want to store how many values
 * have a specific 10's value or less.
 * 
 * II)	For example, I want to store 3 at index 3, because 3 values have a 
 * 10's value of or less at the 10's position.
 * 
 * III)	I can calculate each adjusted count by adding up the counts up to
 * and including the 10's value.
 * 
 * {1330, 8792, 1594, 4725, 4586, 5729}
 * {[0], [0], [2], [3], [3], [3], [3], [3], [4], [6]}
 * 
 * NOTE: I can use these adjusted counts to write out the values in correct
 * order and preserve the relative positioning of values that have duplicate 
 * 10's value.
 * 
 * 
 * 				---- STABLE_SORT_CODE ----
 * 				---- 1st_PASS ----
 * {1330, 8792, 1594, 4725, 4586, 5729}
 * {[0], [0], [2], [3], [3], [3], [3], [3], [4], [6]}
 * 
 * 	int[] temp = new int[ n ] 
 * 	for ( int k = n - 1; k >= 0; k-- )
 * {
 * NOTE: getDigit is the 10's position
 * temp[ == countArray[ getDigit(position, input[k], radix]] = input[k];
 * }
 * 
 * n = length of the input array = 6
 * k starts at 5 and goes to 0
 * 
 * when k = 5:
 * 
 * I)	countArray[ getDigit(...) = countArray[2] for 5729 
 * (the value at input[k]) = 2 (NOTE: input[k] = 2 because there are 
 * a total of 2 values with 2 or less with the digit 2)
 * II)	I am using the prefix operator, so I subtract one from 
 * countArray[2] = 1
 * 
 * III)	I then assign input[k] (5729) to temp[1]
 * 
 * {[0], [5729], [0], [0], [0], [0]
 * {[0], [0], [1], [3], [3], [3], [3], [3], [4], [6]}
 * 
 * ->	Temp array now has 5729
 * ->	countArray[2] has been decremented by 1, since we've written 
 * out one value with 2 in the 10s position
 * 
 * 
 * 				---- 2nd_PASS ----
 * {1330, 8792, 1594, 4725, 4586, 5729}
 * {[0], [0], [2], [3], [3], [3], [3], [3], [4], [6]}
 * 
 * int[] temp = new int[ n ] 
 * 	for ( int k = n - 1; k >= 0; k-- )
 * {
 * NOTE: getDigit is the 10's position
 * temp[ == countArray[ getDigit(position, input[k], radix]] = input[k];
 * }
 * 
 * n = length of the input array = 6
 * k starts at 5 and goes to 0
 * 
 * when k = 4:
 * 
 * I)	countArray[ getDigit(...) = countArray[8] for 4586
 * (the value at input[k]) = 4 (NOTE: input[k] = 4 because there are 
 * a total of 4 values with 4 or less with the digit 8)
 * II)	I am using the prefix operator, so I subtract one from 
 * countArray[8] = 3
 * III)	I then assign input[k] (4586) to temp[1]
 * 
 * 
 * {[0], [5729], [0], [4586], [0], [0]
 * {[0], [0], [1], [3], [3], [3], [3], [3], [3], [6]}
 * 
 * ->	Temp array now has 4586
 * ->	countArray[8] has been decremented by 1, since we've written 
 * out one value with 8 in the 10s position
 * 
 * 
 * 				---- 3rd_PASS ---- 9:28
 * {1330, 8792, 1594, 4725, 4586, 5729}
 * {[0], [0], [2], [3], [3], [3], [3], [3], [4], [6]}
 * int[] temp = new int[ n ] 
 * 	for ( int k = n - 1; k >= 0; k-- )
 * {
 * NOTE: getDigit is the 10's position
 * temp[ == countArray[ getDigit(position, input[k], radix]] = input[k];
 * }
 * 
 * n = length of the input array = 6
 * k starts at 5 and goes to 0
 * 
 * when k = 3:
 * 
 * I)	countArray[ getDigit(...) = countArray[2] for 4725
 * (the value at input[k]) = 1 (NOTE: input[k] = 2 because there are 
 * a total of 2 values with 2 or less with the digit 2)
 * II)	I am using the prefix operator, so I subtract one from 
 * countArray[2] = 0
 * III)	I then assign input[k] (4725) to temp[0]
 * 
 * 
 * {[4725], [5729], [0], [4586], [0], [0]
 * {[0], [0], [0], [3], [3], [3], [3], [3], [3], [6]}
 * 
 * ->	Temp array now has 4586
 * ->	countArray[2] has been decremented by 10s, since we've written 
 * out one value with 8 in the 10s position
 * 
 * Notice that the relative positions of 4725 and 5729 have been 
 * preserved
 * 
 * 
 * 				---- 4th_PASS ----
 * {1330, 8792, 1594, 4725, 4586, 5729}
 * int[] temp = new int[ n ] 
 * 	for ( int k = n - 1; k >= 0; k-- )
 * {
 * NOTE: getDigit is the 10's position
 * temp[ == countArray[ getDigit(position, input[k], radix]] = input[k];
 * }
 * 
 * n = length of the input array = 6
 * k starts at 5 and goes to 0
 * 
 * when k = 2:
 * 
 * I)	countArray[ getDigit(...) = countArray[9] for 1594
 * (the value at input[k]) = 6 (NOTE: input[k] = 6 because there are 
 * a total of 6 values with 6 or less with the digit 9)
 * II)	I am using the prefix operator, so I subtract one from 
 * countArray[5] = 9
 * III)	I then assign input[k] (1594) to temp[5]
 * 
 * 
 * {[4725], [5729], [0], [4586], [0], [1594]
 * {[0], [0], [0], [3], [3], [3], [3], [3], [3], [5]}
 * 
 * ->	Temp array now has 1594
 * ->	countArray[9] has been decremented by 1s, since we've written 
 * out one value with 9 in the 10s position
 * 
 * 
 * 				---- 5th_PASS ----
 * {1330, 8792, 1594, 4725, 4586, 5729}
 * int[] temp = new int[ n ] 
 * 	for ( int k = n - 1; k >= 0; k-- )
 * {
 * NOTE: getDigit is the 10's position
 * temp[ == countArray[ getDigit(position, input[k], radix]] = input[k];
 * }
 * 
 * n = length of the input array = 6
 * k starts at 5 and goes to 0
 * 
 * when k = 1:
 * 
 * I)	countArray[ getDigit(...) = countArray[9] for 8792
 * (the value at input[k]) = 5 (NOTE: input[k] = 6 because there are 
 * a total of 6 values with 6 or less with the digit 9)
 * II)	I am using the prefix operator, so I subtract one from 
 * countArray[4] = 5
 * III)	I then assign input[k] (8792) to temp[4]
 * 
 * 
 * {[4725], [5729], [0], [4586], [8792], [1594]
 * {[0], [0], [0], [3], [3], [3], [3], [3], [3], [4]}
 * 
 * ->	Temp array now has 8792
 * ->	countArray[9] has been decremented by 1s, since we've written 
 * out one value with 9 in the 10s position
 * 
 * Notice that the relative positions of 8792 and 1594 have been 
 * preserved
 * 
 * 
 * 				---- 6th_PASS ----
 * {1330, 8792, 1594, 4725, 4586, 5729}
 * int[] temp = new int[ n ] 
 * 	for ( int k = n - 1; k >= 0; k-- )
 * {
 * NOTE: getDigit is the 10's position
 * temp[ == countArray[ getDigit(position, input[k], radix]] = input[k];
 * }
 * 
 * when k = 0:
 * 
 * I)	countArray[ getDigit(...) = countArray[3] for 1330
 * (the value at input[k]) = 3 (NOTE: input[k] = 3 because there are 
 * a total of 3 values with 3 or less with the digit 3)
 * II)	I am using the prefix operator, so I subtract one from 
 * countArray[3] = 2
 * III)	I then assign input[k] (1330) to temp[2]
 * 
 * 
 * {[4725], [5729], [1330], [4586], [8792], [1594]
 * {[0], [0], [0], [2], [3], [3], [3], [3], [3], [4]}
 * 
 * ->	Temp array now has 1330
 * ->	countArray[3] has been decremented by 1, since we've written 
 * out one value with 3 in the 10s position
 * 
 * Now I would copy the temporary array into the input array
 * 
 * 
 * 				---- STABLE_COUNTING_SORT ----
 * I)	This works because we traverse the input array from right to 
 * left, and we write duplicate values into the temp array from right 
 * to left
 * 
 * II)	If we know that duplicate values will go into positions 3 and 
 * 4, we write the rightmost value in the input array into position 4,
 * and the leftmost value into position 3
 * 
 * IV)	This preserves the relative positioning of duplicate values
 * 
 * V)	By adjusting the counting array after the initial pass, we can 
 * map values to indices in the temp array
 * 
 * VI)	can also use linked lists to make counting Sort stable
 * 
 */

package radixSort;

public class RadixSort 
{

	public static void main(String[] args) 
	{
		/**				---- RADIX_SORT_IMPLEMENTATION ----				*/
		
		// Array of integers
		int[] rdxArray = { 4725, 4586, 1330, 8792, 1594, 5729 };
		
		System.out.println( "UNSORTED DATA:" );
		
		/*
		 * Traverses through the entire array 
		 */
		for ( int i = 0; i < rdxArray.length; i++ )
		{
			System.out.print( rdxArray[ i ] + ", " );
		}
		
		System.out.println();
		
		// Call on the method to execute the sorted array
		radixSort( rdxArray, 10, 4 );
		
		System.out.println( "SORTED DATA:" );
		
		for ( int i = 0; i < rdxArray.length; i++ )
		{
			System.out.print( rdxArray[ i ] + ", ");
		}
	}
	
	/**
	 * 				---- CALL_METHOD (radixSingleSort) ----
	 * Here I will call radix SingleSort for each position in the 
	 * said values. So, I have a width of 4, so I'm going to loop
	 * four times and each time I call radixSingleSort it'll do 
	 * the sort based on one of the positions. (least significant 
	 * to most significant [going from right to left])
	 * 
	 * @param input
	 * @param radix
	 * @param width
	 */
	public static void radixSort( int[] input, int radix, int width )
	{
		for ( int i = 0; i < width; i++ )
		{
			radixSingleSort( input, i, radix );
		}
	}
	
	public static void radixSingleSort( int[] input, int position, int radix )
	{
		// Stores as many values as I am sorting
		int numItems = input.length;
		
		/*
		 * Create a countArray large enough to hold all possible values.
		 * My countArray will consist of length 10 (0 - 9)
		 */
		int[] countArray = new int [ radix ];
		
		/*
		 * For every value in my inputArray, I am going to count 
		 * how many values have a certain digit in whatever position 
		 * we are looking at. 
		 */
		for ( int value: input )
		{
			/*
			 * Going to call getDigit method (0-9: For this specific
			 * formula I will be calling on the value in the 10's 
			 * position) and increment the count by one. I will pass 
			 * the position, the value, and the radix
			 */
			countArray[ getDigit( position, value, radix ) ]++;
		}
		
		/*
		 * Adjusts the count array. At the end of this loop, the
		 * count would have been adjusted. Instead of containing 
		 * raw counts, it now contains the number of values that
		 * have that digit or less than that digit. In the 
		 * position we're working with
		 * 
		 * ---- STABLE_COUNTING_SORT ---- Part of Code
		 */
		for ( int j = 1; j < radix; j++ )
		{
			countArray[ j ] += countArray[ j - 1 ];
		}
		
		int[] temp = new int[ numItems ];
		
		for ( int tempIndex = numItems - 1; tempIndex >= 0; tempIndex-- )
		{
			temp[ --countArray [ getDigit( position, input[ tempIndex ], 
					radix ) ] ] = input[ tempIndex ];
		}
		
		/*
		 * Copy what's in the temporary array back to the input array
		 */
		for ( int tempIndex = 0; tempIndex < numItems; tempIndex++ )
		{
			input[ tempIndex ] = temp[ tempIndex ];
		}
	}
	/**
	 * 				---- GET_DIGIT (Method)
	 * On the first call that position will be zero. 
	 * So I will be calling all the values in the 
	 * 1's position
	 * 
	 * 
	 * @param position
	 * @param value
	 * @param radix
	 * @return
	 */
	public static int getDigit( int position, int value, int radix )
	{
		return value / (int)Math.pow( radix, position ) % radix;
	}

}
