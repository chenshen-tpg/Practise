package LC_Questions.CollectionAll.Array.LC150.StockBuyAndSell;

public class BestTimetoBuyandSellStockII_122 {
    public static void main(String[] args) {
        method();
    }
    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    public int calculate(int prices[], int s) {
        if (s >= prices.length) return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit) maxprofit = profit;
                }
            }
            if (maxprofit > max) max = maxprofit;
        }
        return max;
    }
    public static void method() {
        int [] test  = {7,1,5,3,6,4};
        int hi = Integer.MAX_VALUE;
        int lo = Integer.MAX_VALUE;
        int amount = 0;
        int total = 0;
        for (int i = 1; i < test.length; i++) {
                if(test[i] > test[i-1]) {
                    amount += test[i] - test[i-1];
                }
        }
        System.out.println(amount);
        for (int i = 0; i < test.length; i++) {
            if (test[i] < hi) {
                total += hi - lo;
                hi = test[i];
                lo = hi;
            } else {
                hi = test[i];
            }
        }
        total += hi-lo;

        System.out.println(total);
    }
}
