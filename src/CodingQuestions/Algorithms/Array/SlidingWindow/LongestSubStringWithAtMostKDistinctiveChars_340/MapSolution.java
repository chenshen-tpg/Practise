package CodingQuestions.Algorithms.Array.SlidingWindow.LongestSubStringWithAtMostKDistinctiveChars_340;

import java.util.HashMap;
import java.util.Map;

public class MapSolution {
    public static void main(String[] args) {
        MapSolution solution = new MapSolution();
        solution.helper("eceba", 2);
    }
    public int helper(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int j = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (map.size() > k) {
                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                    if (map.get(s.charAt(j)) == 0) map.remove(s.charAt(j));
                }
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
