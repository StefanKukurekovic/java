package u_bank_account;

public class BankAccount {
	private String accountNumber;
	private double balance;
	private String customerName;
	private String email;
	private String phone;
	
	// with empty constructor we define the default values
	public BankAccount() {
		this("Empty", 0.00, "Empty", "Empty", "Empty");
		System.out.println("Empty Constructor called");
	}
	
	public BankAccount(String accountNumber, double balance, String customerName, String email, String phone) {
		System.out.println("Account Constructor with parameters called");
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.customerName = customerName;
		this.email = email;
		this.phone = phone;
	}
	
	/***************************************************************
	 * getters
	 ***************************************************************/
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public String getCustomerName()
	{
		return this.customerName;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getPhone()
	{
		return this.phone;
	}
	
	
	/***************************************************************
	 * Setters
	 ***************************************************************/
	
	public void setAccountNumber (String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	
	public void setBalance (double balance)
	{
		this.balance = balance;
	}
	
	public void setCustomerName (String customerName)
	{
		this.customerName = customerName;
	}
	
	public void setEmail (String email)
	{
		this.email = email;
	}
	
	public void setPhoneNumber (String phone)
	{
		this.phone = phone;
	}
	
	public void setDepositFunds (double deposit)
	{
		this.balance += deposit;
		System.out.printf("You have deposit %.2f € to your account. Your current balance is %.2f €\n", deposit, this.balance);
	}
	
	public void setWithdrawFunds (double withdrawFunds)
	{
		if(withdrawFunds > balance)
		{
			System.out.printf("Insufficient funds. You can only withdraw %.2f €.\n", this.balance);
		} else {
			this.balance -= withdrawFunds;
			System.out.printf("You withdrawed %.2f€. Your current balance is %.2f €\n", withdrawFunds, this.balance);
		}
	}
	
	
	
}
