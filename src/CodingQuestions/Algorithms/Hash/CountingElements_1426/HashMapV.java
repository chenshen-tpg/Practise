package CodingQuestions.Algorithms.Hash.CountingElements_1426;

import java.util.HashMap;
import java.util.Map;

public class HashMapV {
    public static void main(String[] args) {

    }
    public int countElements(int[] arr) {
        Map<Integer, Boolean> hm = new HashMap<>();
        int count = 0;
        for (int num : arr) {
            hm.put(num, true);
        }
        for (int num : arr) {
            if (hm.containsKey(num + 1)) {
                count++;
            }
        }
        return count;
    }
}
