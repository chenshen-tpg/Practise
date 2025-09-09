package CodingQuestions.Algorithms.Array.ArrayGeneral.LongestPalinDromicSub_5;

public class BruteForce {
    public static void main(String[] args) {

    }
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (helper(temp) && temp.length() > ans.length()) {
                    ans = temp;
                }
            }
        }
        return ans;
    }

    public boolean helper(String s) {
        if (s.length() == 1)
            return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
