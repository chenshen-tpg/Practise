package LC_Questions.DP.LC100.MaximumProductSubarray_152;

public class DP {
    public static void main(String[] args) {

    }
    public static int helper (int [] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int result = max;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp = Math.max(curr, Math.max(max * curr, min * curr));
            min = Math.min(curr, Math.min(max * curr, min * curr));
            max = temp;
            result = Math.max(max, result);
        }
        return result;
    }
}
