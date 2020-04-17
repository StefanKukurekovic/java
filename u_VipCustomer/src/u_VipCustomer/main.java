package u_VipCustomer;

public class main {

	public static void main(String[] args) {
		
		VipCustomer Stefan = new VipCustomer();
		VipCustomer Marija = new VipCustomer("Marija Soro", 100849.85464);
		VipCustomer Dzoni = new VipCustomer("Dzoni", 10000.0000, "dzoni@macka.mjau");
		
		System.out.printf("Name: %s \nBalance: %.2f \nEmail address: %s", Stefan.getName(), Stefan.getCreditLimit(), Stefan.getEmailAddress());
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("Name: %s \nBalance: %.2f \nEmail address: %s", Marija.getName(), Marija.getCreditLimit(), Marija.getEmailAddress());
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("Name: %s \nBalance: %.2f \nEmail address: %s", Dzoni.getName(), Dzoni.getCreditLimit(), Dzoni.getEmailAddress());
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println();
	}

}
