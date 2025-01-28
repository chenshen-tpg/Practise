package LC_Questions.CollectionAll.SlidingWindow.LC150.MinimumWindowSubString_76;

import java.util.HashMap;
import java.util.Map;

public class DoubleHashMap {
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Example 1: " + minWindow(s1, t1)); // Output: "BANC"
    }


    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char tt:t.toCharArray()) hm.put(tt,hm.getOrDefault(tt, 0) + 1);
        int l = 0, r = 0;
        int [] ans = {-1, 0, 0};
        int count = 0;
        Map<Character, Integer> winCount = new HashMap<>();
        while ( r < s.length()) {
            winCount.put(s.charAt(r), winCount.getOrDefault(s.charAt(r),0) + 1);
            if (hm.containsKey(s.charAt(r)) && winCount.get(s.charAt(r)) == hm.get(s.charAt(r))) count++;
            while (l <= r && count == hm.size()) {
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


}
