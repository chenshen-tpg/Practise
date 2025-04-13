package LC_Questions.Array.ArrayGeneral.PremiumAlgo100.WiggleSort_280;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        int [] data = new int [] {3,5,2,1,6,4};
        solution.wiggleSort(data);
        System.out.println(data);
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }
}
