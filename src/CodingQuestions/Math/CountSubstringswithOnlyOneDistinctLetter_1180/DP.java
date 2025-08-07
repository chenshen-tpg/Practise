package CodingQuestions.Math.CountSubstringswithOnlyOneDistinctLetter_1180;

public class DP {

    public static void main(String[] args) {

    }

    public int countLetters(String s) {
        int [] substrings = new int[s.length()];
        int total = 1;
        substrings[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                substrings[i] = substrings[i - 1] + 1;
            } else {
                substrings[i] = 1;
            }
            total += substrings[i];
        }
        return total;
    }
}
