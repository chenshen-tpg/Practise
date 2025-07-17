package CodingQuestions.DP.LC150.BestTimeToBuyAndSellStockIII_123;

public class BestTimetoBuyandSellStockIII_123 {
    public static void main(String[] args) {
        int[] prices4 = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        BestTimetoBuyandSellStockIII_123 obj = new BestTimetoBuyandSellStockIII_123();
        System.out.println(obj.maxProfit_Why(prices4));
    }

    public int maxProfit_Why(int[] prices) {
        int t1Cost = Integer.MAX_VALUE, t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0, t2Profit = 0;
        for (int price : prices) {
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);
            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }
        return t2Profit;
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
