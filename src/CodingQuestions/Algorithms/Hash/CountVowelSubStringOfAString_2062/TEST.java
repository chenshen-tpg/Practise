package CodingQuestions.Algorithms.Hash.CountVowelSubStringOfAString_2062;

import java.util.HashMap;

public class TEST {
    public static void main(String[] args) {

    }
    public int countVowelSubstrings(String word) {
        HashMap<Character, Boolean> hm = new HashMap<>();
        hm.put('a', false);
        hm.put('e', false);
        hm.put('i', false);
        hm.put('o', false);
        hm.put('u', false);
        int left = 0, right = word.length(), res = 0;
        while(left < right) {
            int countFlag = 0;
            hm.put(word.charAt(left), hm.getOrDefault(word.charAt(left), true));
            for (boolean h : hm.values()) {
                if (h) countFlag++;
            }
            if (countFlag == hm.size() - 1) res++;

            if (hm.containsKey(left)) left++;
            else if (hm.containsKey(right)) right--;
        }

        return res;
    }
}
