package CodingQuestions.Algorithms.DP.WordBreak_139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BU_DP {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet","code"));
        BU_DP wb = new BU_DP();
        System.out.println(wb.wordBreak(s, wordDict));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (i < word.length() - 1) continue;
                if (i == word.length() - 1 || dp[i - word.length()]) {
                    if (s.substring(i - word.length() + 1, i + 1).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
