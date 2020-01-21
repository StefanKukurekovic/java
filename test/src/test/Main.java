package test;

import java.util.Collection;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class Main {
		
		private static Scanner sc = new Scanner(System.in);
		
	public static void main(String[] args) {
		LendItemArrayList list = new LendItemArrayList();
		
		
		

		
		String input = "";
		do {
        	Menu();
        	input = sc.nextLine();
//            //System.out.printf("enter opcode (9 for usage): ");
//            // input = sc.nextInt();
        	switch(input) {
        	case "1":
        		list(list,1);
        		System.out.println("\n" + list.next + " LendItem(s) in list, " + (list.INITIAL_SIZE - list.next) + " free.");
//        		list.printLendItems();
//        		System.out.printf("\n%s", lendItemString(item));
        		break;
        	case "2":
        		addItem(list, scanLendItem(sc));
        		break;
        	case "3":
        		System.out.print("enter ID of LendItem to be removed: ");
        		int itemNo = sc.nextInt();
        		sc.nextLine();
        		remove(list, itemNo);
        		break;
        	case "5":
        		System.out.print("enter description: ");
        		String desc = sc.nextLine();
        		int count = 0;
        		System.out.printf(lendItemHeadings(1));
        		for(int i = 0; i < filterByDescription(list, desc).lendItems.length-1; i++) {
        			if(filterByDescription(list, desc).lendItems[i] != null)
        			{
        				System.out.printf(lendItemString(filterByDescription(list, desc).lendItems[i], 1));
        				count++;
        			}
        		}	
        		System.out.println("\n" + lendItemSeparator(1) + "\n" + count + " LendItem(s) in list, " + (list.INITIAL_SIZE - count) + " free.");
        	case "0":
        		break;
        	default:
        		System.out.println("This is the end.");
        		break;            
            }
//
        } while (input != "0" && !input.equals(""));
        sc.close();
        System.out.printf("Thank you for using LendApp.\n");
    }
		
		
	public static boolean addItem(LendItemArrayList list, LendItem p) {
		if(list.resizable) {
			if(list.next < list.lendItems.length)
			{
				p.id = list.next+1;
				list.lendItems[list.next++] = p;
				return true;
			}else if(list.next == list.lendItems.length){
				LendItem[] tempList = new LendItem[list.INITIAL_SIZE * 2];
				for(int i = 0; i < list.next; i++)
				{
					tempList[i] = list.lendItems[i];			
				}
				p.id = list.next+1;
				tempList[list.next++] = p;
				list.lendItems = tempList;
				return true;
			}else {
				return false;
			}
		}else {
			if(list.next < list.lendItems.length) {
				p.id = list.next+1;
				list.lendItems[list.next++] = p;
				return true;
			}else {
				return false;
			}
		}
	}
	

//	removes a LendItem at a specified (index) position.
//	This functions returns the item removed from the list or null if no such item exists. This
//	function leaves no gaps, that means all items after the removed item are shifted one position.
	
	public static LendItem remove(LendItemArrayList list, int n)
	{
		n = n-1;
		int length = list.lendItems.length;
		if((list.lendItems == null) || (list.lendItems[0] == null))
		{
			System.out.println("List is empty.");
			return null;
		}
		if((n < 0 || n >= length) || (list.lendItems[n] == null)) return null;
		
		LendItem item = list.lendItems[n];
		
		for(int i = n; i < list.next - 1; i++){ 
			if(n+1 >= length)
			{
				list.lendItems[n] = null;
			}else{
				list.lendItems[n] = list.lendItems[n+1];
			}
		}
		
		list.next--;
		System.out.printf("1 LendItem (ID=%d) removed.\n", n);
		
		return item;
	}
	

	
//	public static void removeLendItem(LendItemArrayList list, int n){
//		list.removeLendItem(n-1);
//		System.out.println("1 LendItem (ID=" + n + ") removed.");
//	}
	
	public static int list(LendItemArrayList list, int format){
		System.out.printf(lendItemHeadings(format));
		
		if(list.next == 0)
		{
			System.out.println("\nList empty");
		}
		
		for(int i = 0; i < list.next; i++) 
		{
			System.out.printf(lendItemString(list.lendItems[i], format));
		}		
		
		System.out.printf("\n" + lendItemSeparator(format));
		
		return list.next;
	}
	
//	public static void filterByDescription(LendItemArrayList list, String desc){
//		listLendItems(list.filterByDescription(list, desc),1);
//	}
	/* ----------------------------------------------------------- OVO JE RADILO -----------------------------------------------------------
	public static LendItemArrayList filterByDescription(LendItemArrayList list, String desc){
    	LendItemArrayList filteredList = new LendItemArrayList();
		int counter = 0;
		for(int i = 0; i < list.lendItems.size(); i++) {
			if(list.lendItems.get(i).description.contains(desc))
			{
				filteredList.addLendItems(list.lendItems.get(i));
				counter++;
			}
			list.next = counter;
		}
		return filteredList;
	}
	
	public static int findByID(LendItemArrayList list, int id)
	{
		for(int i = 0; i < list.lendItems.size(); i++) {
			if(list.lendItems.get(i).description.equals(Integer.toString(id)))
			{
				return list.lendItems.indexOf(id-1);
			}
		}
		return -1;
	}
	----------------------------------------------------------- OVO JE RADILO -----------------------------------------------------------*/
	
	
	// Displays start menu at the beginning 
    public static void Menu(){
    	System.out.println("\n1) list");
    	System.out.println("2) add");
    	System.out.println("3) remove");
    	System.out.println("4) sort");
    	System.out.println("5) filter");
    	System.out.println("6) set format");
    	System.out.println("0) quit");
    }
	
	// Adds new item to the program
//	public static void add(LendItemArrayList list, LendItem p) {
//		
////		if(isFull(list))
////			resize(list);
//		
//		list.lendItems[list.next++] = p; 	
//	}
	
	// Scans new items
	public static LendItem scanLendItem(Scanner sc) {
		String desc = "", lender = "", owner= "";
		LendItemArrayList list = new LendItemArrayList();
		
		while(true) {			
			System.out.printf("description: ");
			desc = sc.nextLine();
			
			System.out.printf("lender: ");
			lender = sc.nextLine();
			
			System.out.printf("owner: ");
			owner = sc.nextLine();
			
			break;
		}
		
		LendItem item = new LendItem();
		item.description = desc;
		item.owner = owner;
		item.lender = lender;
//
//		System.out.printf("lend date:\n");
//        item.lendDate = scanDate(sc);
//        System.out.printf("return date:\n");
//        item.returnDate = scanDate(sc);
//        System.out.println("1 item added.");
//		
		return item;
	}	
	
	
	
	public static String lendItemString(LendItem it, int format) { 
		LendItemArrayList list = new LendItemArrayList();
        switch (format) {
        case 1:
            return String.format("\n%3d %-15.15s %-10.10s %-10.10s (%02d)", it.id, it.description, it.lender,/* dateString(it.lendDate), dateString(it.returnDate),*/ it.owner, it.id-1);
        case 2:
            return String.format("%s\n%-15.15s %-10.10s", /*lendItemHeadings(format), */it.description, it.lender);
        default:
            return String.format("%s\n\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"", /*lendItemHeadings(format), it.ID,*/ it.description, it.lender,
                    /*dateString(it.lendDate), dateString(it.returnDate), */it.owner);

    }
	}
        
        // Creates heading for tabular display of lend items
    public static String lendItemHeadings(int format){
    		String ID = "ID", description = "description", lender = "lender", lendDate = "lend date", returnDate = "return date", owner = "owner";
    		switch(format) {
    		case 1:
    			return String.format("%3s %-15.15s %-10.10s %s %s %s\n%s", ID, description, lender, lendDate, returnDate, owner, lendItemSeparator(format));
    		case 2:
    			return String.format("%-15.15s %-10.10s\n%s", description, lender, lendItemSeparator(format));
    		default:
    			return String.format("%3s %-15.15s %-10.10s %s %s %-10.10s\n%s", ID, description, lender, lendDate, returnDate, owner, lendItemSeparator(format));		
    		}
    }
    
    public static LendItemArrayList filterByDescription(LendItemArrayList list, String desc){
    	
    	LendItemArrayList filteredList = new LendItemArrayList();	
    	
//    	if(desc == null || desc.length() == 0) return null;
//    	if(list == null || list.next == 0) return null;
    	
		for(int i = 0; i < list.lendItems.length; i++) {
			if(list.lendItems[i] != null)
			{
				if(list.lendItems[i].description.contains(desc))
				{
					filteredList.lendItems[filteredList.next] = list.lendItems[i];
					filteredList.next++;
				}
			}
		}
		return filteredList;
	}
    
    public static int findByID(LendItemArrayList list, int id)
    {
    	for(int i = 0; i < list.lendItems.length; i++)
    	{
    		if(list.lendItems[i].id == id)
    		{
    			return i;
    		}
    	}
    	
    	return -1;
    }
    
    public static int index(int id)
    {
    	LendItemArrayList list = new LendItemArrayList();
    	for(int i = 0; i < list.next; i++)
    	{
    		if(list.lendItems[i].id == id)
    		{
    			return i;
    		}
    	}
    	
    	return -1;
    }
    
    
    private static String dateString(Date d) {
    	String notSet = "<not set>";
    	if(d == null)
    	{
    		return String.format("%04d.%02d.%02d", d.year, d.month, d.day);
    	}
        return String.format("%04d.%02d.%02d", d.year, d.month, d.day);
    }
    	
        // Creates the separators for the table.
    	public static String lendItemSeparator(int format)
    	{
    		String dashOne = "------------------------------------------------------------------";
    		String dashTwo = "-------------------------";
    		String dashDefault = "------------------------------------------------------------------";
    		switch (format) {
    		case 1:
    			return String.format("%s", dashOne);
    		case 2:
    			return String.format("%s", dashTwo);
    		default:
    			return String.format("%s", dashDefault);
    		}
    	
    	}
    	
    	public static Date scanDate(Scanner sc) {
            int y, m, d;
            while(true) {
                System.out.printf("year: ");
                y = Integer.parseInt(sc.nextLine());
                System.out.printf("month: ");
                m = Integer.parseInt(sc.nextLine());
                System.out.printf("day: ");
                d = Integer.parseInt(sc.nextLine());

//                if(y == 0)
//                {
//                    continue;
//                }
                if (y < 1582) {
                    System.out.printf("year cannot be before 1582!\n");
                    continue;
                }
                if (m < 1 || m > 12) {
                    System.out.printf("month must be 1-12!\n");
                    continue;
                }
                if (d < 1 || d > 31) {
                    System.out.printf("day must be 1-31!\n");
                    continue;
                }

                break;
            }
            Date dat = new Date();
            dat.day = d;
            dat.month = m;
            dat.year = y;
            return dat;
        }
    	
//    	public static LendItemArrayList sortListByDate(LendItemArrayList list){
//   		 LendItemArrayList sortedList = list.createCopy(list);
//   			boolean swapped; 
//   			int i=0; 
//   			do { 
//   				swapped = false; 
//   				for (int j = 1; j < sortedList.next - i; j++){ 
//   					if (compareDates(sortedList.list.lendItems.get[j - 1].release, sortedList.movies[j].release)) { 
//   						Movie tmp = sortedList.movies[j];
//   						sortedList.movies[j] = sortedList.movies[j-1];
//   						sortedList.movies[j-1] = tmp;
//   						swapped = true; 
//   					}
//   				}
//   				i++;			
//   			}
//   			while (swapped);
//   			return sortedList;
//   		}
    	
    	
    	public static int compare(LendItem it1, LendItem it2, int method) {
            switch (method) {
            case 1:
                return compareByLendDate(it1, it2);
            case 2:
                return compareByReturnDate(it1, it2);
            case 3:
                return compareByLender(it1, it2);
            case 4:
                return compareByOwner(it1, it2);
            default:
                return compareByDescription(it1, it2);
            }
        }

        /**
         * compares two LendItems by lend date <br>
         * returns -1 if the lend date of it1 is before than of it2, 1 if the other way
         * round, 0 if they are the same.<br>
         * Note: any two null-LendItems are equal and any null-LendItem goes before any
         * non-LendItem event.
         * 
         * @param it1
         * @param it2
         * @return
         */
        public static int compareByLendDate(LendItem it1, LendItem it2) {
            if (it1 == null && it2 == null)
                return 0;
            if (it1 == null)
                return -1;
            if (it2 == null)
                return 1;

            return compare(it1.lendDate, it2.lendDate);
        }

        /**
         * compares two LendItems by return date <br>
         * returns -1 if the return date of it1 is before than of it2, 1 if the other
         * way round, 0 if they are the same. <br>
         * Note: any two null-LendItems are equal and any null-LendItem goes before any
         * non-LendItem event.
         * 
         * @param it1
         * @param it2
         * @return
         */
        public static int compareByReturnDate(LendItem it1, LendItem it2) {
            if (it1 == null && it2 == null)
                return 0;
            if (it1 == null)
                return -1;
            if (it2 == null)
                return 1;

            return compare(it1.returnDate, it2.returnDate);
        }

        /**
         * compares two LendItems by description<br>
         * returns -1 if the description of it1 is before than of it2, 1 if the other
         * way round, 0 if they are the same. <br>
         * descriptions are compared lexicographically (see String.compareTo) <br>
         * Note: any two null-LendItems are equal and any null-LendItem goes before any
         * non-LendItem event.
         * 
         * @param it1
         * @param it2
         * @return
         */
        public static int compareByDescription(LendItem it1, LendItem it2) {
            if (it1 == null && it2 == null)
                return 0;
            if (it1 == null)
                return -1;
            if (it2 == null)
                return 1;

            int res = it1.description.compareTo(it2.description);
            if (res > 0)
                return 1;
            if (res < 0)
                return -1;
            return 0;
        }

        /**
         * compares two Date<br>
         * returns -1 if d1 is before it2, 1 if the other way round, 0 if they are the
         * same. <br>
         * Note: any two null-Dates are equal and any null-Dates goes before any
         * non-null Date.
         * 
         * @param it1
         * @param it2
         * @return
         */
        public static int compare(Date d1, Date d2) {
            if (d1 == null && d2 == null)
                return 0;
            if (d1 == null)
                return -1;
            if (d2 == null)
                return 1;

            int res = (d1.day + d1.month * 100 + d1.year * 10000) - (d2.day + d2.month * 100 + d2.year * 10000);

            if (res > 0)
                return 1;
            if (res < 0)
                return -1;
            return 0;

        }

        /**
         * compares two LendItems by lender <br>
         * returns -1 if the lender of it1 is before than of it2, 1 if the other way
         * round, 0 if they are the same. <br>
         * lenders are compared lexicographically (see String.compareTo) <br>
         * Note: any two null-LendItems are equal and any null-LendItem goes before any
         * non-LendItem event.
         * 
         * @param it1
         * @param it2
         * @return
         */
        public static int compareByLender(LendItem it1, LendItem it2) {
            if (it1 == null && it2 == null)
                return 0;
            if (it1 == null)
                return -1;
            if (it2 == null)
                return 1;

            int res = it1.lender.compareTo(it2.lender);
            if (res > 0)
                return 1;
            if (res < 0)
                return -1;
            return 0;
        }

        /**
         * compares two LendItems by owner <br>
         * returns -1 if the owner of it1 is before than of it2, 1 if the other way
         * round, 0 if they are the same. <br>
         * owner are compared lexicographically (see String.compareTo) <br>
         * Note: any two null-LendItems are equal and any null-LendItem goes before any
         * non-LendItem event.
         * 
         * @param it1
         * @param it2
         * @return
         */
        public static int compareByOwner(LendItem it1, LendItem it2) {
            if (it1 == null && it2 == null)
                return 0;
            if (it1 == null)
                return -1;
            if (it2 == null)
                return 1;

            int res = it1.owner.compareTo(it2.owner);
            if (res > 0)
                return 1;
            if (res < 0)
                return -1;
            return 0;
        }
    	
    	
	}


