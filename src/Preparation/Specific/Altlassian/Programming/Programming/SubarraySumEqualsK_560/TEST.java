package Preparation.Specific.Altlassian.Programming.Programming.SubarraySumEqualsK_560;

import java.util.HashMap;

public class TEST {
    public static void main(String[] args) {

    }
    public int subarraySum(int[] nums, int k) {
        int cur = 0, res = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (cur == k) res++;
            res += hm.getOrDefault(cur - k, 0);
            hm.put(cur, hm.getOrDefault(cur, 0) + 1);
        }
        return res;
    }
}
