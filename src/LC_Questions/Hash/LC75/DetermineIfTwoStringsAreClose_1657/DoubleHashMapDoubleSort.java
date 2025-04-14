package LC_Questions.Hash.LC75.DetermineIfTwoStringsAreClose_1657;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DoubleHashMapDoubleSort {
    public static void main(String[] args) {

    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            hm2.put(c, hm2.getOrDefault(c, 0) + 1);
        }
        if (!hm.keySet().equals(hm2.keySet())) {
            return false;
        }
        List<Integer> word1FrequencyList = new ArrayList<>(hm.values());
        List<Integer> word2FrequencyList = new ArrayList<>(hm2.values());
        Collections.sort(word1FrequencyList);
        Collections.sort(word2FrequencyList);
        return word1FrequencyList.equals(word2FrequencyList);
    }

}
