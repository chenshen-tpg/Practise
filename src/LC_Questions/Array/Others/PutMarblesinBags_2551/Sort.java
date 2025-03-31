package LC_Questions.Array.Others.PutMarblesinBags_2551;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        Sort solution = new Sort();
        solution.putMarbles(new int []{1,3,5,1},2);
    }
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pairWeights = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pairWeights, 0, n - 1);
        long answer = 0l;
        for (int i = 0; i < k - 1; ++i) {
            answer += pairWeights[n - 2 - i] - pairWeights[i];
        }
        return answer;
    }
}
