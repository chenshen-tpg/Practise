package LC_Questions.CollectionAll.Array.Others.BuddyStrings_859;

import java.util.HashSet;
import java.util.Set;

public class LinearFlag {
    public static void main(String[] args) {
        String s = "ab";
        String goal = "ba";
        LinearFlag b = new LinearFlag();
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


}
