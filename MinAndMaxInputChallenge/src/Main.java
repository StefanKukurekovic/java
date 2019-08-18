import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number:");
        int i = 0, min = 0, max = 0, temp = 0;
        boolean hasNextInt = scanner.hasNextInt();
        do {

            int number = scanner.nextInt();
            scanner.nextLine();
            if(hasNextInt){
                if(number >= max)
                {
                    max = number;
                }else if(number < min || min == 0)
                {
                    min = number;
                }

                // temp = number;
                i++;
            }else{
                System.out.println("The biggest number is => max = " + max);
                System.out.println("The smallest number is => min = " + min);
                break;
            }

        }while (i < 1000);

        System.out.println("The biggest number is => max = " + max);
        System.out.println("The smallest number is => min = " + min);

        scanner.close();
    }
}
