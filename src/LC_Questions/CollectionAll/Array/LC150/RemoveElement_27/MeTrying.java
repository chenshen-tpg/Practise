package LC_Questions.CollectionAll.Array.LC150.RemoveElement_27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeTrying {
    public static void main(String[] args) {
        int [] nums = {3,2,2,3};
        int val = 3;
        MeTrying solution = new MeTrying();
        solution.removeElement(nums, val);
    }
    public int removeElement(int[] nums, int val) {

        int count = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
           if (nums[i] != val) nums[index++] = nums[i];
           if (nums[i] == val) count++;
        }
        return nums.length - count;
    }
}
