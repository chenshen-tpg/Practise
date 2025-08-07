package CodingQuestions.Array.TwoPointers.CountTheNumberOfGoodSub_2537;

import java.util.HashMap;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.helper(new int [] {1,1,1,1,1}, 10);
    }

    public long helper(int[] nums, int k) {
        int same = 0, j = - 1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        long ans = 0;
        for (int i = 0; i <  nums.length;i++) {
            while (same < k && j < nums.length - 1) {
                j++;
                same += hm.getOrDefault(nums[j], 0);
                hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
            }
            if (same >= k) ans +=  nums.length - j;
            hm.put(nums[i], hm.get(nums[i]) - 1);
            same -= hm.get(nums[i]);
        }
        return ans;
    }
}
