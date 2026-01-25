package CodingQuestions.Algorithms.Array.SlidingWindow.LongestSubStringWithoutRepeatAns_3;

import java.util.Arrays;
import java.util.HashMap;

public class HashMapVersion {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        Arrays.fill(last, -1);
        int left = 0, max = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            int prev = last[c];

            if (prev >= left) {
                left = prev + 1;
            }

            last[c] = right;
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
