package BMI;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Scanner function for input.
		Scanner sc = new Scanner(System.in);
		
		double weight, height, bmi;
		System.out.printf("weight [kg]: ");
		
		weight = sc.nextDouble();
		System.out.printf("height [m]: ");
		
		height = sc.nextDouble();
		System.out.printf("m=%.2fkg h=%.2fm -> BMI=%.2f (", weight, height, bmi = bmiCalc(height, weight));
		
		bmiMessage(bmiCategory(bmi));
		System.out.printf(")\n");
		
		sc.close();
	}
	
	// calculates BMI for given height and weight
	public static double bmiCalc(double height, double weight) {
		
		if((height < 1.6) || (weight < 40))
		{
			return -1.0;
		}
		
		return weight/(height*height);
	
	}
	
	// Calculates BMI category.
	public static int bmiCategory(double bmi) {
		
		if(bmi > -1.0 && bmi < 15.00)
		{
			return 10;
		}else if(bmi >= 15.00 && bmi < 16.00)
		{
			return 11;
		}else if(bmi >= 16.00 && bmi < 18.50)
		{
			return 12;
		}else if(bmi >= 18.50 && bmi < 25.00)
		{
			return 20;
		}else if(bmi >= 25.00 && bmi < 30.00)
		{
			return 30;
		}else if(bmi >= 30.00 && bmi < 35.00)
		{
			return 40;
		}else if(bmi >= 35.00 && bmi < 40.00)
		{
			return 41;
		}else if(bmi >= 40.00)
		{
			return 42;
		}else if (bmi <= -1.0){
			return -1;
		}
		
		return -1;		
		
	}
	
	// outputs the category name of given bmiCategory.
	public static void bmiMessage(int bmiCategory) {

		switch(bmiCategory) {
		case 10:
			System.out.print("Very severely underweight");
			break;
		case 11:
			System.out.print("Severely underweight");
			break;
		case 12:
			System.out.print("Underweight");
			break;
		case 20:
			System.out.print("Normal");
			break;
		case 30:
			System.out.print("Overweight");
			break;
		case 40:
			System.out.print("Moderately obese");
			break;
		case 41:
			System.out.print("Severely obese");
			break;
		case 42:
			System.out.print("Very severely obese");
			break;
		default:
			System.out.print("invalid");
			break;
				
		}
		
	}
	

}
