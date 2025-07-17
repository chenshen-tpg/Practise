package CodingQuestions.Array.ArrayGeneral.Others.ScoreOfAString_3110;

public class SampleAns {
    public static void main(String[] args) {

    }

    public int scoreOfString(String s) {
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int a = i;
            int b = i + 1;
            char first = s.charAt(a);
            char second = s.charAt(b);
            int temp = Math.abs(first - second);
            ans += temp;
        }
        return ans;
    }

}
