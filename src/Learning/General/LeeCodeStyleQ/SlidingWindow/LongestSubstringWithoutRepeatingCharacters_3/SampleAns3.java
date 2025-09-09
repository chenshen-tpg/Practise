package Learning.General.LeeCodeStyleQ.SlidingWindow.LongestSubstringWithoutRepeatingCharacters_3;

public class SampleAns3 {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] memo = new int[128];
        int index = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            index = Math.max(index, memo[c]);
            res = Math.max(res, i - index + 1);
            memo[c] = i + 1;
        }
        return res;
    }
}
