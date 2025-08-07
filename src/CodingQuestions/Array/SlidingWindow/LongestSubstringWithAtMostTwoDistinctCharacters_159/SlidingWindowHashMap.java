package CodingQuestions.Array.SlidingWindow.LongestSubstringWithAtMostTwoDistinctCharacters_159;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowHashMap {
    public static void main(String[] args) {
        System.out.println(helper("eceba"));
    }
    public static int helper (String s) {
        if (s.length() < 3) return s.length();
        int left = 0, count = 2;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), i);
            if (hm.size() > 2) {
               //int idx = Collections.min(hm.values());
                int idx = Integer.MAX_VALUE;
                for(Map.Entry<Character, Integer> entry: hm.entrySet()) {
                    if (entry.getValue() < idx) {
                        idx = entry.getValue();
                    }
                }
               hm.remove(s.charAt(idx));
               left = idx + 1;
            }
            count = Math.max(count, i - left + 1);
        }
        return count;
    }
}
