package CodingQuestions.DP.LC75.DominoAndTrominoTiling_790;

public class TEST {
    public static void main(String[] args) {
        numTilings(3);
    }
    public static int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n <= 2) return n;
        long [] memo = new long [n + 1];
        memo[0] = 1L;
        memo[1] = 2L;
        memo[2] = 5L;
        for (int i = 3; i <= n; i++) {
            memo[i] = (memo[i - 1] * 2 + memo[i - 3]) % MOD;
        }
        return (int)memo[n - 1];
    }
}
