package LC_Questions.CollectionAll.Array.Others.CheckIfOneStringSwapCanMakeStringsEqual_1790;

import java.util.HashMap;

public class linear {
    public static void main(String[] args) {
        String s1 = "caa", s2 = "aaz";
        linear solution = new linear();
        solution.linear(s1,s2);
    }
    public boolean linear(String s1, String s2) {
        int firstIndexDiff = 0;
        int secondIndexDiff = 0;
        int numDiffs = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                numDiffs++;
                if (numDiffs > 2) {
                    return false;
                }
                else if (numDiffs == 1) {
                    firstIndexDiff = i;
                } else {
                    secondIndexDiff = i;
                }
            }
        }
        return (
                s1.charAt(firstIndexDiff) == s2.charAt(secondIndexDiff) &&
                        s1.charAt(secondIndexDiff) == s2.charAt(firstIndexDiff)
        );
    }
}
