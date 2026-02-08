package Preparation.General.LeetCodeStyle.BestTimeToBuyAndSellStockQ4.BestTimeToBuyAndSell_122;

public class SampleAns1 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) maxprofit +=
                    prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
