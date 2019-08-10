public class SecondsAndMinutes {

    public static String getDurationString (int minutes, int seconds)
    {
        if((minutes < 0) || (seconds < 0) || (seconds > 59))
        {
            return "Invalid value";
        }

        int hour = minutes / 60;
        int min = minutes%60;

        String hoursString = hour + "h";
        if(hour < 10){
            hoursString = "0" + hoursString;
        }

        String minString = min + "m";
        if(min < 10){
            minString = "0" + minString;
        }

        String secondsString = seconds + "s";
        if(seconds < 10){
            secondsString = "0" + secondsString;
        }

        return (hoursString + " " + minString + " " + secondsString);
    }

    public static String getDurationString (int seconds)
    {
        if(seconds < 0)
        {
            return "Invalid value";
        }

        int min = seconds / 60;
        int sec = seconds % 60;

        return getDurationString(min, sec);
    }
}
