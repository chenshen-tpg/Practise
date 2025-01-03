package LC_Questions.WholePackage.ClassicQ;

public class BestTimeToBuyAndSellStock_121 {
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(helperOne(prices1));
    }

    public static int helper (int [] list) {
        int [][] memo = new int [list.length][list.length];
        int ans = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                ans = Math.max(ans, list[j] - list[i]);
            }
        }
        return ans;
    }

    public static int helperOne (int [] list) {
        int ans = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < list.length; i++) {
            if (list[i] < min){
                min = list[i];
            }
            if (list[i] - min > ans) {
                ans = list[i] - min;
            }
        }
        return ans;
    }
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i<prices.length; i++){
            dp[i] = Math.max(dp[i-1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return dp[prices.length-1];
    }

}
