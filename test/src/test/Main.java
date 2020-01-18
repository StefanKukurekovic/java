package test;

import java.util.Collection;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

import LendItems.Date;


public class Main {
		
		private static Scanner sc = new Scanner(System.in);
		
	public static void main(String[] args) {
		LendItemArrayList list = new LendItemArrayList();
//		LendItem item = new LendItem();
		
		
		
//		Menu();
//		item = scanLendItem(sc);
//		add(list, item);
//		System.out.printf("\n%s", lendItemString(item));
//		printList(list);
//		printList(list);
		
		String input = "";
		do {
        	Menu();
        	input = sc.nextLine();
//            //System.out.printf("enter opcode (9 for usage): ");
//            // input = sc.nextInt();
        	switch(input) {
        	case "1":
        		listLendItems(list,1);
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
        		removeLendItem(list, itemNo);
        		break;
        	case "5":
        		System.out.print("enter description: ");
        		String desc = sc.nextLine();
//        		listLendItems(filterByDescription(list, desc),1);
        		int count = 0;
        		System.out.printf(lendItemHeadings(1));
        		for(int i = 0; i < filterByDescription(list, desc).lendItems.size(); i++) {
        			System.out.printf(lendItemString(filterByDescription(list, desc).lendItems.get(i), 1));
        			count++;
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
		
		
	public static void addItem(LendItemArrayList list, LendItem p) {
		list.addLendItems(p);
		list.next++;
		p.id = list.next;
	}
	
	public static void removeLendItem(LendItemArrayList list, int n){
		list.removeLendItem(n-1);
		System.out.println("1 LendItem (ID=" + n + ") removed.");
	}
	
	public static void listLendItems(LendItemArrayList list, int format){
		System.out.printf(lendItemHeadings(format));
		for(int i = 0; i < list.lendItems.size(); i++) {
			System.out.printf(lendItemString(list.lendItems.get(i), format));
		}	
		System.out.println("\n" + lendItemSeparator(format) + "\n" + list.next + " LendItem(s) in list, " + (list.INITIAL_SIZE - list.next) + " free.");
//		return list.next;
	}
	
//	public static void filterByDescription(LendItemArrayList list, String desc){
//		listLendItems(list.filterByDescription(list, desc),1);
//	}
	
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
	
	
	
//	public static void addIndex(LendItemArrayList list) {
//		list.id++;
//	}
	
	
//	list.printLendItems();
	
	
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
		int index = 1;
		
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
//		item.id = index;
//		index++;
//		list.next++;
//		System.out.printf("lend date:\n");
//        item.lendDate = scanDate(sc);
//        System.out.printf("return date:\n");
//        item.returnDate = scanDate(sc);
        System.out.println("1 item added.");
		
		return item;
	}	
	
	
	
	public static String lendItemString(LendItem it, int format) { 
		LendItemArrayList list = new LendItemArrayList();
//		int index = 1;
        switch (format) {
        case 1:
            return String.format("\n%3d %-15.15s %-10.10s %s %d", /* %-10.10s", list.printPosition(it), */it.id, it.description, it.lender, /*dateString(it.lendDate),
                    dateString(it.returnDate), */it.owner, list.lendItems.indexOf(it));
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
    
    
    private static String dateString(Date d) {
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
    	
    	
	}


