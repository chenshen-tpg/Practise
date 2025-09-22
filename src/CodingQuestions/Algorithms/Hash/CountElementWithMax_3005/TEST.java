package CodingQuestions.Algorithms.Hash.CountElementWithMax_3005;

import java.util.HashMap;
import java.util.Map;

public class TEST {
    public static void main(String[] args) {

    }

    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int i : hm.values()) {
            max = Math.max(max, i);
        }
        int res = 0;
        for (int i : hm.values()) {
            if (i == max) {
                res += i;
            }
        }
        return res;
    }
}
