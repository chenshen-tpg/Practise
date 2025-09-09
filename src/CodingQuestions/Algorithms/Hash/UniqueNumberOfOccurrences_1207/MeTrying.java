package CodingQuestions.Algorithms.Hash.UniqueNumberOfOccurrences_1207;

import java.util.HashMap;
import java.util.HashSet;

public class MeTrying {
    public static void main(String[] args) {

    }
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        HashSet<Integer> hs = new HashSet();
        int count = 0;
        for (int i : hm.keySet()) {
            count++;
            hs.add(hm.get(i));
        }
        return count == hs.size();
    }
}
