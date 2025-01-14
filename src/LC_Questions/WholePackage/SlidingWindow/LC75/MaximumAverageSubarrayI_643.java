package LC_Questions.WholePackage.SlidingWindow.LC75;

public class MaximumAverageSubarrayI_643 {
    public static void main(String[] args) {
        MaximumAverageSubarrayI_643 mas = new MaximumAverageSubarrayI_643();
        System.out.println(mas.rewrite_OnePass(new int[]{4,0,4,3,3}, 5));
    }

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        double res = sum;
        for (int i = k; i < nums.length; i++){
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }
        return res / k;
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

    public double rewrite_bruteForce (int [] nums, int k) {
        double ans = 0;
        for (int i = 0; i < nums.length - k; i++) {
            double temp = 0;
            for (int j = i; j < i + k; j++) {
                temp += nums[j];
            }
            ans = Math.max(temp, ans);
        }
        return ans;
    }

    public double rewrite_OnePass (int [] nums, int k) {
        int [] numsList = new int [nums.length];
        numsList[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            numsList[i] = numsList[i-1] + nums[i];
//        }

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            numsList[i] = temp;
        }


        double ans = numsList[k - 1];
        for (int i = k; i < nums.length; i++) {
            ans = Math.max(ans, numsList[i] - numsList[i-k]);
        }
        return ans / k;
    }
}
