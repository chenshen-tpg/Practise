package CodingQuestions.Algorithms.DP.DominoAndTrominoTiling_790;

public class DP {
    public static void main(String[] args) {
        //1 -> 1
        //2 -> 2
        //3 -> 5
        //4 -> 10

    }
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n <= 2) {
            return n;
        }
        long[] f = new long[n + 1];
        long[] p = new long[n + 1];
        f[1] = 1L;
        f[2] = 2L;
        p[2] = 1L;
        for (int k = 3; k < n + 1; ++k) {
            f[k] = (f[k - 1] + f[k - 2] + 2 * p[k - 1]) % MOD;
            p[k] = (p[k - 1] + f[k - 2]) % MOD;
        }
        return (int) (f[n]);
    }
}
