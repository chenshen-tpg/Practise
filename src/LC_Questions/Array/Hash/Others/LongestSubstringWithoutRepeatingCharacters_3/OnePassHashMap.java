package LC_Questions.Array.Hash.Others.LongestSubstringWithoutRepeatingCharacters_3;

import java.util.HashMap;

public class OnePassHashMap {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int ans = 0;
        int start = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hm.containsKey(c)) {
                // max keep forwards..
                start = Math.max(start, hm.get(c) + 1);
            }
            hm.put(c, i);
            ans = Math.max(ans, i - start + 1);
        }
        System.out.println(ans);
    }

    public int lengthOfLongestSubstring_SlidingWindow(String s) {
        HashMap<Character, Integer> hm = new HashMap();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            hm.put(r, hm.getOrDefault(r, 0) + 1);
            while (hm.get(r) > 1) {
                char l = s.charAt(left);
                hm.put(l, hm.get(l) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }





}
