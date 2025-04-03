package SortingAlgorithms;

import java.util.Scanner;

public class ProgramOneReverse 
{
	public static String reverse(String s)
	{
		/*Scanner input = new Scanner(System.in);
		System.out.println("Enter a Phrase of your desire-->");
		String rev = input.nextLine();
		String rev1 = rev;*/
		String rev = " ";
		for (int i = s.length() - 1; i >= 0; i--)
		{
			rev += s.charAt(i);
		}
		return rev;
	}

	public static void main(String[] args)
	{
		String a = "racecaR";
		String display = reverse(a);
		System.out.println(display);

	}
}
