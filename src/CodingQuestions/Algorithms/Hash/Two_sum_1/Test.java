package CodingQuestions.Algorithms.Hash.Two_sum_1;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        twoSum(new int [] {3,2,4}, 6);
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
//            if (hm.getOrDefault(target - nums[i], 0) != i && hm.containsKey(target - nums[i])) {
            if (hm.containsKey(target - nums[i]) && hm.get(target - nums[i]) != i) {
                return new int [] {i, hm.get(target - nums[i])};
            }
        }
        return null;
    }
}
