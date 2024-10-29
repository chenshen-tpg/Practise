package LC_Questions.LC_General.TwoPointers;

public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = {1,5,8,4,7,6,5,3,1};
        np.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        //1 5 8 5 1 3 4 6 7
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
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

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
