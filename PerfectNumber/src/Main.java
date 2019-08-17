public class Main {
    public static void main(String[] args) {
        System.out.println(printFactors(-20));
    }

    // A perfect number is a positive integer which is equal
    // to the sum of its proper positive divisors
    // e.g. 6 is perfect number since its factors 1+2+3=6
    // e.g. 28 is perfect number since its factors 1+2+4+7+14=28
    public static boolean isPerfectNumber (int number)
    {
        // if given number is less than 1, then "Invalid Value"
        if (number < 1){
            System.out.println("Invalid Value");
            return false;
        }

        int sum = 0;
        // find factors of given number, starting from 1, up to number-1
        for(int i = 1; i < number; i++)
        {
            // if it is factor, add it to the sum
            if (number % i == 0)
            {
                sum += i;
            }
            // if sum = starting number, than this number is "perfect"
            if(sum == number)
            {
                return true;
            }
        }
        return false;
    }
}
