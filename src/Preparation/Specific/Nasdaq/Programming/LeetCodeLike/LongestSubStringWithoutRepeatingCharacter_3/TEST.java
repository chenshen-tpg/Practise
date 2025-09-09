package Preparation.Specific.Nasdaq.Programming.LeetCodeLike.LongestSubStringWithoutRepeatingCharacter_3;

import java.util.HashMap;

public class TEST {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        char [] c = s.toCharArray();
        HashMap<Character, Integer> hm = new HashMap();
        int max = 0;
        int j = 0;
        for (int i = 0; i < c.length; i++) {
            char cur = c[i];
            while (hm.containsKey(cur)) {
                hm.remove(c[j++]);
            }
            hm.put(cur, i);
            if (i - j > max) {
                max = i - j;
            }
        }
        return max + 1;
    }
}
