package LC_Questions.CollectionAll.KadanesAlgorithm.LC150.MaximumSumCircularSubarray_918;

public class MaximumSumCircularSubarray_918 {
    public static void main(String[] args) {
        int [] nums = {5,-3,5};
        System.out.println(maxSubarraySumCircular1(nums));
    }
        public static int maxSubarraySumCircular(int[] nums) {
            final int n = nums.length;
            final int[] rightMax = new int[n];
            rightMax[n - 1] = nums[n - 1];
            int suffixSum = nums[n - 1];

            for (int i = n - 2; i >= 0; --i) {
                suffixSum += nums[i];
                rightMax[i] = Math.max(rightMax[i + 1], suffixSum);
            }
            int maxSum = nums[0];
            int specialSum = nums[0];
            int curMax = 0;
            for (int i = 0, prefixSum = 0; i < n; ++i) {
                curMax = Math.max(curMax, 0) + nums[i];
                maxSum = Math.max(maxSum, curMax);
                prefixSum += nums[i];
                if (i + 1 < n) {
                    specialSum = Math.max(specialSum, prefixSum + rightMax[i + 1]);
                }
            }
            return Math.max(maxSum, specialSum);
        }
    public static int maxSubarraySumCircular1(int[] nums) {
        int all = 0;
        int maxcur = 0;
        int max = nums[0];
        int mincur = 0;
        int min = nums[0];
        for (int i = 0;i < nums.length;i++) {
            maxcur = Math.max(0, maxcur + nums[i]) ;
            max = Math.max(maxcur, max);
            mincur = Math.min(0, mincur + nums[i]);
            min = Math.min(mincur, min);
            all += nums[i];
        }
        if (all == min) {
            return max;
        }
        return Math.max(max, all - min);
    }
}
