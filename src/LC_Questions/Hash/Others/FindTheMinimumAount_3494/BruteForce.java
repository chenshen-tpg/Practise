package LC_Questions.Hash.Others.FindTheMinimumAount_3494;

public class BruteForce {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i !=j && nums[i] + nums[j] == target) {
                    return new int [] {i, j};
                }
            }
        }
        return new int [] {-1, -1};
    }
}
