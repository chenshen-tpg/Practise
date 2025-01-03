package LC_Questions.WholePackage.SlidingWindow;

public class MnimumSizeSubarraySum_209 {
    public static void main(String[] args) {
        minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int length = i;
            int sum = 0;
            while (length < nums.length) {
                if (sum >= target) {
                    ans = Math.min(ans, length);
                    break;
                }
                sum += nums[i];
                length++;
            }
        }
        return ans;
    }
}
