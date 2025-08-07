package CodingQuestions.DP.LongestCommonSubsequence_1143;

import java.util.Arrays;

public class TD_DP {
    private static int[][] memo;

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        memo = new int[m + 1][n + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return lcsHelper(text1, text2, m, n);
    }
    private static int lcsHelper(String text1, String text2, int i, int j) {
        if (i == 0 || j == 0) return 0; // Base case
        if (memo[i][j] != -1) return memo[i][j]; // Check memo

        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            memo[i][j] = 1 + lcsHelper(text1, text2, i - 1, j - 1);
        } else {
            memo[i][j] = Math.max(lcsHelper(text1, text2, i - 1, j), lcsHelper(text1, text2, i, j - 1));
        }

        return memo[i][j];
    }
}
