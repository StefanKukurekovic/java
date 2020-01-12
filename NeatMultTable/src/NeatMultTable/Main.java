package NeatMultTable;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter rows: ");
		int xrows = sc.nextInt();

		System.out.print("enter columns: ");
		int xcols = sc.nextInt();

		System.out.printf("\n%4s", "");
		for (int i = 1; i <= xcols; i++)
			System.out.printf("%3d", i);
		System.out.println();

		for (int i = 0; i < 4 + xcols * 3; i++)
			System.out.print('-');

		for (int i = 1; i <= xrows; i++) {
			System.out.printf("%s%2d |", System.lineSeparator(), i);
			for (int j = 1; j <= xcols; j++) {
				System.out.printf("%3d", i * j);
			}
		}
		sc.close();
	}
}
