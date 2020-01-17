package test;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;


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
	}
	
	public static void removeLendItem(LendItemArrayList list, int n){
		list.removeLendItem(n-1);
	}
	
	public static void listLendItems(LendItemArrayList list, int format){
		System.out.printf(lendItemHeadings(format));
		for(int i = 0; i < list.lendItems.size(); i++) {
			System.out.printf(lendItemString(list.lendItems.get(i), format));
		}	
		System.out.println("\n" + lendItemSeparator(format) + "\n" + list.next + " LendItem(s) in list, " + (list.INITIAL_SIZE - list.next) + " free.");
//		return list.next;
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
//		addIndex(list);
//		item.id = list.id;		
		
		return item;
	}	
	public static String lendItemString(LendItem it, int format) { 
		LendItemArrayList list = new LendItemArrayList();
        switch (format) {
        case 1:
            return String.format("\n%d %-15.15s %-10.10s %s", /* %-10.10s", lendItemSeparator(format), s */ list.printPosition(it), it.description, it.lender, /*dateString(it.lendDate),
                    dateString(it.returnDate),*/ it.owner);
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
    			return String.format("%3s %-15.15s %-10.10s %s\n%s ", ID, description, lender, owner, lendItemSeparator(format));
    		case 2:
    			return String.format("%-15.15s %-10.10s\n%s", description, lender, lendItemSeparator(format));
    		default:
    			return String.format("%3s %-15.15s %-10.10s %s %s %-10.10s\n%s", ID, description, lender, lendDate, returnDate, owner, lendItemSeparator(format));		
    		}
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
	}


