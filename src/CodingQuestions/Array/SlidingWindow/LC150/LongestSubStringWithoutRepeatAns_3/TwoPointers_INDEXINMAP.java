package CodingQuestions.Array.SlidingWindow.LC150.LongestSubStringWithoutRepeatAns_3;

import java.util.HashMap;


public class TwoPointers_INDEXINMAP {
    public static void main(String[] args) {
        TwoPointers_INDEXINMAP solution = new TwoPointers_INDEXINMAP();
        String s = "bbbbb";
        System.out.println(solution.method(s));
    }
    public static int method (String s) {
        if (s.length()== 1) return 1;
        HashMap<Character,Integer> hm = new HashMap<>();
        int max = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                max = Math.max(max, hm.get(s.charAt(i)) + 1);
            }
            hm.put(s.charAt(i),i);
            ans = Math.max(ans, i - max + 1);
        }
        return ans;
    }
}
