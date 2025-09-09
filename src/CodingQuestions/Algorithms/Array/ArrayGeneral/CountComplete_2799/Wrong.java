package CodingQuestions.Algorithms.Array.ArrayGeneral.CountComplete_2799;

import java.util.HashMap;

public class Wrong {
    public static void main(String[] args) {
        Wrong solution = new Wrong();
        solution.countCompleteSubarrays(new int [] {5,5,5,5});
    }
    public int countCompleteSubarrays(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer i : hm.keySet()) {
            if (hm.get(i) == 1) count++;
            else if (hm.get(i) == 2) count += 2;
            else {
                int temp = hm.get(i);
                while (temp > 0) {
                   count += temp--;
                }
            }
        }
        return count;
    }
}
