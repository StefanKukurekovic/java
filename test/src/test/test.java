package test;

import java.util.ArrayList;
import java.util.List;

public class test {
	private List <String> groceryList = new ArrayList<String>();
	
	// Add new items to the grocery list
	public void addGroceryItem(String item)
	{
		groceryList.add(item);
	}
	
	public List<String> getGroceryList(){
		return groceryList;
	}
	
	// Print out grocery list
	public void printGroceryList()
	{
		System.out.println("You have " + groceryList.size() + " items in your grocery list");
		for(int i = 0; i<groceryList.size(); i++)
		{
			System.out.println((i+1) + ". " + groceryList.get(i));
		}
	}
	
	// Change grocery list
	public void modifyGroceryItem(String currentItem, String newItem)
	{
		int position = findItem(currentItem);
		if(position >= 0) {
			modifyGroceryItem(position, newItem);
		}
	}
	
	private void modifyGroceryItem (int position, String newItem)
	{
		groceryList.set(position, newItem);
		System.out.println("Grocery item " + (position+1) + " has been modified.");
	}
	
	//Remove item from the list
	public void removeGroceryItem(String item) {
		int position = findItem(item);
		if(position >= 0) {
			removeGroceryItem(position);
		}
	}
	
	private void removeGroceryItem(int position)
	{
//		String theItem = groceryList.get(position);
		groceryList.remove(position);
	}
	
	
	// find the item in the list
	private int findItem (String searchItem)
	{
//		boolean exists = groceryList.contains(searchItem);
		return groceryList.indexOf(searchItem);
//		int position = groceryList.indexOf(searchItem);
//		if(position >= 0) {
//			return groceryList.get(position);
//		}
//		
//		return null;
	}
	
	public boolean onFile(String searchItem) {
		int position = findItem(searchItem);
		if(position >= 0) {
			return true;
		}
		
		return false;
	}

}