package test;

import java.util.Collection;
import java.util.Scanner;

public class Main {
		
		private static Scanner sc = new Scanner(System.in);
		
	public static void main(String[] args) {
		LendItemArrayList list = new LendItemArrayList();
		
		System.out.println("Welcome to Lend Item Manager Program. Please select one option.");
		
		for (int i = 0; i < 25; i++) {
			LendItem li = new LendItem();
			li.id = i;
			li.description = String.format("%c_description", ((int) (i
			* Math.PI * 10000)) % 15 + 'A');
			li.lender = String.format("Gustav_%02d", ((int) (i
			* Math.PI * 1000000)) % 10);
			li.lendDate = new Date();
			li.lendDate.year = 2010 - ((int) (i * Math.PI * 100)) % 100;
			li.lendDate.month = ((int) (i * Math.PI * 1000000)) % 12 + 1;
			li.lendDate.day = ((int) (i * Math.PI * 100000000)) % 28 + 1;
			
			li.returnDate = new Date();
			li.returnDate.year = 2010 - ((int) (i * Math.PI * 100)) % 100;
			li.returnDate.month = 1;
			li.lendDate.day = ((int) (i * Math.PI * 100000000)) % 28 + 1;
			
			
			add(list, li);
			}
		
		String input = "";
		do {
        	Menu();
        	input = sc.nextLine();
        	
        	switch(input) {
        	case "1":
        		list(list,1);
        		break;
        	case "2":
        		add(list, scanLendItem(sc));
        		break;
        	case "3":
        		System.out.print("enter ID of LendItem to be removed: ");
        		int itemNo = sc.nextInt();
        		sc.nextLine();
        		remove(list, itemNo);
        		break;
        	case "4":
        		System.out.println("Sorting not possible at the moment.");
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
        		System.out.println("\n" + lendItemSeparator(1) + "\n" + count + " LendItem(s) in list, " + (list.lendItems.length - count) + " free.");
        		break;
        	case "6":
        		System.out.println("available options:");
        		System.out.println("1) full format");
        		System.out.println("2) short format");
        		System.out.println("3) csv format");
        		int format = sc.nextInt();
        		sc.nextLine();
        		list(list, format);
        		break;
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
	
	
	/**
     * Displays Menu at the beginning
     */	
    public static void Menu(){
    	System.out.println("\n1) list");
    	System.out.println("2) add");
    	System.out.println("3) remove");
    	System.out.println("4) sort");
    	System.out.println("5) filter");
    	System.out.println("6) set format");
    	System.out.println("0) quit");
    }
	
    
	/**
     * adds a LendItem to the end of the list
     * a resizeable list doubles its capacity when an item is to be added to a full list
     * returns true if successfully added
     * 
     * @param list
     * @param p
     * @return
     */	
	public static boolean add(LendItemArrayList list, LendItem p) {
		if(list.resizeable) {
			if(list.next < list.lendItems.length)
			{
				p.id = list.next+1;
				list.lendItems[list.next++] = p;
				return true;
			}else if(list.next == list.lendItems.length){
				list.resizeable = true;
				LendItem[] tempList = new LendItem[list.lendItems.length * 2];
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
	
	
	/**
     * removes a LendItem at a specified (index) position
     * returns the item removed from the list or null if no such item exists
     * function leaves no gaps, that means all items after the removed item are shifted one position.
     * 
     * @param list
     * @param p
     * @return
     */	
	public static LendItem remove(LendItemArrayList list, int n)
	{
		if(list.next == 0)
		{
			System.out.print("\nList empty");
			return null;
		}
		if(n < 0 || n > list.next)
		{
			System.out.printf("LendItem not found (ID %d).\n", n);
			return null;
		}
		
		int original = n;
		n = n-1;		
				
		LendItem item = list.lendItems[n];
		
		for(int i = n; i < list.next - 1; i++){ 
			if(n+1 >= list.next)
			{
				list.lendItems[i] = null;
			}else{
				list.lendItems[i] = list.lendItems[i+1];
			}
		}
		
		list.next--;
		System.out.printf("1 LendItem (ID=%d) removed.\n", original);
		
		return item;
	}
	
	
	/**
     * Displays all items in the list
     * returns the item removed from the list or null if no such item exists
     * function leaves no gaps, that means all items after the removed item are shifted one position.
     * 
     * @param list
     * @param p
     * @return
     */	
	public static int list(LendItemArrayList list, int format)
	{
		System.out.printf(lendItemHeadings(format));
		
		if(list.next == 0)
		{
			System.out.print("\nList empty");
		}
		
		for(int i = 0; i < list.next; i++) 
		{
			System.out.printf(lendItemString(list.lendItems[i], format));
		}		
		
		System.out.printf("\n" + lendItemSeparator(format));
		System.out.println("\n" + list.next + " LendItem(s) in list, " + (list.lendItems.length - list.next) + " free.");
		
		return list.next;
	}
	
	
	/**
     * Filters a list returning only those items that match a speified description
     * 
     * @param list
     * @param desc
     * @return
     */
	public static LendItemArrayList filterByDescription(LendItemArrayList list, String desc){
    	
    	LendItemArrayList filteredList = new LendItemArrayList();	
    	
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
	
	
	/**
     * Finds an item by ID
     * 
     * @param list
     * @param id
     * @return
     */
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
    
	
    /**
     * Scanns user input
     * 
     * @param sc
     * @return
     */
	public static LendItem scanLendItem(Scanner sc) {
		String desc = "", lender = "", owner= "";
		
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

		System.out.printf("lend date:\n");
        item.lendDate = scanDate(sc);
        System.out.printf("return date:\n");
        item.returnDate = scanDate(sc);
        
        System.out.println("1 item added.");
		
		return item;
	}	
	
	
	/**
     * creates a String representation of a LendItem in a specified format<br>
     * 
     * The format is controlled by parameter format:
     * <ul>
     * <li>1: full format</li>
     * <li>2: short format</li>
     * <li>3 (and in all other cases): csv format</li>
     * </ul>
     * 
     * Full Format: "&ltdescription> &ltlender> &ltlend date> &ltreturn date>
     * &ltowner>" where
     * <ul>
     * <li>description is exactly 15 characters wide, left aligned</li>
     * <li>lender and owner are exactly 10 characters wide, left aligned</li>
     * <li>dates are in their default format</li>
     * </ul>
     * 
     * Short Format: "&ltdescription> &ltlender>" where
     * <ul>
     * <li>description is exactly 15 characters wide, left aligned</li>
     * <li>lender are exactly 10 characters wide, left aligned</li>
     * </ul>
     * 
     * CSV Format: "&ltdescription>,&ltlender>,&ltlend date>,&ltreturn
     * date>,&ltowner>" where all String values are surrounded by double quotes and
     * dates are in their default format.
     * 
     * @param it
     * @param format
     * @return
     */
	public static String lendItemString(LendItem it, int format) { 
        switch (format) {
        case 1:
            return String.format("\n%3d %-15.15s %-10.10s %-10.10s %s %-10.10s (%02d)", it.id, it.description, it.lender, dateString(it.lendDate), dateString(it.returnDate), it.owner, it.id-1);
        case 2:
            return String.format("\n%-15.15s %-10.10s", it.description, it.lender);
        case 3:
            return String.format("\n\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"", it.description, it.lender,
                    dateString(it.lendDate), dateString(it.returnDate), it.owner);
        default:
            return String.format("\n%-15.15s %-10.10s %-10.10s %s %-10.10s (%02d)", it.description, it.lender, dateString(it.lendDate), dateString(it.returnDate), it.owner, it.id-1);
            

    }
	}
	
	
	/**
	 * Converts user input to Date
	 * 
	 * @param it
	 * @return
	 */
	public static String date(LendItem it)
	{
		if(dateString(it.lendDate) == null)
		{
			return String.format("<not set>");
		}else if(dateString(it.returnDate) == null)
		{
			return String.format("<not set>");
		}
		
		return null;
	}
	
       
        /** Creates heading for tabular display of lend items
         * 
         * @param format
         * @return
         */
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
    
    /** Converts Date to String
     * 
     * @param d
     * @return
     */
    private static String dateString(Date d) {
        return String.format("%04d.%02d.%02d", d.year, d.month, d.day);
    }
    	
    
    /**
     * Creates the separators for the table.
     * 
     * @param format
     * @return
     */
    public static String lendItemSeparator(int format)
    {
    	String dashOne = "------------------------------------------------------------------";
    	String dashTwo = "---------------------------------";
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
    	
    /**
     * Scans user input and returns Date
     * 
     * @param sc
     * @return
     */
    public static Date scanDate(Scanner sc) 
    {
    	int y, m, d;
        while(true) {
        System.out.printf("year: ");
        y = Integer.parseInt(sc.nextLine());
        System.out.printf("month: ");
        m = Integer.parseInt(sc.nextLine());
        System.out.printf("day: ");
        d = Integer.parseInt(sc.nextLine());
        
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
    	

    	
    	
	}


