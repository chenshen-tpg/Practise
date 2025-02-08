package LC_Questions.CollectionAll.Array.LC150.BestTimeToBuyAndSellStockII_122;

public class DP_solution {
    public static void main(String[] args) {
        DP_solution solution = new DP_solution();
        int [] prices = {7,1,5,3,6,4};
        System.out.println(solution.maxProfitSeparate(prices));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[n-1][0];
    }
    public int maxProfitSeparate(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int [] hold = new int [n];
        int [] buy = new int [n];
        hold[0] = -prices[0];
        buy[0] = 0;
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i-1], hold[i-1] + prices[i]);
            hold[i] = Math.max(hold[i - 1], buy[i-1] - prices[i]);
        }

        return buy[n - 1];
    }
}
