package LC_Questions.WholePackage.Array;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DetermineTime_2446_EZ {
    public static void main(String[] args) {
        String [] event1 = {"01:15","02:00"};
        String [] event2 = {"02:00","03:00"};
        DetermineTime_2446_EZ s = new DetermineTime_2446_EZ();
        s.haveConflict(event1,event2);
    }
    public boolean haveConflict(String[] event1, String[] event2) {
        return (event1[1].compareTo(event2[0]) >= 0) && (event1[0].compareTo(event2[1]) <= 0);
    }

    public static boolean compare (String [] s1, String[] s2) {
        int timeF = Integer.valueOf(s1[1].replace(":",""));
        int timeS = Integer.valueOf(s2[0].replace(":",""));
        return timeF > timeS;
    }

    public static boolean compare2 (String [] s1, String[] s2) {
        String timeString = "02:00";
        LocalTime time1 = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
        String timeString2 = "12:00";
        LocalTime time2 = LocalTime.parse(timeString2, DateTimeFormatter.ofPattern("HH:mm"));
        return time1.isAfter(time2);
    }
}
