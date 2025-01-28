package LC_Questions.CollectionAll.SlidingWindow.LC75.MaximumAverageSubarrayI_643;

public class MimicPrefix {
    public static void main(String[] args) {

    }
    public double findMaxAverageBySumEveryStep(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];
        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;
    }
}
