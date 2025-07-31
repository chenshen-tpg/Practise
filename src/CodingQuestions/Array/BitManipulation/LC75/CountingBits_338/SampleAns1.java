package CodingQuestions.Array.BitManipulation.LC75.CountingBits_338;

public class SampleAns1 {
    public int[] countBits(int n) {
        int [] dp = new int [n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = (i % 2 == 0) ? dp [i / 2] : dp [i - 1] + 1;
        }
        return dp;
    }
}
