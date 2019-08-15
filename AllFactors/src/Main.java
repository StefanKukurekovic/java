public class Main {
    public static void main(String[] args) {
        printFactors(10);
    }

    public static void printFactors (int number)
    {
        if (number < 1){
            System.out.println("Invalid Value");
        }

        for(int i = 1; i <= number; i++)
        {
            if (number % i == 0)
            {
                int sum = 0;
                sum += i;
            }
        }

        if(number == sum)
        {
            System.out.println(sum);
        }else{
            System.out.println("Not perfect number");
        }

    }
}
