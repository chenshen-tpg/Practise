package CodingQuestions.Algorithms.Array.ArrayGeneral.MnimizeMaximum_1877;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {

    }
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length -1;
        int max = 0;
        while (l < r) {
            max = Math.max(max,  nums[l] + nums[r]);
            l++;
            r--;
        }
        return max;
    }
}
