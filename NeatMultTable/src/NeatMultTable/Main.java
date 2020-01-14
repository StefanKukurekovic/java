package NeatMultTable;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LendItem it1 = new LendItem(), it2 = new LendItem();
        //System.out.printf("Welcome to LendApp\n");
        int mode = 0, format = 1;
        

        String input = "";
        do {
        	Menu();
            //System.out.printf("enter opcode (9 for usage): ");
            // input = sc.nextInt();
            input = sc.nextLine();
            switch (input) {
            case "1":
                it1 = scanLendItem(sc);
                break;
//            case "2":
//                it2 = scanLendItem(sc);
//                break;
//            case "3":
//                System.out.printf("%s\n", lendItemString(it1, format));
//                System.out.printf("%s\n", lendItemString(it2, format));
//                break;
//            case "4":
//                System.out.printf("set compare mode (" + "1=by lend date, " + "2=by return date, " + "3=by lender, "
//                        + "4=by owner, " + "all other=by description: ");
//                mode = sc.nextInt();
//                break;
//            case "5":
//                int cmp = compare(it1, it2, mode);
//                if (cmp < 0)
//                    System.out.printf("LendItem1 is before LendItem2.\n");
//                else if (cmp > 0)
//                    System.out.printf("LendItem1 is after LendItem2.\n");
//                else
//                    System.out.printf("LendItems are equal.\n");
//                break;
//            case "6":
//                System.out.printf("LendItem1 and LendItem2 are %s equal.\n", equals(it1, it2) ? "" : "not");
//                break;
//            case "9":
//                System.out.printf("1 enter LendItem1\n" + "2 enter LendItem2\n" + "3 print LendItem1 and 2\n"
//                        + "4 set compare mode\n" + "5 compare the LendItems\n" + "6 check equality\n"
//                        + "9 display this message\n" + "0 exit\n");
//                break;
//            case "0":
//                break;
//            default:
//                System.out.println("invalid op code");
            }

        } while (input != null && !input.equals(""));
        sc.close();
        System.out.printf("Thank you for using LendApp.\n");
    }
    
    // Displays start menu at the beginning 
    public static void Menu()
    {
    	System.out.println("1) list");
    	System.out.println("2) add");
    	System.out.println("3) remove");
    	System.out.println("4) sort");
    	System.out.println("5) filter");
    	System.out.println("6) set format");
    	System.out.println("0) quit");
    }
    
    public static String lendItemString(LendItem it, int format) {
        switch (format) {
        case 1:
            return String.format("%s\n%3d %-15.15s %-10.10s %s %s %-10.10s", lendItemHeadings(format), it.ID, it.description, it.lender, dateString(it.lendDate),
                    dateString(it.returnDate), it.owner);
        case 2:
            return String.format("%s\n%-15.15s %-10.10s", lendItemHeadings(format), it.description, it.lender);
        default:
            return String.format("%s\n\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"", lendItemHeadings(format), it.ID, it.description, it.lender,
                    dateString(it.lendDate), dateString(it.returnDate), it.owner);
        }

    }
    
    // Creates heading for tabular display of lend items
    public static String lendItemHeadings (int format)
	{
		String ID = "ID", description = "description", lender = "lender", lendDate = "lend date", returnDate = "return date", owner = "owner";
		
		switch(format) {
		case 1:
			return String.format("%3s %-15.15s %-10.10s %s %s %-10.10s\n%s", ID, description, lender, lendDate, returnDate, owner, lendItemSeparator(format));
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
    
//    // returns a String of a date object in the format <yyyy>.<mm>.<dd>
//    private static String dateString(Date d) {
//        return String.format("%04d.%02d.%02d", d.year, d.month, d.day);
//    }
//
//    /**
//     * compares two LendItems<br>
//     * the method of comparison is controlled by method.
//     * <ul>
//     * <li>1: compare by lend date</li>
//     * <li>2:compare by return date</li>
//     * <li>3:compare by lender</li>
//     * <li>4:compare by owner</li>
//     * <li>all other values:compare by description</li>
//     * 
//     * returns -1 if the it1 is before it2, 1 if the other way round, 0 if they are
//     * the same. <br>
//     * Note: any two null-LendItems are equal and any null-LendItem goes before any
//     * non-LendItem event.
//     * 
//     * @param it1
//     * @param it2
//     * @return
//     */
//    public static int compare(LendItem it1, LendItem it2, int method) {
//        switch (method) {
//        case 1:
//            return compareByLendDate(it1, it2);
//        case 2:
//            return compareByReturnDate(it1, it2);
//        case 3:
//            return compareByLender(it1, it2);
//        case 4:
//            return compareByOwner(it1, it2);
//        default:
//            return compareByDescription(it1, it2);
//        }
//    }
//
//    /**
//     * compares two LendItems by lend date <br>
//     * returns -1 if the lend date of it1 is before than of it2, 1 if the other way
//     * round, 0 if they are the same.<br>
//     * Note: any two null-LendItems are equal and any null-LendItem goes before any
//     * non-LendItem event.
//     * 
//     * @param it1
//     * @param it2
//     * @return
//     */
//    public static int compareByLendDate(LendItem it1, LendItem it2) {
//        if (it1 == null && it2 == null)
//            return 0;
//        if (it1 == null)
//            return -1;
//        if (it2 == null)
//            return 1;
//
//        return compare(it1.lendDate, it2.lendDate);
//    }
//
//    /**
//     * compares two LendItems by return date <br>
//     * returns -1 if the return date of it1 is before than of it2, 1 if the other
//     * way round, 0 if they are the same. <br>
//     * Note: any two null-LendItems are equal and any null-LendItem goes before any
//     * non-LendItem event.
//     * 
//     * @param it1
//     * @param it2
//     * @return
//     */
//    public static int compareByReturnDate(LendItem it1, LendItem it2) {
//        if (it1 == null && it2 == null)
//            return 0;
//        if (it1 == null)
//            return -1;
//        if (it2 == null)
//            return 1;
//
//        return compare(it1.returnDate, it2.returnDate);
//    }
//
//    /**
//     * compares two LendItems by description<br>
//     * returns -1 if the description of it1 is before than of it2, 1 if the other
//     * way round, 0 if they are the same. <br>
//     * descriptions are compared lexicographically (see String.compareTo) <br>
//     * Note: any two null-LendItems are equal and any null-LendItem goes before any
//     * non-LendItem event.
//     * 
//     * @param it1
//     * @param it2
//     * @return
//     */
//    public static int compareByDescription(LendItem it1, LendItem it2) {
//        if (it1 == null && it2 == null)
//            return 0;
//        if (it1 == null)
//            return -1;
//        if (it2 == null)
//            return 1;
//
//        int res = it1.description.compareTo(it2.description);
//        if (res > 0)
//            return 1;
//        if (res < 0)
//            return -1;
//        return 0;
//    }
//
//    /**
//     * compares two Date<br>
//     * returns -1 if d1 is before it2, 1 if the other way round, 0 if they are the
//     * same. <br>
//     * Note: any two null-Dates are equal and any null-Dates goes before any
//     * non-null Date.
//     * 
//     * @param it1
//     * @param it2
//     * @return
//     */
//    public static int compare(Date d1, Date d2) {
//        if (d1 == null && d2 == null)
//            return 0;
//        if (d1 == null)
//            return -1;
//        if (d2 == null)
//            return 1;
//
//        int res = (d1.day + d1.month * 100 + d1.year * 10000) - (d2.day + d2.month * 100 + d2.year * 10000);
//
//        if (res > 0)
//            return 1;
//        if (res < 0)
//            return -1;
//        return 0;
//
//    }
//
//    /**
//     * compares two LendItems by lender <br>
//     * returns -1 if the lender of it1 is before than of it2, 1 if the other way
//     * round, 0 if they are the same. <br>
//     * lenders are compared lexicographically (see String.compareTo) <br>
//     * Note: any two null-LendItems are equal and any null-LendItem goes before any
//     * non-LendItem event.
//     * 
//     * @param it1
//     * @param it2
//     * @return
//     */
//    public static int compareByLender(LendItem it1, LendItem it2) {
//        if (it1 == null && it2 == null)
//            return 0;
//        if (it1 == null)
//            return -1;
//        if (it2 == null)
//            return 1;
//
//        int res = it1.lender.compareTo(it2.lender);
//        if (res > 0)
//            return 1;
//        if (res < 0)
//            return -1;
//        return 0;
//    }
//
//    /**
//     * compares two LendItems by owner <br>
//     * returns -1 if the owner of it1 is before than of it2, 1 if the other way
//     * round, 0 if they are the same. <br>
//     * owner are compared lexicographically (see String.compareTo) <br>
//     * Note: any two null-LendItems are equal and any null-LendItem goes before any
//     * non-LendItem event.
//     * 
//     * @param it1
//     * @param it2
//     * @return
//     */
//    public static int compareByOwner(LendItem it1, LendItem it2) {
//        if (it1 == null && it2 == null)
//            return 0;
//        if (it1 == null)
//            return -1;
//        if (it2 == null)
//            return 1;
//
//        int res = it1.owner.compareTo(it2.owner);
//        if (res > 0)
//            return 1;
//        if (res < 0)
//            return -1;
//        return 0;
//    }
//
//    /**
//     * tests equality of two LendItems<br>
//     * two LendItems are equal if and only if ALL their values are equal.
//     * 
//     * 
//     * @param it1
//     * @param it2
//     * @return
//     */
//    public static boolean equals(LendItem it1, LendItem it2) {
//        if (it1 == null && it2 == null)
//            return true;
//        if (it1 == null || it2 == null)
//            return false;
//
//        return it1.description.equals(it2.description) && it1.lender.equals(it2.lender) && it1.owner.equals(it2.owner)
//                && equals(it1.lendDate, it2.lendDate) && equals(it1.returnDate, it2.returnDate);
//
//    }
//
//    /**
//     * tests equality of two Dates<br>
//     * two Dates are equal if and only if ALL their values are equal.
//     * 
//     * 
//     * @param it1
//     * @param it2
//     * @return
//     */
//    public static boolean equals(Date d1, Date d2) {
//        if (d1 == null && d2 == null)
//            return true;
//        if (d1 == null || d2 == null)
//            return false;
//
//        return d1.day == d2.day && d1.month == d2.month && d1.year == d2.year;
//    }
//
//    /**
//     * interactively scans a LendItem on the console.<br>
//     * this function prompts the user for input for the values of
//     * <ul>
//     * <li>description</li>
//     * <li>lender</li>
//     * <li>owner</li>
//     * </ul>
//     * 
//     * both description and lender cannot be left empty, in which case input for all
//     * of the above values is repeated after a short error message "<field> cannot
//     * be empty!".
//     * 
//     * After the first input phase is completed, the lend date is scanned using
//     * scanDate.
//     * 
//     * finally a new LendItem instance is returned.
//     * 
//     * @return
//     */
//    public static LendItem scanLendItem(Scanner sc) {
//
//        String desc = "", lender = "", owner = "";
//        while(true) {
//            System.out.printf("description: ");
//            desc = sc.nextLine();
//            // System.out.printf("*** scanned description: %s ***\n", desc);
//
//            System.out.printf("lender: ");
//            lender = sc.nextLine();
//            // System.out.printf("*** scanned lender: %s ***\n", lender);
//
//            System.out.printf("owner: ");
//            owner = sc.nextLine();
//            // System.out.printf("*** scanned owner: %s ***\n", owner);
//
//            if (desc.isEmpty()) {
//                System.out.printf("description cannot be empty!\n");
//                continue;
//            }
//            if (lender.isEmpty()) {
//                System.out.printf("lender cannot be empty!\n");
//                continue;
//            }
//
//            break;
//        }
//
//        LendItem it = new LendItem();
//        it.description = desc;
//        it.lender = lender;
//        it.owner = owner;
//        System.out.printf("lend date:\n");
//        it.lendDate = scanDate(sc);
//        System.out.printf("return date:\n");
//        it.returnDate = scanDate(sc);
//
//        return it;
//    }

//    /**
//     * interactively scans a Date on the console.<br>
//     * this function prompts the user for input for the values of
//     * <ul>
//     * <li>year</li>
//     * <li>month</li>
//     * <li>day</li>
//     * </ul>
//     * 
//     * Only simple input validation is performed. years must be after 1581, months
//     * must be out of the range [1-12], and days must be out of the range [1-31].
//     * After invalid input, input for all values is repeated (After short error
//     * messages for the first invalid value is displayed.)
//     * 
//     * 
//     * @return
//     */
//    public static Date scanDate(Scanner sc) {
//        int y, m, d;
//        while(true) {
//            System.out.printf("year: ");
//            y = Integer.parseInt(sc.nextLine());
//            System.out.printf("month: ");
//            m = Integer.parseInt(sc.nextLine());
//            System.out.printf("day: ");
//            d = Integer.parseInt(sc.nextLine());
//            if (y < 1582) {
//                System.out.printf("year cannot be before 1582!\n");
//                continue;
//            }
//            if (m < 1 || m > 12) {
//                System.out.printf("month must be 1-12!\n");
//                continue;
//            }
//            if (d < 1 || d > 31) {
//                System.out.printf("day must be 1-31!\n");
//                continue;
//            }
//
//            break;
//        }
//        Date dat = new Date();
//        dat.day = d;
//        dat.month = m;
//        dat.year = y;
//        return dat;
//    }

//    /**
//     * computes whether a LendItem is currently lent (out)<br>
//     * 
//     * if the return date is not set (null) a LendItem is considered to be not
//     * returned yet and thus "out"
//     * 
//     * @param li
//     * @return
//     */
//    public static boolean isOut(LendItem li) {
//        return li.returnDate == null;
//    }
//}






//package NeatMultTable;
//
//import java.util.Scanner;
//
////import LendItems.LendItem;
//
//public class Main {
//
//	public static void main(String[] args) {
//		
//		System.out.printf(lendItemString(1));
//		
//		
//		
//	}
//	
//	public static String lendItemString(/*LendItem it,*/ int format) {
//		int ID = 86;
//		String description = "Some new stuff I bought";
//		String lender = "Mei bruder";
//		String dateLend = "13.04.1990";
//		String dateReturn = "13.05.2020";
//		String owner = "Ma schwesta";
//		
//        switch (format) {
//        case 1:
//            return String.format("%s\n%3d %-15.15s %-10.10s %s %s %-10.10s", lendItemHeadings(format), ID, description, lender, dateLend, dateReturn, owner /*it.ID, it.description, it.lender, dateString(it.lendDate),
//                    dateString(it.returnDate), it.owner*/);
//        case 2:
//            return String.format("%-15.15s %-10.10s", description, lender/* it.description, it.lender*/);
//        default:
//            return String.format("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"", description, lender, dateLend, dateReturn, owner /*it.description, it.lender,
//                    dateString(it.lendDate), dateString(it.returnDate), it.owner*/);
//        }
//
//    }
//	
//	public static String lendItemHeadings (int format)
//	{
//		String ID = "ID", description = "description", lender = "lender", lendDate = "lend date", returnDate = "return date", owner = "owner";
//		
//		switch(format) {
//		case 1:
//			return String.format("%3s %-15.15s %-10.10s %s %s %-10.10s\n%s", ID, description, lender, lendDate, returnDate, owner, lendItemSeparator(format));
//		case 2:
//			return String.format("%-15.15s %-10.10s\n%s", description, lender, lendItemSeparator(format));
//		default:
//			return String.format("%3s %-15.15s %-10.10s %s %s %-10.10s\n%s", ID, description, lender, lendDate, returnDate, owner, lendItemSeparator(format));		
//		}
//	}
//	
//	public static String lendItemSeparator(int format)
//	{
//		String dashOne = "------------------------------------------------------------------";
//		String dashTwo = "-------------------------";
//		String dashDefault = "------------------------------------------------------------------";
//		switch (format) {
//		case 1:
//			return String.format("%s", dashOne);
//		case 2:
//			return String.format("%s", dashTwo);
//		default:
//			return String.format("%s", dashDefault);
//		}
//	
//	}
//	
//	
//}
		
// ID description lender lend date return date owner
//------------------------------------------------------------------
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("enter rows: ");
//		int xrows = sc.nextInt();
//
//		System.out.print("enter columns: ");
//		int xcols = sc.nextInt();
//
//		System.out.printf("\n%4s", "");
//		for (int i = 1; i <= xcols; i++)
//			System.out.printf("%3d", i);
//		System.out.println();
//
//		for (int i = 0; i < 4 + xcols * 3; i++)
//			System.out.print('-');
//
//		for (int i = 1; i <= xrows; i++) {
//			System.out.printf("%s%2d |", System.lineSeparator(), i);
//			for (int j = 1; j <= xcols; j++) {
//				System.out.printf("%3d", i * j);
//			}
//		}
//		sc.close();
//	}
//}
