package u_bank_account;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BankAccount bankAcc = new BankAccount("AT2301134000000004842663", 654826.54, "Stefan Kukurekovic", "kukabgd@gmail.com", "0650/ 270-34-37");
		
		/*
		bankAcc.setCustomerName("Stefan Kukurekovic");
		bankAcc.setAccountNumber("AT2301134000000004842663");
		bankAcc.setBalance(239.324);
		bankAcc.setEmail("Stefan.Kukurekovic@raiffeisen.com");
		bankAcc.setPhoneNumber("0650/270-34-37");
		boolean condition = false;
		do {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("Welcome to your netbanking %s. Please choose:\n", bankAcc.getCustomerName());
			System.out.println("1. Show my data");
			System.out.println("2. Show my balance");
			System.out.println("3. Deposit funds to my account");
			System.out.println("4. Withdraw money from my account");
			System.out.println("0. Exit");
			System.out.println("---------------------------------------------------------------");
			
			int userInput = sc.nextInt();
			
			switch(userInput) {
		
		
		
			case 1:*/
				System.out.println("----------------------------------------------------------");
				System.out.printf("| Customer name: %3s %12s\n", "|", bankAcc.getCustomerName());
				System.out.println("----------------------------------------------------------");
				System.out.printf("| Account number:%3s %12s\n", "|", bankAcc.getAccountNumber());
				System.out.println("----------------------------------------------------------");
				System.out.printf("| Email address: %3s %12s\n", "|", bankAcc.getEmail());
				System.out.println("----------------------------------------------------------");
				System.out.printf("| Phone number: %4s %12s\n", "|", bankAcc.getPhone());
				System.out.println("----------------------------------------------------------");
				System.out.printf("| Balance:%10s %12.2f €\n", "|", bankAcc.getBalance());
				System.out.println("----------------------------------------------------------");/*
				break;
			case 2:
				System.out.println("----------------------------------------------------------");
				System.out.printf("| Balance:%10s %17.2f %20s\n", "|", bankAcc.getBalance(), "|");
				System.out.println("----------------------------------------------------------");
				break;
			case 3:
				System.out.println("Please set the amount you want to deposit to your account:");
				double deposit = sc.nextDouble();
				bankAcc.setDepositFunds(deposit);
				break;
			case 4:
				System.out.println("Please set the amount you want to withdraw from your account:");
				double withdraw = sc.nextDouble();
				bankAcc.setWithdrawFunds(withdraw);
				break;
			case 0:
				System.out.println("Thank you for your visit.");
				condition = true;
			}
		}while(condition == false);
		
		
*/
	}

}
