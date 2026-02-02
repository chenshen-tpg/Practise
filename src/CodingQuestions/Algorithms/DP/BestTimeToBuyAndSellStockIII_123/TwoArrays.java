package CodingQuestions.Algorithms.DP.BestTimeToBuyAndSellStockIII_123;

public class TwoArrays {
    public static void main(String[] args) {
        int[] prices4 = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        TwoArrays obj = new TwoArrays();
        System.out.println(obj.maxProfit(prices4));
    }


    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) return 0;
        int leftMin = prices[0];
        int rightMax = prices[length - 1];
        int[] leftProfits = new int[length];
        int[] rightProfits = new int[length + 1];
        for (int l = 1; l < length; ++l) {
            leftProfits[l] = Math.max(leftProfits[l - 1], prices[l] - leftMin);
            leftMin = Math.min(leftMin, prices[l]);
            int r = length - 1 - l;
            rightProfits[r] = Math.max(rightProfits[r + 1], rightMax - prices[r]);
            rightMax = Math.max(rightMax, prices[r]);
        }
        int maxProfit = 0;
        for (int i = 0; i < length; ++i) {
            maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i + 1]);
        }
        return maxProfit;
    }

}
