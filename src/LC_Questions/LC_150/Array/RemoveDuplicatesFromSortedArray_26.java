package LC_Questions.LC_150.Array;

import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
