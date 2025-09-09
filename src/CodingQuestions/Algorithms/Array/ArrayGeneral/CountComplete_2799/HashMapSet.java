package CodingQuestions.Algorithms.Array.ArrayGeneral.CountComplete_2799;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapSet {
    public static void main(String[] args) {
        HashMapSet solution = new HashMapSet();
        solution.countCompleteSubarrays(new int [] {1,3,1,2,2});
    }
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> stack = new HashSet<>();
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) stack.add(num);
        int k = stack.size(), res = 0, i = 0;

        for (int j = 0; j <  nums.length; j++) {
            if (hm.getOrDefault(nums[j], 0) == 0) k--;
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
            while (k == 0) {
                hm.put(nums[i], hm.get(nums[i]) - 1);
                if (hm.get(nums[i]) == 0) k++;
                i++;
            }
            res += i;
        }
        return res;
    }
}
