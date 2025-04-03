package SortingAlgorithms;

public class ProgramTwoSortArray
{

	public static void main(String[] args) 
	{
		
		//Key index counting demo
		//String sort an array a[] of N integers between 0 and R - 1
		int[] a = {3, 0, 2, 5, 5, 1, 6, 1, 5, 1, 4, 0, 5, 3, 6, 3};
		int N = a.length;
			int R = 8;
			int[] aux = new int[N];
			int[] count = new int[R + 1];
			
			int temp;
			int min_j;
			
			//Compute frequency Counts
			for (int i = 0; i < N; i++)
			{
				count[a[i]+1]++;
			}
			
			//Transform counts to indices
			for (int j = 0; j < R; j++)
			{
				count[j + 1] += count[j];
			}
			
			//Distribute the records
			for (int i = 0; i < N; i++)
			{
				aux[count[a[i]]++] = a[i];
			}
			
			//Copy back
			//display sorted a[i]
			for (int i = 0; i < N; i++)
			{
				a[i] = aux[i];
				System.out.print(a[i] + " , ");
				
			}
			
			/*System.out.println("\nArray Before Selection Sort");
			for (int i = 0; i < N; i++)
			{
				System.out.println(a[i] + "\n ");*/
				/*Find array element with the minimum value
				 * among a[i], a[i+1], a[i-1];*/
				//Assuming that the element i (a[i] , is the minimum
				/*min_j = i;
				
				for (int j = i+1; j < N; j++)
				{
					if(a[j] < a[min_j])
					{
						//Smaller minimum has been found, update "min_j"
						min_j = j;
					}
				}
				//Swap a[i] and a[min_j]
				temp = a[i];
				a[i] = a[min_j];
				a[min_j] = temp;
			}
			System.out.println("Array After Selection Sort");
			for (int i = 0; i < a.length; i++)
			{
				System.out.println(a[i] + " \n ");
			}*/
	}
}
