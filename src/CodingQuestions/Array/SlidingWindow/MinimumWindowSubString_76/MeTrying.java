package CodingQuestions.Array.SlidingWindow.MinimumWindowSubString_76;

import java.util.HashMap;

public class MeTrying {
    public static void main(String[] args) {
        MeTrying solution = new MeTrying();
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Example 1: " + solution.myVersion_Wrong(s1, t1));
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
}
