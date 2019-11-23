package StudentID;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("enter studentID (wi**b***): ");
		String studID = sc.next();
		System.out.printf("ID valid: %s\n", validate(studID));
		System.out.printf("graduation in: %d\n", graduation(studID));
		sc.close();
	
	}
	
	public static boolean validate(String studID) {
		
		String studIdCheck = "(wi)[0-9]{2}b[0-9]{3}";
		
		if(studID.matches(studIdCheck)){
			return true;
		}
		
		return false;
	}
//	validates studID as a student ID using regular expressions.
	
	
	public static int graduation(String studID) {
		
		if(!validate(studID))
		{
			return -1;
		}
		
		String[] yearArr = studID.split("i");
		String idYear = yearArr[1];
		
		yearArr = idYear.split("b");
		idYear = yearArr[0];
		
		int graduation = Integer.parseInt(idYear);
		
		graduation += 2003;
		
		if(graduation < 2003)
		{
			return -1;
		}
		
		return graduation;		
	}
//	calculates the year of graduation for a student with studID. The year of graduation is three
//	years after matriculation, and matriculation is assumed to be 2000 or later. Returns -1 if
//	studID is not a valid ID.
}
