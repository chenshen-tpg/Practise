package LC_Questions.DP.LC75.HouseRobber_198;

public class DP {
    public static void main(String[] args) {
        DP solution = new DP();
        int [] nums = {2, 7, 9, 3, 1};
        solution.rob(nums);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int [] memo = new int [nums.length];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            memo[i] = Math.max(memo[i - 1], nums[i] + memo[i-2]);
        }
        return memo[nums.length - 1];
    }

}
