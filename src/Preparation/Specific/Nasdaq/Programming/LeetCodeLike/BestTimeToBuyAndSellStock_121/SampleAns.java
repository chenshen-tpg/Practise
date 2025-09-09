package Preparation.Specific.Nasdaq.Programming.LeetCodeLike.BestTimeToBuyAndSellStock_121;

public class SampleAns {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                if (prices[i] - min > res) {
                    res = prices[i] - min;
                }
            }
        }
        return res;
    }
}
