public class BarkingDog {
    public static boolean shouldWakeUp(boolean barking, int hour){
        if(barking && (hour > 0 && hour < 23))
        {
            if(hour < 8 || hour >= 22)
            {
                return true;
            }
        }
        return false;
    }
}
