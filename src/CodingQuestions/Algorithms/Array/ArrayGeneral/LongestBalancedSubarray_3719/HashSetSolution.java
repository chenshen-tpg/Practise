package CodingQuestions.Algorithms.Array.ArrayGeneral.LongestBalancedSubarray_3719;

import java.util.HashSet;

public class HashSetSolution {
    public static void main(String[] args) {

    }
    public int helper(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            HashSet<Integer> evens = new HashSet<>();
            HashSet<Integer> odds = new HashSet<>();
            for (int j = i; j < arr.length; j++) {
                if (arr[j] % 2 == 0) {
                    evens.add(arr[j]);
                } else {
                    odds.add(arr[j]);
                }
                if (evens.size() == odds.size()) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}
