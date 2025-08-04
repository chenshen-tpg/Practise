package SystemDesignQuestions.LeeCodeStyleQ.TwoSum_1;

import java.util.HashMap;

public class TwoSum_1 {
    public static void main(String[] args) {
        System.out.println(helper(new int [] {2,7,11,15},9));

    }
    public static int [] helper (int [] nums, int target){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i]) && hm.get(target - nums[i]) != i) {
                return new int[] {hm.get(target - nums[i]), i};
            }
            hm.put(nums[i],i);
        }
        return new int[] {};
    }
}
