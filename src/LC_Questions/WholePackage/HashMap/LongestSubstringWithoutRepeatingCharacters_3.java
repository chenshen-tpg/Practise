package LC_Questions.WholePackage.HashMap;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
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
