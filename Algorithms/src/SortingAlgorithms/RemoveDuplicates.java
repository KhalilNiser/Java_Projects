package SortingAlgorithms;

public class RemoveDuplicates 
{

	public static void main(String[] args) 
	{
		
		//Initialize array
		int[] A = {1, 1, 1, 2, 2, 2, 7, 7, 8, 9, 9, 9, 10};
		int N = A.length;
		
		//Initialize variable
		int current = A[0];
		
		//Set true or false variable
		boolean found = false;
		
		//Loop for the array
		for (int i = 0; i < N; i++)
		{
			
			//Condition Statement 
			if (current == A[i])
			{
				
			//Outcome found = true
				found = true;
			}
			
			//Condition statement "current notFound
			else if (current != A[i])
			{
				//Outcome result
				System.out.println(current);
				current = A[i];
			}
		}
		
			//Display Output result
		System.out.println(current);
	}

}
