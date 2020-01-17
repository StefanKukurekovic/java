package test;
import test.LendItem;
import java.util.List;
import java.util.ArrayList;

public class LendItemArrayList {
	 int INITIAL_SIZE = 20;
	 boolean resizeable = false;
	 int next = 0;
	 int id = 0;
	 
	 List<LendItem> lendItems = new ArrayList<LendItem>(INITIAL_SIZE);
	 
	 public void addLendItems(LendItem item) {
		 lendItems.add(item);
	 }
	 
	 public int printPosition(LendItem it) {
		 for(int i = 0; i < lendItems.size(); i++)
		 {
			 if(i < lendItems.indexOf(i))
				 return lendItems.indexOf(it);
		 }
		 
		 return -4;		 
	 }
	 
	 public void removeLendItem(int position) {
		 LendItem theItem = lendItems.get(position);
		 lendItems.remove(position);
	 }

	 
	 
	 
}
