package CodingQuestions.OOP.Others.DetermineTime_2446;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateOfTimeFormatter {
    public static void main(String[] args) {
        String [] event1 = {"01:15","02:00"};
        String [] event2 = {"02:00","03:00"};
        DateOfTimeFormatter s = new DateOfTimeFormatter();
        s.compare2(event1,event2);
    }


    public static boolean compare2 (String [] s1, String[] s2) {
        String timeString = "02:00";
        LocalTime time1 = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
        String timeString2 = "12:00";
        LocalTime time2 = LocalTime.parse(timeString2, DateTimeFormatter.ofPattern("HH:mm"));
        return time1.isAfter(time2);
    }
}
