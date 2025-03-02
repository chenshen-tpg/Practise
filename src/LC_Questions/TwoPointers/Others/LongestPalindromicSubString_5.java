package LC_Questions.TwoPointers.Others;

public class LongestPalindromicSubString_5 {
    public static void main(String[] args) {
        String s = "ac";
//        System.out.println("bb".substring(0,2));
        bruteForce(s);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void bruteForce(String s){
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isP(substring) && substring.length() > longestPalindrome.length()) {
                    longestPalindrome = substring;
                }
            }
        }
        System.out.println(longestPalindrome);
    }

    public static boolean isP (String s){
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
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
