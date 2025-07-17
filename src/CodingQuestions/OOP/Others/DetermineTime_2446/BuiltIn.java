package CodingQuestions.OOP.Others.DetermineTime_2446;

public class BuiltIn {
    public static void main(String[] args) {

    }
    public boolean haveConflict(String[] event1, String[] event2) {
        return (event1[1].compareTo(event2[0]) >= 0) && (event1[0].compareTo(event2[1]) <= 0);
    }
}
