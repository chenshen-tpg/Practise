package LC_Questions.CollectionAll.Array.LC150.BestTimeToBuyAndSellStockII_122;

public class Linear {
    public static void main(String[] args) {
        Linear solution = new Linear();
        int [] prices = {7,1,5,3,6,4};
        solution.linear(prices);
    }
    public int linear (int [] prices) {
        int i = 0;
        int valley, peak ;
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}
