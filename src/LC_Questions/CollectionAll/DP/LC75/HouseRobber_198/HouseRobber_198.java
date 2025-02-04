package LC_Questions.CollectionAll.DP.LC75.HouseRobber_198;

public class HouseRobber_198 {
    public static void main(String[] args) {
        HouseRobber_198 solution = new HouseRobber_198();
        int [] nums = {2, 7, 9, 3, 1};
        solution.rob(nums);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }

}
