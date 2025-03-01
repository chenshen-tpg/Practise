package LC_Questions.CollectionAll.Array.Others.ApplyOperationsToAnArray_2460;

public class onePass {
    public static void main(String[] args) {

    }
    public int[] applyOperations(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && nums[i- 1] != 0) {
                nums[i - 1] *= 2;
                nums[i] = 0;
            }
            if (nums[i] != 0) {
                if (i - 1 != j) {
                    int temp = nums[i];
                    nums[i - 1] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }
        return nums;
    }
}
