package LC_Questions.LC_150.SlidingWindow;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Example 1: " + minWindow(s1, t1)); // Output: "BANC"
    }


    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char tt:t.toCharArray()) {
            hm.put(tt,hm.getOrDefault(tt, 0) + 1);
        }
        int l = 0, r = 0;
        int required = hm.size();
        int []ans = {-1, 0, 0};
        int count = 0;
        Map<Character, Integer> winCount = new HashMap<>();
        while ( r < s.length()) {
            winCount.put(s.charAt(r), winCount.getOrDefault(s.charAt(r),0) + 1);
            if (hm.containsKey(s.charAt(r)) && winCount.get(s.charAt(r)) == hm.get(s.charAt(r))) count++;
            while (l <= r && count == required) {
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                winCount.put(s.charAt(l), winCount.get(s.charAt(l))-1);
                if (hm.containsKey(s.charAt(l)) && winCount.get(s.charAt(l)) < hm.get(s.charAt(l))) count--;
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "": s.substring(ans[1], ans[2] + 1);
    }
    public static String myVersion_Wrong(String s, String t){
        String ans = "";
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char tt:t.toCharArray()){
            hm.put(tt,hm.getOrDefault(tt,0) + 1);
        }
        int len = Integer.MAX_VALUE;
        int all = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                if (hm.containsKey(s.charAt(j))){
                    all++;
                }
                if (all == hm.size()) {
                    break;
                }
            }
            if (sb.length() < len) {
                len = sb.length();
                ans = sb.toString();
            }
        }
        return ans;
    }
    public String minWindow_highestUpvoted(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        char[] chS = s.toCharArray();
        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minLen);
    }
}
