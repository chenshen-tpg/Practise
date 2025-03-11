package LC_Questions.SlidingWindow.Others.CountOfStringsContainingEveryVoweii_3306;

import java.util.HashSet;
import java.util.Set;

public class TwoPassWrong {
    public static int countVowelSubstrings(String s, int k) {
        int ans = 0;
        if (s.length() < 5 + k) return 0;
        for (int i = 0; i <= s.length() - (5 + k); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < i + 5 + k; j++) {
                if ("aeiou".contains(s.charAt(j) + "")) {
                    set.add(s.charAt(j));
                }
            }
            if (set.size() == 5) {
                ans++;
            }
        }
        return ans;
    }
}
