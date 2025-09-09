package CodingQuestions.Algorithms.Array.ArrayGeneral.BestTimeToBuyAndSellStock_121;

public class OnePassMaxMin {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        OnePassMaxMin solution = new OnePassMaxMin();
        System.out.println(solution.linear(prices));
    }

    public int linear (int [] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        return max;
    }
}
