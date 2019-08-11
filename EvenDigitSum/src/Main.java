public class Main {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12,90));
    }

    public static boolean hasSharedDigit(int first, int second)
    {
        if((first < 10) || (first > 99) || (second < 10) || (second > 99))
        {
            return false;
        }

        return true;
    }
}
