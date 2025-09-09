package Learning.General.LeeCodeStyleQ.SlidingWindow.LongestRepeatingCharacterReplacement_424;

import java.util.HashMap;

public class TEST {
    public static void main(String[] args) {
        characterReplacement("AABABBA", 1);
    }

    public static int characterReplacement(String s, Integer k) {
        int j = 0;
        int max = 0;
        int freq = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            hm.put(temp, hm.getOrDefault(temp, 0) + 1);
            freq = Math.max(freq, hm.get(temp));
            while (i - j + 1 - freq > k) {
                char start = s.charAt(j);
                hm.put(start, hm.get(start) - 1);
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
