package Preparation.Specific.Nasdaq.Programming.LeetCodeLike.TwoSum_1;

public class TEST {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int [] {i,j};
                }
            }
        }
        return new int [] {-1, -1};
    }
}
