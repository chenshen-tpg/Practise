package Preparation.Specific.Altlassian.Programming.Programming.LongestConsecutiveSequence_128;

import java.util.Arrays;

public class SampleAns1 {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else if (nums[i] != nums[i - 1]) {
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
