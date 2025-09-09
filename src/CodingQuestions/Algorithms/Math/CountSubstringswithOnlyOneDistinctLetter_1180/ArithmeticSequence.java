package CodingQuestions.Algorithms.Math.CountSubstringswithOnlyOneDistinctLetter_1180;

public class ArithmeticSequence {
    public static void main(String[] args) {

    }

    public int countLetters(String s) {
        int res = 0, j = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) != s.charAt(j)) {
                int len = i - j;
                res += (1 + len) * len / 2;
                j = i;
            }
        }
        return res;
    }
}
