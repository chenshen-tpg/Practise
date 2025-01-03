package LC_Questions.WholePackage.SlidingWindow;

public class MaximumAverageSubarrayI_643 {
    public static void main(String[] args) {
        MaximumAverageSubarrayI_643 mas = new MaximumAverageSubarrayI_643();
        System.out.println(mas.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i = 0; i < k; i++)
            sum += nums[i];
        double res = sum;
        for(int i=k; i<nums.length; i++){
            sum += nums[i] - nums[i-k];
            res = Math.max(res, sum);
        }
        return res/k;
    }
    public double findMaxAverageBySumEveryStep(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            //sum instead of nums
            sum[i] = sum[i - 1] + nums[i];
        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;
    }
}
