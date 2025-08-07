package CodingQuestions.DP.LongestPalindromicSubString_5;

public class TwoPointers {

    public static void main(String[] args) {
    }

    public static void bruteForce_correct(String s){
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String substring = s.substring(i, j);
                if (isP1(substring) && substring.length() > longestPalindrome.length()) {
                    longestPalindrome = substring;
                }
            }
        }
        System.out.println(longestPalindrome);
    }

    public static boolean isP1 (String s){
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
