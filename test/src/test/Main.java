package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
		
		private static Scanner sc = new Scanner(System.in);
		
	public static void main(String[] args) {
		LendItemArrayList list = new LendItemArrayList();
		LendItem item = new LendItem();
		
		
		
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
        		list.printLendItems();
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
	}
	
	public static void removeLendItem(LendItemArrayList list, int n)
	{
		list.removeLendItem(n-1);
	}
	
	public static void list(LendItemArrayList list, int n)
	{
		for(int i = 0; i < list.length; i++) {
			
		}
	}
	
	list.printLendItems();
	
	
	// Displays start menu at the beginning 
    public static void Menu()
    {
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
//		item.ID++;
		
		return item;
	}
	
	// Prints out the array list
//	public static void printList(LendItemArrayList list) {
////		System.out.println("List is Empty: " + isEmpty(list));
////		System.out.println("List is Full:  " + isFull(list));
//		for(int i = 0; i < list.length(); i++) {
//			if(i >= list.next) {
//				System.out.print("_ ");
//				continue;
//			}
//			
//			System.out.print(list.lendItems[i] + " ");
//		}
//		System.out.println();
//		System.out.println();
//	}
	
	
	public static String lendItemString(LendItem it, int format) {
        switch (format) {
        case 1:
            return String.format("%-15.15s %-10.10s %s", /* %-10.10s", lendItemHeadings(format), it.ID, */ it.description, it.lender, /*dateString(it.lendDate),
                    dateString(it.returnDate),*/ it.owner);
//        case 2:
//            return String.format("%s\n%-15.15s %-10.10s", lendItemHeadings(format), it.description, it.lender);
//        default:
//            return String.format("%s\n\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"", lendItemHeadings(format), it.ID, it.description, it.lender,
//                    dateString(it.lendDate), dateString(it.returnDate), it.owner);

    }

}
