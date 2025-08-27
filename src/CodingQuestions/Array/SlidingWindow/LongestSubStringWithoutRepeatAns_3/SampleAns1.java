package CodingQuestions.Array.SlidingWindow.LongestSubStringWithoutRepeatAns_3;

import java.util.HashMap;


public class SampleAns1 {
    public static void main(String[] args) {
        SampleAns1 solution = new SampleAns1();
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
