package LC_Questions.CollectionAll.DP.LC75.LongestCommonSubsequence_1143;

public class DP {
    public static void main(String[] args) {
        String text1 = "abcccccde", text2 = "abfce";
        DP solution = new DP();
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); ++i)
            for (int j = 1; j <= s2.length(); ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        return dp[s1.length()][s2.length()];
    }
}
