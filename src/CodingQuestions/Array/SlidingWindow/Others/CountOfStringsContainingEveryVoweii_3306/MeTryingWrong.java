package CodingQuestions.Array.SlidingWindow.Others.CountOfStringsContainingEveryVoweii_3306;

import java.util.HashSet;
import java.util.Set;

public class MeTryingWrong {
    public static void main(String[] args) {

    }
    public long countOfSubstrings(String s, int k) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        if (s.length() < 5 + k) return 0;
        for (int i = 0; i < 5 + k; i++) {
            if ("aeiou".contains(s.charAt(i) + "")) {
                set.add(s.charAt(i));
            }
            if (set.size() == 5) {
                ans++;
            }
        }
        int index = 0;
        for (int j = 5 + k; j < s.length(); j++) {
            if ("aeiou".contains(s.charAt(j) + "")) {
                set.add(s.charAt(j));
            }
            if (set.contains(s.charAt(index))) {
                set.remove(s.charAt(index));
                index++;
            }
            if (set.size() == 5) {
                ans++;
                set.clear();
            }
        }
        return ans;
    }
}
