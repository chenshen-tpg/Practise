package CodingQuestions.Algorithms.Array.ArrayGeneral.Candy_135;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        helper(new int [] {1,0,2});
    }

    private static void helper(int[] arr) {
        int n = arr.length;
        int [] memo = new int [n];
        Arrays.fill(memo, 1);
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                memo[i] = memo[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                memo[i] = Math.max(memo[i], memo[i+1] + 1);
            }
        }
        int res = 0;
        for (int m : memo) {
            res += m;
        }
//        return res;
    }
}
