package CodingQuestions.Array.ArrayGeneral.LC150.BestTimeToBuyAndSellStockII_122;

public class ModifiedLinear {
    public static void main(String[] args) {
        ModifiedLinear solution = new ModifiedLinear();
        int [] prices = {7,1,5,3,6,4};
        System.out.println(solution.linear(prices));
    }

    private int linear(int[] prices) {
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                count += prices[i] - prices[i-1];
            }
        }
        return count;
    }
}
