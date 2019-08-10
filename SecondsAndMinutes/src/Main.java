public class Main {
    public static void main(String[] args) {


        String temp = SecondsAndMinutes.getDurationString(61, 0);
        System.out.println(temp);

        String temp2 = SecondsAndMinutes.getDurationString(870);
        System.out.println(temp2);
    }
}
