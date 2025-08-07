package CodingQuestions.Array.ArrayGeneral.MaxDiff_2016;

public class BruteForce {
    public static void main(String[] args) {

    }
    public int maximumDifference(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length ; j++) {
                if (nums[j] - nums[i] > res) {
                    res = nums[j] - nums[i];
                }
            }
        }
        return res == 0 ? -1 : res;
    }
}
