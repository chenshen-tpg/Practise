package CodingQuestions.Array.SlidingWindow.LC150.MnimumSizeSubarraySum_209;

public class Review {
    public static void main(String[] args) {
        Review solution = new Review();
        int [] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(solution.minSubArrayLen(target,nums));
    }

    private int minSubArrayLen(int target, int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE, left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //should reduce them all at once.
            while (sum >= target) {
                min = Math.min(min, i - left + 1);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
