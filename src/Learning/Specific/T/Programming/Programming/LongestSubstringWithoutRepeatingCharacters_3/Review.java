package Learning.Specific.T.Programming.Programming.LongestSubstringWithoutRepeatingCharacters_3;

import java.util.HashMap;

public class Review {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(findLongest(s));
    }
    public static int findLongest (String s) {
        int start = 0, max = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hm.containsKey(c)) {
                start = hm.get(c) + 1;
            }
            max = Math.max(max, i - start);
            hm.put(c, i);
        }
        return max;
    }
}
