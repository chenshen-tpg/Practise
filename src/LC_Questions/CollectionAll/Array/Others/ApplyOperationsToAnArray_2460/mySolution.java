package LC_Questions.CollectionAll.Array.Others.ApplyOperationsToAnArray_2460;

public class mySolution {
    public static void main(String[] args) {
        applyOperations(new int [] {1,2,2,1,1,0});
    }
    public static int[] applyOperations(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                int temp = nums[i-1];
                nums[i-1] *= 2;
                nums[i] = 0;
            }
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = 0;
        }
        return nums;
    }
}
