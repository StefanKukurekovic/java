package test;
import test.LendItem;
import java.util.List;
import java.util.ArrayList;

public class LendItemArrayList {
	 int INITIAL_SIZE = 20;
	 boolean resizeable = false;
	 int next = 0;
	 
	 List<LendItem> lendItems = new ArrayList<LendItem>(INITIAL_SIZE);
	 
	 public void addLendItems(LendItem item) {
		 lendItems.add(item);
	 }
	 	 
	 public void removeLendItem(int position) {
		 LendItem theItem = lendItems.get(position);
		 lendItems.remove(theItem);
	 }

	 
//	 public static LendItemArrayList sortListByDate(LendItemArrayList list){
//		 LendItemArrayList sortedList = createCopy(list);
//			boolean swapped; 
//			int i=0; 
//			do { 
//				swapped = false; 
//				for (int j = 1; j < sortedList.next - i; j++){ 
//					if (compareDates(sortedList.list.lendItems.get[j - 1].release, sortedList.movies[j].release)) { 
//						Movie tmp = sortedList.movies[j];
//						sortedList.movies[j] = sortedList.movies[j-1];
//						sortedList.movies[j-1] = tmp;
//						swapped = true; 
//					}
//				}
//				i++;			
//			}
//			while (swapped);
//			return sortedList;
//		}
	 
//	 public static LendItemArrayList createCopy(LendItemArrayList list){
//		 LendItemArrayList copy = new LendItemArrayList();
////		 copy.lendItems = lendItems.size();
////			copy.lendItems = new LendItemArrayList[list.lendItems.size()]; //new Movie[list.movies.length];
//			for(int i = 0; i < list.next; i++){
//				copy.addLendItems(list.lendItems.get(i));
//			}
//			copy.next = list.next;
//			return copy;
//		}
	 
	 
//	 public int printPosition(LendItem it) {
//		 for(int i = 0; i < lendItems.size(); i++)
//		 {
//			 if(i < lendItems.indexOf(i))
//				 return lendItems.indexOf(it);
//		 }
//		 
//		 return -4;		 
//	 }
	 
	 
}
