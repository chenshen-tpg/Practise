package CodingQuestions.Algorithms.Array.SlidingWindow.LongestSubStringWithoutRepeatAns_3;

import java.util.HashMap;

public class HashMapVersion {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                j = Math.max(j, map.get(ch) + 1);
            }
            len = Math.max(len, i - j + 1);
            map.put(ch, i);
        }
        return len;
    }
}
