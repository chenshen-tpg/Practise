package Learning.General.LeeCodeStyleQ.SlidingWindow.LongestSubstringWithoutRepeatingCharacters_3;

import java.util.HashSet;

public class SampleAns1 {
    public static void main(String[] args) {

    }
    public Integer longestSubstringWithoutRepeat(String s) {
        HashSet<Character> hm = new HashSet();
        int ans = 0;
        int j =0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            while (hm.contains(cur)) {
                hm.remove(s.charAt(j++));
            }
            ans = Math.max(ans, i - j + 1);
            hm.add(cur);
        }
        return ans;
    }


}
