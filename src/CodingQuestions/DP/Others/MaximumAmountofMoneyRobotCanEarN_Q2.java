package CodingQuestions.DP.Others;

import java.util.Arrays;

public class MaximumAmountofMoneyRobotCanEarN_Q2 {

    public static void main(String[] args) {
        int[][] coins1 = {{0, 1, -1}, {1, -2, 3}, {2, -3, 4}};
        int[][] coins2 = {{10, 10, 10}, {10, 10, 10}};
        System.out.println(maxProfit(coins1)); // Expected output: 8
        System.out.println(maxProfit(coins2)); // Expected output: 40
    }

    public static int maxProfit(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];

        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MIN_VALUE);
            }
        }

        dp[0][0][2] = coins[0][0]; // Start at (0, 0) with 2 neutralizations left

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= 2; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;
                    if (j + 1 < n) {
                        int nextCoins = coins[i][j + 1];
                        if (nextCoins >= 0) {
                            dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i][j][k] + nextCoins);
                        } else if (k > 0) {
                            dp[i][j + 1][k - 1] = Math.max(dp[i][j + 1][k - 1], dp[i][j][k]);
                        }
                        dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i][j][k] + nextCoins);
                    }
                    if (i + 1 < m) {
                        int nextCoins = coins[i + 1][j];
                        if (nextCoins >= 0) {
                            dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k] + nextCoins);
                        } else if (k > 0) {
                            dp[i + 1][j][k - 1] = Math.max(dp[i + 1][j][k - 1], dp[i][j][k]);
                        }
                        dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k] + nextCoins);
                    }
                }
            }
        }

        return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}
