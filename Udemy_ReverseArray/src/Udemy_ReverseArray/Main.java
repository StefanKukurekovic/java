package Udemy_ReverseArray;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] newArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		
//		System.out.println("Non reversed array: " + Arrays.toString(newArray));
		
		reverse(newArray);

//		System.out.println("Reversed array: " + Arrays.toString(newArray));
	}
	
	public static void reverse(int[] reverseArray)
	{
//		int maxIndex = reverseArray.length - 1;
//		int halfLength = reverseArray.length / 2;
//		
//		for(int i = 0; i < halfLength; i++)
//		{
//			int temp = reverseArray[i];
//			reverseArray[i] = reverseArray[maxIndex - i];
//			reverseArray[maxIndex - i] = temp;
//		}
		
		
		int temp = 0;
		System.out.println("Non reversed array:");
		
		printArray(reverseArray);
		
		System.out.println("\nReversed array:");
		for(int i = 1; i <= reverseArray.length-1; i++)
		{
			if((double)i-1 == Math.ceil((double)reverseArray.length/2.0))
			{
	 			break;
			}else {
				temp = reverseArray[i-1];
				reverseArray[i-1] = reverseArray[reverseArray.length-i];
				reverseArray[reverseArray.length-i] = temp;
			}
		}
		
		printArray(reverseArray);
	}
	
	public static void printArray(int[] someArray)
	{
		for(int i = 0; i < someArray.length; i++)
		{
			System.out.print("[" + i + "]-->" + someArray[i] + "; ");
		}
	}

}
