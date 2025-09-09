package CodingQuestions.Algorithms.Array.TwoPointers.CountBinary_696;

public class NotSure {
    public static void main(String[] args) {
        countBinarySubstrings("110001111000000");
    }
    public static int countBinarySubstrings(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }
}
