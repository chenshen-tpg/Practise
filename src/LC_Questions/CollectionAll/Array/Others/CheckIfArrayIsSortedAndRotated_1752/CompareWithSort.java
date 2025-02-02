package LC_Questions.CollectionAll.Array.Others.CheckIfArrayIsSortedAndRotated_1752;

import java.util.Arrays;

public class CompareWithSort {
    public static void main(String[] args) {
        int [] nums = {6,4,7,1,3};
        CompareWithSort me = new CompareWithSort();
        System.out.println(me.helper(nums));
    }
    public boolean helper (int [] nums) {
        int changIndex = 0;
        int [] temp = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                changIndex = i;
            }
        }
        int start = 0;
        for (int i = changIndex; i < nums.length; i++) {
            if (nums[i] != temp[start++]) return false;
        }
        return true;
    }
}
