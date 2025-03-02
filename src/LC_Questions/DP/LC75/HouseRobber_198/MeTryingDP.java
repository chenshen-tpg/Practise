package LC_Questions.DP.LC75.HouseRobber_198;

public class MeTryingDP {
    public static void main(String[] args) {
        MeTryingDP solution = new MeTryingDP();
        int [] nums = {2, 7, 9, 3, 1};
        solution.rob(nums);
    }

    private int rob(int[] nums) {
        int [] memo = new int [nums.length];
        memo[0] = nums[0];
        memo[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            memo[i] = Math.max(memo[i-1], memo[i-2] + nums[i]);
        }
        return memo[nums.length - 1];
    }
}
