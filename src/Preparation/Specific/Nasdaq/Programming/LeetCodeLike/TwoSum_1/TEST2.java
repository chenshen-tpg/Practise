package Preparation.Specific.Nasdaq.Programming.LeetCodeLike.TwoSum_1;

import java.util.HashMap;

public class TEST2 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int cur = target - nums[i];
            if (hm.containsKey(cur)){
                return new int [] {i, hm.get(cur)};
            }
            hm.put(nums[i],i);
        }
        return new int [] {-1, -1};
    }
}
