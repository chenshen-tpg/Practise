package CodingQuestions.Array.ArrayGeneral.Others.MaximumDiffWCircle_3423;

public class ModelAns {
    public static void main(String[] args) {

    }
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int ini = Math.abs(nums[0] - nums[n-1]);
        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i] - nums[i-1]) > ini) {
                ini = Math.abs(nums[i] - nums[i-1]);
            }
        }
        return ini;
    }
}
