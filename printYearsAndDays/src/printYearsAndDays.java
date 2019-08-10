public class printYearsAndDays {

    public static void printYearsAndDays (long minutes)
    {
        if(minutes < 0)
        {
            System.out.println("Invalid Value");
        }else{
            long year = minutes / 365 / 24 / 60;
            long days = minutes % (365*24*60) / 24 / 60;

            System.out.println(minutes + " min = " + year + " y and " + days + " d");
        }
    }
}
