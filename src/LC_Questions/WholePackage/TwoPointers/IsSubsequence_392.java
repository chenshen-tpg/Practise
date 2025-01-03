package LC_Questions.WholePackage.TwoPointers;

public class IsSubsequence_392 {
    public static void main(String[] args) {
        IsSubsequence_392 is = new IsSubsequence_392();
        System.out.println(is.isSubsequenceDP("abc", "ahbgdc"));
    }

    private boolean isSubsequence(String abc, String ahbgdc) {
        for (char ss:abc.toCharArray()) {
            if (!abc.contains(ss+"")) {
                return false;
            }
        }
        return true;
    }
    public boolean isSubsequenceTwoPointers(String s, String t) {
        int ss = 0, sn = s.length(), ts = 0,tn = t.length();
        while (ss < sn && ts < tn) {
            if (s.charAt(ss) == t.charAt(ts)) ss++;
            ts++;
        }
        return ss == sn;
    }
    public boolean isSubsequenceDP(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int col = 1; col <= t.length(); ++col) {
            for (int row = 1; row <= s.length(); ++row) {
                if (s.charAt(row - 1) == t.charAt(col - 1)) dp[row][col] = dp[row - 1][col - 1] + 1;
                else dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
            }
            if (dp[s.length()][col] == s.length()) return true;
        }
        return false;
    }
}
