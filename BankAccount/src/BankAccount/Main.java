package BankAccount;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Bank customer = new Bank("AT42 8593 5000 0535", 10420.00, "Stefan Kukurekovic", "xyz@gmail.com", "(555) 432 492 932");
		System.out.println(customer.getAccountNumber());
		System.out.println(customer.getBalance());

//		System.out.print("Please enter customer name: ");
//		customer.setCustomerName(sc.nextLine());
//		System.out.print("Please enter customers email adress: ");
//		customer.setEmail(sc.nextLine());
//		System.out.print("Please enter customers phone number: ");
//		customer.setPhoneNumber(sc.nextLine());
//		
//		customer.setAccountNumber("AT42 8593 5000 0535");
//		System.out.println("\n" + customer.getCustomerName());
//		System.out.println(customer.getAccountNumber());
//		System.out.println(customer.getEmail());
//		System.out.println(customer.getPhoneNumber());
//		
//		System.out.println("\n0 - Show balance");
//		System.out.println("1 - Make deposit");
//		System.out.println("2 - Redraw money");
//		
//		int choice = sc.nextInt();
//		
//		switch(choice) {
//		case 0:
//			System.out.println(customer.getBalance());
//			break;
//		case 1:
//			System.out.println("Your current balance is " + customer.getBalance() + " €");
//			System.out.print("Please deposit your money: ");
//			customer.depositFunds(sc.nextDouble());
//			break;
//		case 2:
//			System.out.println("Your current balance is " + customer.getBalance() + " €");
//			System.out.print("Enter amount to withdraw your money: ");
//			customer.withdrawFunds(sc.nextDouble());
//			break;
//		}
//		
		sc.close();
	}

}
