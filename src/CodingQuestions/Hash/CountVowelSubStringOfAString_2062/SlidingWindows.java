package CodingQuestions.Hash.CountVowelSubStringOfAString_2062;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindows {
    public static void main(String[] args) {
        SlidingWindows solution = new SlidingWindows();
        solution.countVowelSubstrings("cuaieuouac");
    }
    public int countVowelSubstrings(String word) {
        int count = 0;
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('a', -1);
        hm.put('e', -1);
        hm.put('i', -1);
        hm.put('o', -1);
        hm.put('u', -1);

        for (int i = 0, lastInvalidPos = -1; i < word.length(); ++i) {
            if (hm.containsKey(word.charAt(i))) {
                hm.put(word.charAt(i), i);
                //Otherwise the collections.min will just return - 1 if no encounter all
                count += Math.max(Collections.min(hm.values()) - lastInvalidPos, 0);
            } else {
                // if new invalid break
                lastInvalidPos = i;
            }
        }
        return count;
    }
}
