package CodingQuestions.Array.ArrayGeneral.Others.MaximumUniqueSub_3487;

import java.util.Arrays;

public class SortSolution {
    public static void main(String[] args) {
        SortSolution solution = new SortSolution();
        // Test case 1: All positive, no duplicates
        System.out.println(new SortSolution().maxSum(new int[]{1, 2, 3, 4})); // Expected: 10

        // Test case 2: With duplicates
        System.out.println(new SortSolution().maxSum(new int[]{1, 2, 2, 3, 4})); // Expected: 10

        // Test case 3: Contains zero
        System.out.println(new SortSolution().maxSum(new int[]{0, 1, 2, 3})); // Expected: 6

        // Test case 4: Contains negative numbers
        System.out.println(new SortSolution().maxSum(new int[]{-1, 2, 3, 4})); // Expected: 9

        // Test case 5: All negative
        System.out.println(new SortSolution().maxSum(new int[]{-1, -2, -3})); // Expected: -1

        // Test case 6: Single element
        System.out.println(new SortSolution().maxSum(new int[]{5})); // Expected: 5

        // Test case 7: All elements are the same
        System.out.println(new SortSolution().maxSum(new int[]{2, 2, 2, 2})); // Expected: 2
    }
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[nums.length - 1];
        int sum = prev;
        for (int i = nums.length - 2; i >= 0; i--) {
            int n = nums[i];
            if (n <= 0) {
                return sum;
            } else if (n != prev) {
                sum = sum + n;
            }
            prev = n;
        }
        return sum;
    }
}
