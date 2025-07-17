package CodingQuestions.DP.LC100.MaximumProductSubarray_152;

public class DP2 {
    public static void main(String[] args) {

    }

    public static int method (int [] nums) {
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(temp * min, nums[i] * min), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
