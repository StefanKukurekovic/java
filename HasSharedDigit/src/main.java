public class main {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(100, 10));
    }

    public static boolean hasSharedDigit (int num1, int num2)
    {
        if((num1 < 10) || (num1 > 99) || (num2 < 10) || (num2 > 99))
        {
            return false;
        }

        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;
        int temp4 = 0;

        temp1 = num1 % 10;
        temp2 = num1 / 10;
        temp3 = num2 % 10;
        temp4 = num2 / 10;

        if((temp1 == temp3) || (temp1 == temp4) || (temp2 == temp4) || (temp2 == temp3))
        {
            return true;
        }else{
            return false;
        }
    }
}
