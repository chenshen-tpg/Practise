package CodingQuestions.DP.LC150.UniquePathII_63;

import java.util.Arrays;

public class UniquePaths_62 {
    public static void main(String[] args) {
        helper(3,7);
    }
    public static void helper(int r, int c) {
        int [][] dp = new int [r][c];
        for (int[] arr : dp) Arrays.fill(arr, 1);
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
//        int[][] dp = new int[r][c];
//        for (int[] arr : dp) Arrays.fill(arr, 1);
//        for (int i = 1; i < r; ++i) {
//            for (int j = 1; j < c; ++j) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
        System.out.println(dp[r-1][c-1]);
    }
}
