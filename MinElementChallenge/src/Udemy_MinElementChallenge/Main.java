package Udemy_MinElementChallenge;

import java.util.Scanner;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int[] getIntegers = readIntegers(5);
		
		for(int i = 0; i < getIntegers.length; i++)
		{
			System.out.println("[" + i + "]:" + getIntegers[i]);
		}
		
		System.out.println("The smallest number is: " + findMin(getIntegers));
	}
	
	// Method for reading user input into an array 
	public static int[] readIntegers(int count)
	{
		int[] values = new int[count];
		
		for(int i = 1; i <= values.length; i++)
		{
			System.out.print("Enter " + i + ". number: ");
			values[i-1] = sc.nextInt();
		}
		
		return values;
	}
	
	// Method for finding the smallest value in an array
	public static int findMin(int[] values)
	{
		int min = values[0];
		for(int i = 0; i < values.length; i++)
		{
			if(values[i] < min)
			{
				min = values[i];
			}
		}
		
		return min;
	}

}
