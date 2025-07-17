package CodingQuestions.Array.ArrayGeneral.Others.UniqueSubStringsWithEqualDigit_2168;

import java.util.HashSet;
import java.util.Set;

public class SetMemoFlag {
    public static void main(String[] args) {
        String s = "12321";
        equalDigitFrequency(s);
    }

    public static int equalDigitFrequency(String s) {
        Set<String> validSubstrings = new HashSet<>();
        for (int start = 0; start < s.length(); start++) {
            int[] digitFrequency = new int[10];
            for (int end = start; end < s.length(); end++) {
                digitFrequency[s.charAt(end) - '0']++;
                int commonFrequency = 0;
                boolean isValid = true;
                for (int i = 0; i < digitFrequency.length; i++) {
                    if (digitFrequency[i] == 0) continue;
                    if (commonFrequency == 0) commonFrequency = digitFrequency[i];
                    if (commonFrequency != digitFrequency[i]) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    String substring = s.substring(start, end + 1);
                    validSubstrings.add(substring);
                }
            }
        }
        return validSubstrings.size();
    }
}
