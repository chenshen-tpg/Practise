package CodingQuestions.Array.BitManipulation.LC75.CountingBits_338;

public class SampleAns2 {
    public static void main(String[] args) {

    }
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int x = 1; x <= n; ++x) {
            // x / 2 is x >> 1 and x % 2 is x & 1
            ans[x] = ans[x >> 1] + (x & 1);
        }
        return ans;
    }
}
