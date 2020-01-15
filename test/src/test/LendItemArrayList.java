package test;
import test.LendItem;
import java.util.List;
import java.util.ArrayList;

public class LendItemArrayList {
	 int INITIAL_SIZE = 20;
	 boolean resizeable = false;
	 int next = 0;
	 
//	 LendItem[] lendItems = new LendItem[INITIAL_SIZE];	 
//	 List<String> lendItems = Arrays.asList(new String[INITIAL_SIZE]);
	 
	 List<LendItem> lendItems = new ArrayList<LendItem>(INITIAL_SIZE);
	 
	 public void addLendItems(LendItem item) {
		 lendItems.add(item);
	 }
	 
	 public void printLendItems() {
		 for(int i = 0; i < lendItems.size(); i++)
		 {
			 System.out.println((i+1) + ". " + lendItems.get(i).description + " " + lendItems.get(i).owner + " " + lendItems.get(i).lender);
		 }
	 }
	 
	 public void removeLendItem(int position) {
		 LendItem theItem = lendItems.get(position);
		 lendItems.remove(position);
	 }
	 
}
