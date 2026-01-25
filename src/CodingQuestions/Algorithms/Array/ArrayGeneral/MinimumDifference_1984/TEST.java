package CodingQuestions.Algorithms.Array.ArrayGeneral.MinimumDifference_1984;

import java.util.Arrays;

public class TEST {
    public int minimumDifference(int[] nums, int k) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < nums.length; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int [] test = new int [] {87063,61094,44530,21297,95857,93551,9918};
        TEST solution = new TEST();
        solution.minimumDifference(test, 6);
    }
}
