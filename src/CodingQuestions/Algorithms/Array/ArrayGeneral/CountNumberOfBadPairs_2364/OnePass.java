package CodingQuestions.Algorithms.Array.ArrayGeneral.CountNumberOfBadPairs_2364;

import java.util.HashMap;
import java.util.Map;

public class OnePass {
    public static void main(String[] args) {
        int [] nums = {4,1,3,3};
        OnePass solution = new OnePass();
        solution.count(nums);
    }
    public long count (int [] nums) {
        long res = 0;
        Map<Integer, Integer> diffCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = i - nums[i];
            int hm = diffCount.getOrDefault(diff, 0);
            res += i - hm;
            diffCount.put(diff, hm + 1);
        }
        return res;
    }
}
