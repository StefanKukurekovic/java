import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sum = 0, i = 1;
        do{
            System.out.print("Enter number #" + i + ": ");

            boolean hasNextInt = scanner.hasNextInt();
            if(hasNextInt) {
                int number = scanner.nextInt();
                scanner.nextLine();
                sum += number;
                i++;
            }else{
                System.out.println("Invalid Value!");
                break;
            }
        }while (i <= 10);


        System.out.println("The sum of all ten numbers is " + sum);
        scanner.close();
    }
}
