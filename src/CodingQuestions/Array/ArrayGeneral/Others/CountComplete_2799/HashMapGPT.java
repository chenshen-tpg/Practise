package CodingQuestions.Array.ArrayGeneral.Others.CountComplete_2799;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapGPT {
    public static void main(String[] args) {

    }
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) set.add(num);
        int k = set.size(), res = 0, j = 0, window = 0;

        for (int i = 0; i <  nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault( nums[i], 0) + 1);
            if (hm.get(nums[i]) == 1) window++;
            while (window == k) {
                res += nums.length - i;
                hm.put(nums[j], hm.get(nums[j]) - 1);
                if (hm.get(nums[j]) == 0) window--;
                j++;
            }
        }
        return res;
    }
}
