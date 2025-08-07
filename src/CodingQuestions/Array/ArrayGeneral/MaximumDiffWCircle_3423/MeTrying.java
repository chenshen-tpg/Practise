package CodingQuestions.Array.ArrayGeneral.MaximumDiffWCircle_3423;

public class MeTrying {
    public static void main(String[] args) {

    }
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int ini = Math.abs(nums[0] - nums[n-1]);
        if (n == 2) return ini;
        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i] - nums[i-1]) > ini) {
                ini = Math.abs(nums[i] - nums[i-1]);
            }
        }
        return ini;
    }
}
