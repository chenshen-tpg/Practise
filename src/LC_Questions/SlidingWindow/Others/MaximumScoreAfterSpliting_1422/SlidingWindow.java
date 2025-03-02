package LC_Questions.SlidingWindow.Others.MaximumScoreAfterSpliting_1422;

public class SlidingWindow {
    public static void main(String[] args) {
        System.out.println(helper_onePass("00111"));
    }
    public static int helper_onePass(String s) {
        int maxScore = 0;
        int countZerosLeft = 0;
        int countOnesRight = (int) s.chars().filter(ch -> ch == '1').count();


        for (int i = 0; i < s.length() - 1; i++) {
            countZerosLeft += s.charAt(i) == '0' ? 1 : 0;
            countOnesRight -= s.charAt(i) == '1' ? 1 : 0;
            maxScore = Math.max(maxScore, countZerosLeft + countOnesRight);
        }
        return maxScore;
    }
}
