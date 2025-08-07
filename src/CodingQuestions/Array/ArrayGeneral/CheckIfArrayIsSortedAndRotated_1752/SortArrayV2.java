package CodingQuestions.Array.ArrayGeneral.CheckIfArrayIsSortedAndRotated_1752;

import java.util.Arrays;

public class SortArrayV2 {
    public static void main(String[] args) {
        int [] nums = {3,4,5,1,2};
        SortArrayV2 solution = new SortArrayV2();
        solution.check(nums);
    }
    public boolean check(int[] nums) {
        int[] newNums = nums.clone();
        Arrays.sort(newNums);
        for (int i = 0; i < nums.length; i++) {
            boolean isMatch = true;
            for (int j = 0; j < nums.length; j++) {
                if (nums[(i + j) % nums.length] != newNums[j]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                return true;
            }
        }
        return false;
    }
}
