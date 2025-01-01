package LC_Questions.LC_150.SlidingWindow;

import java.lang.reflect.Array;
import java.util.HashMap;

public class MinimumWindowSubstring_76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

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
        System.out.println(ans);
    }


}
