package CodingQuestions.Algorithms.Array.BitManipulation.SingleNumber_136;

import java.util.HashMap;

public class MeTrying {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i],hm.getOrDefault(nums[i], 0) + 1);
        }
        for (int i : hm.keySet()) {
            if (hm.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }
}
