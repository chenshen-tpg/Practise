package Preparation.General.LeetCodeStyle.ProductOfArrayExceptItSelf_238;

public class SampleAns {
    public static void main(String[] args) {
        SampleAns solution = new SampleAns();
        solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int postfix = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = result[i] * postfix;
            postfix = postfix * nums[i];
        }
        return result;
    }
}
