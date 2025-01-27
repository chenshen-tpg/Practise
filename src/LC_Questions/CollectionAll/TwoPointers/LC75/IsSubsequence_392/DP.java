package LC_Questions.CollectionAll.TwoPointers.LC75.IsSubsequence_392;

public class DP {
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
