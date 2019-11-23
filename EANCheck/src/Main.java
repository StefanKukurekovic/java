package EANCheck;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Enter EAN number that needs to be checked
		System.out.print("Enter all 13 digits of an EAN: ");
		long ean = sc.nextLong();
		
		// Save EAN to temp variable so it won't be lost during first check
		long temp = ean;
		int sumEven=0, sumOdd=0, count=0;
		
		// Get the sum of all EVEN numbers
		while(temp > 0)
		{
			count++;
			if(count % 2 == 0)
			{
				// Gets the last number as a reminder
				sumEven += temp%10;
			}
			// Removes the last number from the start value
			temp /= 10;
		}
		
		// Reset temp and count to start values to be able to calculate the sum of ODD numbers
		temp = ean;
		count = 0;
		
		// Get the sum of all ODD numbers
		while(temp > 0)
		{
			count++;
			if(count % 2 != 0)
			{
				sumOdd += temp%10;
			}
			temp /= 10;
		}
		
		// Calculate check digit
		int checkDigit = 9 - (((sumEven * 3 + sumOdd)-1) % 10);
		
		// In order for check digit to be valid, it has to be equal to 0
		if(checkDigit == 0)
		{
			System.out.print("The EAN is VALID.");
		}else {
			System.out.print("The EAN is NOT VALID.");
		}
		
		sc.close();
	}

}
