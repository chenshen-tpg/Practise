package Learning.General.LeeCodeStyleQ.TwoPointers.SortColors_75;

public class TEST {
    public static void main(String[] args) {

    }
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                int temp1 = nums[i];
                nums[i] = nums[left];
                nums[left] = temp1;
                i++;
                left++;
            }
            else if (nums[i] == 2) {
                int temp2 = nums[i];
                nums[i] = nums[right];
                nums[right] = temp2;
                right--;
            } else {
                i++;
            }
        }
    }
}
