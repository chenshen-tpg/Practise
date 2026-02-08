package Preparation.General.LeetCodeStyle.BestTimeToBuyAndSellStockQ4.BestTimeToBuyAndSell_122;

public class SampleAns2 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int i = 0;
        int low = prices[0];
        int high = prices[0];
        int max = 0;
        while (i < prices.length - 1) {
            while(i < prices.length - 1 && prices[i] >= prices[i+1]) i++;
            low = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i+1]) i++;
            high = prices[i];
            max += high - low;
        }
        return max;
    }
}
