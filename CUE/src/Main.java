package calculator;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Calculator!");
		double number1 = readNumber(sc);
		
		String op;
		while(true) {
			op = readLine(sc, "Enter operation[*/%+-]:");
			if(isValidOperation(op)) {
				break;
			}
			else {
				System.out.println("Input is not a valid operation!");
			}
		}
		
		double number2 = readNumberRecursive(sc);
		double result = executeOperation(op, number1, number2);
		
		System.out.printf("%f %s %f = %f", number1, op, number2, result);
		
		sc.close();
		
	}
	
	public static String readLine(Scanner sc, String message) {
		System.out.print(message);
		return sc.nextLine();
	}

	public static double readNumber(Scanner sc) {		
		while(true) {
			String s = readLine(sc, "Enter a number:");
			if(stringIsNumber(s)) {
				return Double.parseDouble(s);
			}else {
				System.out.println("Input is not a valid number!");
			}
		}
	}
	
	/**
	 * Alternative recursive solution for readNumber.
	 */
	public static double readNumberRecursive(Scanner sc) {
		String s = readLine(sc, "Enter a number:");
		if(stringIsNumber(s)) {
			return Double.parseDouble(s);
		}else {
			System.out.println("Input is not a valid number!");
			return readNumberRecursive(sc);
		}
	}

	public static boolean stringIsNumber(String s) {
		return s.matches("[+-]?[0-9]+\\.?[0-9]*");
	}
	
	public static boolean isValidOperation(String s) {
		return s.matches("[*/%+-]");
	}

	public static double executeOperation(String operation, double number1, double number2){
		switch(operation) {
		case "+":
			return number1 + number2;
		case "-":
			return number1 - number2;
		case "*":
			return number1 * number2;
		case "/":
			return number1 / number2;
		case "%":
			return number1 % number2;
		}
		return Double.NaN;
	}

}