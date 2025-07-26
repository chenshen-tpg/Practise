package CodingQuestions.Array.TwoPointers.LC75.MaxNumberOfKSumPairs_1679;

import java.util.Arrays;
import java.util.HashMap;

public class MeTrying {
    public static void main(String[] args) {
        MeTrying solution = new MeTrying();
        System.out.println(solution.maxOperations(new int[]{4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4}, 2));
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                res++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

}
