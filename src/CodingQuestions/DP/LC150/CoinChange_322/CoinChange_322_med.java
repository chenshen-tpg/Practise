package CodingQuestions.DP.LC150.CoinChange_322;

public class CoinChange_322_med {
    public static void main(String[] args) {
        CoinChange_322_med cc = new CoinChange_322_med();
        System.out.println(cc.coinChangeBruteForce(new int[]{1, 2, 5}, 11));
    }
    public int coinChangeBruteForce(int [] coins, int amount) {
        return helper(0, coins, amount);
    }
    public int helper (int coin, int [] coins, int amount) {
        if (amount == 0) return 0;
        if (coin < coins.length && amount > 0) {
            int maxVal = amount / coins[coin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[coin]) {
                    int res = helper(coin + 1, coins, amount - x * coins[coin]);
                    if (res != -1) {
                        minCost = Math.min(minCost, res + x);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }
}
