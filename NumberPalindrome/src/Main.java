// Palindrome = number which when reversed is equal to
// the original number
// e.g. 121 = 121
// e.g. 1221 = 1221

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
    }

    public static boolean isPalindrome (int number)
    {
        int reverse = 0;
        int lastDigit = 0;

        // if number is negative make it positive (calculation is easier)
        if(number < 0) {
            number *= -1;
        }

        int num = number;

        do{
            // get the last digit
            lastDigit = num % 10;
            reverse = reverse * 10 + lastDigit;
            // remove last digit and start from the beginning
            num /= 10;
        }while(num > 0);
            // check if number and reverse are equal
        if (number == reverse) {
            return true;
        } else {
            return false;
        }

    }
}
