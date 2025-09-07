package Learning.General.LeeCodeStyleQ.SlidingWindow.LongestSubstringWithoutRepeatingCharacters_3;

import java.util.HashMap;
import java.util.Map;

public class SampleAns2 {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(findLongest(s));
    }
    public static int findLongest (String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            seen.put(ch, seen.getOrDefault(ch, 0) + 1);
            while (seen.get(ch) > 1) {
                char startChar = s.charAt(start);
                seen.put(startChar, seen.get(startChar) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
