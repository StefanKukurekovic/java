package BubbleSort;

public class Main {

	public static void main(String[] args) {
		
		int[] arr = {6,1,2,7,33,62,4,72,47,8,66,100,95};
		
		bubble(arr);
		print(arr);
		

	}
	
	public static void swap(int arr[], int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void bubble(int numbers[]) {
		 /* i actually counts the number of runs*/
		 for (int i=0;i<numbers.length-1;i++){
		 /*the last i positions are correct*/
		 for (int j=1;j<numbers.length-i;j++)
		 /*swap neighbors, if required*/
		 if (numbers[j-1]>numbers[j])
		 swap(numbers,j-1,j);
		 }
	}
	
	public static void print(int arr[])
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}


}
