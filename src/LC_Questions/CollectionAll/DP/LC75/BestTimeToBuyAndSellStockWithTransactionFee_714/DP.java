package LC_Questions.CollectionAll.DP.LC75.BestTimeToBuyAndSellStockWithTransactionFee_714;

public class DP {
    public static void main(String[] args) {
        int [] prices = new int [] {1, 3, 2, 8, 4, 9};
        int fee = 2;
        DP solution = new DP();
        solution.test(prices, fee);
    }

    public int test(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;

        int[] hold = new int[n];
        int[] cash = new int[n];
        hold[0] = -prices[0];
        cash[0] = 0;

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i] - fee);
        }
        return cash[n - 1];
    }
}
