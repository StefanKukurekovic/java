package InsertionSort;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = testData(sc.nextInt(), sc.nextInt(), sc.nextInt());
		System.out.println("Unsorted:");
		print(a);
		insertion(a);
		System.out.println("\nSorted:");
//		for(int i = 0; i < a.length; i++)
//		{
//			System.out.println(a[i] + "| " + a[i+1]);
//		}
		sc.close();
	}
	
	public static int[] testData(int size, int max, int seed) {
		int[] a = new int[size];
		
		Random r = new Random(seed);
		for (int i = 0; i < a.length; i++)
			a[i] = r.nextInt(max);
		
		return a;
	}
	
	public static void insertion(int numbers[]) {
		/* i is the first idx of unsorted partition */
		for (int i = 1; i < numbers.length; i++) {
		int j = i;
		int tmp = numbers[i]; /* tmp holds value of next element to insert */
		for (int k = 1; k < numbers.length; k++) {
			System.out.print("\n" + numbers[i] + "| ");
			}
		while (j > 0 && tmp < numbers[j - 1]) { /* find correct position for tmp */
			numbers[j] = numbers[j - 1]; /* on the way there shift right */
			j--;
		}
		
		numbers[j] = tmp;
		}
	}
	
	public static void print(int arr[])
	{
		for(int i = 0; i<arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}


}
