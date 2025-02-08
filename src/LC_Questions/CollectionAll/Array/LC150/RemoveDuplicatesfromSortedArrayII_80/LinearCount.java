package LC_Questions.CollectionAll.Array.LC150.RemoveDuplicatesfromSortedArrayII_80;


public class LinearCount {
    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3};
        LinearCount solution = new LinearCount();
        solution.removeDuplicates(nums);

    }

    private int removeDuplicates(int[] nums) {
        int index = 1;
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                temp++;
            } else {
                temp = 0;
            }
            if (temp < 2) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }


}
