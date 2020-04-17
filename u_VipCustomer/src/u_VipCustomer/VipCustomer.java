package u_VipCustomer;

public class VipCustomer {
	private String name;
	private double creditLimit;
	private String emailAddress;
	
	public VipCustomer()
	{
		this("Empty", 0.00000, "Empty");
		
	}
	
	public VipCustomer(String name, double creditLimit)
	{
		this(name, creditLimit, "default");
		
	}
	
	public VipCustomer(String name, double creditLimit, String emailAddress)
	{
		this.name = name;
		this.creditLimit = creditLimit;
		this.emailAddress = emailAddress;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getCreditLimit()
	{
		return creditLimit;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	

}
