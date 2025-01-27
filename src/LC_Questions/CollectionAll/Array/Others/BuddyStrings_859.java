package LC_Questions.CollectionAll.Array.Others;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings_859 {
    public static void main(String[] args) {
        String s = "ab";
        String goal = "ba";
        BuddyStrings_859 b = new BuddyStrings_859();
        b.buddyStrings(s,goal);
    }

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int diff1 = -1, diff2 = -1;
        Set<Character> A_letters = new HashSet<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (diff1 == -1)
                    diff1 = i;
                else if (diff2 == -1)
                    diff2 = i;
                else
                    return false;
            }
            A_letters.add(A.charAt(i));
        }
        if (diff1 != -1 && diff2 != -1) return A.charAt(diff1) == B.charAt(diff2) && A.charAt(diff2) == B.charAt(diff1);
        if (diff1 != -1) return false;
        return A_letters.size() < A.length();
    }

    public boolean buddyStrings_MyWrongVersion_NoOrder(String s, String goal) {
        int count = 0;
        int [] memo = new int [26];
        if (s.length() != goal.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
                memo[s.charAt(i) - 'a']++;
                memo[goal.charAt(i) - 'a']++;
            }
        }
        if (count > 2) return false;
        for (int i = 0; i < 26; i++) {
            if (memo[i] > 0 && memo[i] != 2) {
                return false;
            }
        }
        return true;
    }
}
