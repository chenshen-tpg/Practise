package CodingQuestions.Array.SlidingWindow.LC75.MaximumAverageSubarrayI_643;

public class BruteForce {
    public static void main(String[] args) {

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

}
