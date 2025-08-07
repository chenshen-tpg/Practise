package CodingQuestions.Array.ArrayGeneral.RemoveDuplicatesFromSortedArray_26;

public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        MeTrying solution = new MeTrying();
        solution.removeDuplicates(nums);
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
