package LC_Questions.OOP.Others.DetermineTime_2446;

public class Replace {
    public static void main(String[] args) {

    }
    public static boolean compare (String [] s1, String[] s2) {
        int timeF = Integer.valueOf(s1[1].replace(":",""));
        int timeS = Integer.valueOf(s2[0].replace(":",""));
        return timeF > timeS;
    }
}
