package CodingQuestions.Algorithms.Array.ArrayGeneral.BestTimeToBuyAndSellStockII_122;

public class BruteForce {
    public static void main(String[] args) {
        BruteForce solution = new BruteForce();
        int [] prices = {7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    public int calculate(int prices[], int s) {
        if (s >= prices.length) return 0;
        int max = 0;
        for (int i = s; i < prices.length; i++) {
            int maxprofit = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    int profit = calculate(prices, j + 1) + prices[j] - prices[i];
                    if (profit > maxprofit) maxprofit = profit;
                }
            }
            if (maxprofit > max) max = maxprofit;
        }
        return max;
    }
}
