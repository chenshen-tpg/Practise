package SystemDesignQuestions.LeeCodeStyleQ.MaximumSumSubArrayWithSize;

public class TEST {
    public static void main(String[] args) {
        helper(new int [] {2,1,5,1,3,2}, 3);
    }

    public static int helper (int [] nums, int k) {

        int ans = 0;
        int j = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i - j + 1 == k) {
                ans = Math.max(sum, ans);
                sum -= nums[j++];
            }
        }
        return ans;
    }
}
