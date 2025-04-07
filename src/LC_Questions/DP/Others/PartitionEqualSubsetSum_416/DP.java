package LC_Questions.DP.Others.PartitionEqualSubsetSum_416;

public class DP {
    public static void main(String[] args) {
        int [] nums = {1, 5, 11, 5};
        DP solution = new DP();
        solution.canPartition(nums);
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][subSetSum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= subSetSum; j++) {
                if (j < nums[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - nums[i - 1]]);
            }
        }
        return dp[n][subSetSum];
    }
}
