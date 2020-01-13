package LinkedList;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer customer = new Customer("Tim", 54.96);
		Customer anotherCustomer;
		anotherCustomer = customer;
		anotherCustomer.setBalance(12.18);
		System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

		ArrayList<Integer> intList = new ArrayList<Integer>();
		
	}

}
