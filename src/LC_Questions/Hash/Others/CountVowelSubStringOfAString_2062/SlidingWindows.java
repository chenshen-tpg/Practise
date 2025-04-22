package LC_Questions.Hash.Others.CountVowelSubStringOfAString_2062;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindows {
    public int countVowelSubstrings(String word) {
        int count = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();
        lastSeen.put('a', -1);
        lastSeen.put('e', -1);
        lastSeen.put('i', -1);
        lastSeen.put('o', -1);
        lastSeen.put('u', -1);

        for (int i = 0, lastInvalidPos = -1; i < word.length(); ++i) {
            if (lastSeen.containsKey(word.charAt(i))) {
                lastSeen.put(word.charAt(i), i);
                count += Math.max(Collections.min(lastSeen.values()) - lastInvalidPos, 0);
            } else {
                lastInvalidPos = i;
            }
        }
        return count;
    }
}
