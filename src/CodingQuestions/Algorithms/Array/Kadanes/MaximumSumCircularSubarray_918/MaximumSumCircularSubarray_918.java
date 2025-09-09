package CodingQuestions.Algorithms.Array.Kadanes.MaximumSumCircularSubarray_918;

public class MaximumSumCircularSubarray_918 {
    public static void main(String[] args) {
        int [] nums = {5,-3,5};
        System.out.println(maxSubarraySumCircular1(nums));
    }

    public static int maxSubarraySumCircular1(int[] nums) {
        int all = 0;
        int maxcur = 0;
        int mincur = 0;
        int max = nums[0];
        int min = nums[0];
        for (int i = 0;i < nums.length; i++) {
            maxcur = Math.max(0, maxcur + nums[i]) ;
            max = Math.max(maxcur, max);
            mincur = Math.min(0, mincur + nums[i]);
            min = Math.min(mincur, min);
            all += nums[i];
        }
        if (all == min) return max;
        return Math.max(max, all - min);
    }
}
