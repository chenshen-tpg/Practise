package CodingQuestions.Algorithms.Array.SlidingWindow.MnimumSizeSubarraySum_209;

public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = nums.length;
        int sum = 0, ans = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
        }
        return ans > nums.length ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        MinimumSizeSubarraySum_209 m = new MinimumSizeSubarraySum_209();
        System.out.println(m.minSubArrayLen(target, nums));
    }
}
