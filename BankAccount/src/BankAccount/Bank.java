// Create a new class for a bank account
// Create fields for the account number, balance, customer name, email and phone number.
//
// Create getters and setters for each field
// Create two additional methods
// 1. To allow the customer to deposit funds (this should increment the balance field).
// 2. To allow the customer to withdraw funds. This should deduct from the balance field,
// but not allow the withdrawal to complete if their are insufficient funds.
// You will want to create various code in the Main class (the one created by IntelliJ) to
// confirm your code is working.
// Add some System.out.println's in the two methods above as well.

package BankAccount;

public class Bank {	
	
	private String accountNumber;
	private double balance = 0.0;
	private String customerName;
	private String email;
	private String phoneNumber;
	
	public void depositFunds(double deposit)
	{
		this.balance += deposit;
		System.out.println("Deposit of " + deposit + " € made. New balance is " + balance + " €.");
	}
	
	public void withdrawFunds(double withdraw)
	{
		if(this.balance - withdraw < 0)
		{
			System.out.println("Only " + balance + " € available. Withdrawal not proccessed.");
		}else {
			this.balance -= withdraw;
			System.out.println("Withdrawal of " + withdraw + " € made. New balance is " + balance + " €.");
		}
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	// 1. To allow the customer to deposit funds (this should increment the balance field).
	
	// 2. To allow the customer to withdraw funds. This should deduct from the balance field,
	// but not allow the withdrawal to complete if their are insufficient funds.	

}
