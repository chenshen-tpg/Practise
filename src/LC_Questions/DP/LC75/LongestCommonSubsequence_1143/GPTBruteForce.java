package LC_Questions.DP.LC75.LongestCommonSubsequence_1143;

import java.util.HashSet;
import java.util.Set;

public class GPTBruteForce {
    public static void main(String[] args) {

    }
    public int longestCommonSubsequence(String text1, String text2) {
        Set<String> subsequences1 = generateSubsequences(text1);
        Set<String> subsequences2 = generateSubsequences(text2);
        int maxLength = 0;
        for (String sub1 : subsequences1) {
            if (subsequences2.contains(sub1)) {
                maxLength = Math.max(maxLength, sub1.length());
            }
        }

        return maxLength;
    }
    private Set<String> generateSubsequences(String text) {
        HashSet<String> subsequences = new HashSet<>();
        generateSubsequencesHelper(text, 0, "", subsequences);
        return subsequences;
    }

    // Recursive helper to generate subsequences
    private void generateSubsequencesHelper(String text, int index, String current, Set<String> subsequences) {
        if (index == text.length()) {
            subsequences.add(current);
            return;
        }
        generateSubsequencesHelper(text, index + 1, current + text.charAt(index), subsequences);
        generateSubsequencesHelper(text, index + 1, current, subsequences);
    }
}
