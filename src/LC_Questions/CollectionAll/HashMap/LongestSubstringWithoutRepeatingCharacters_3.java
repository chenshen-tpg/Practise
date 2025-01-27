package LC_Questions.CollectionAll.HashMap;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(s));



    // a0 b1 c2, c3

        int ans = 0;
        int start = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hm.containsKey(c)) {
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

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int ans = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))){
                start = Math.max(start, hm.get(s.charAt(i)) + 1);
            }
            hm.put(s.charAt(i), i);
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }



}
