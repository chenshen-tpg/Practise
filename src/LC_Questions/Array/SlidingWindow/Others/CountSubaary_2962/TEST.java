package LC_Questions.Array.SlidingWindow.Others.CountSubaary_2962;

import java.util.HashMap;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.countSubarrays(new int [] {1,3,2,3,3}, 2);
    }
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int max = 0, size = 0;
        for (int i = 0; i < nums.length;i++)  max = Math.max(max, nums[i]);
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == max) size++;
            while (size == k) {
                if (nums[j] == max) size--;
                j++;
            }
            ans += (int) j;
        }
        return ans;
    }
}
