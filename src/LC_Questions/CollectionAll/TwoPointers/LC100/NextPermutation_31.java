package LC_Questions.CollectionAll.TwoPointers.LC100;

public class NextPermutation_31 {
    public static void main(String[] args) {
        int [] test = {1,2,3};
        nextPermutation(test);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i]);
        }
    }
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    public static void reverse (int [] nums, int s) {
        int i = s, j = nums.length - 1;
        while (i < j) {
            swap (nums, i, j);
            i++;
            j--;
        }
    }
    public static void swap (int [] nums, int i, int j) {
        int tem = nums[i];
        nums[i] =nums[j];
        nums[j] = tem;
    }
}