package CodingQuestions.Array.ArrayGeneral.CheckIfOneStringSwapCanMakeStringsEqual_1790;

import java.util.Arrays;

public class LinearMemo {
    public static void main(String[] args) {
        String s1 = "caa", s2 = "aaz";
        LinearMemo solution = new LinearMemo();
        solution.areAlmostEqual(s1,s2);
    }
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char[] s1FrequencyMap = new char[26];
        char[] s2FrequencyMap = new char[26];
        int numDiffs = 0;

        for (int i = 0; i < s1.length(); i++) {
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(i);

            if (s1Char != s2Char) {
                numDiffs++;
                if (numDiffs > 2) return false;
            }
            s1FrequencyMap[s1Char - 'a']++;
            s2FrequencyMap[s2Char - 'a']++;
        }
        return Arrays.equals(s1FrequencyMap, s2FrequencyMap);
    }
}
