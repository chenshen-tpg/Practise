package LC_Questions.CollectionAll.Array.LC150.RtateArray_189;

import java.util.Arrays;

public class Linear {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int val = 3;
        Linear solution = new Linear();
        solution.rotate(nums, val);
    }

    public void rotate(int[] nums, int k) {
        int rotate = k % nums.length;
        int start = 0;
        int [] copy = new int[nums.length];
        for (int i = nums.length - rotate; i < nums.length; i++) {
            copy[start++] = nums[i];
        }
        for (int i = 0; i < nums.length - rotate; i++) {
            copy[start++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = copy[i];
        }
    }
}
