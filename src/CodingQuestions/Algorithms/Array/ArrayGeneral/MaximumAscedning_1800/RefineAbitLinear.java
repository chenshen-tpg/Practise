package CodingQuestions.Algorithms.Array.ArrayGeneral.MaximumAscedning_1800;

public class RefineAbitLinear {
    public static void main(String[] args) {

    }
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                temp += nums[i];
                max = Math.max(max, temp);
            } else {
                temp = nums[i];
            }
        }
        return Math.max(max, temp);
    }
}
