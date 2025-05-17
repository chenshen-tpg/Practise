package LC_Questions.Array.ArrayGeneral.Others.LongestUneqaul_2900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TEST {
    public static void main(String[] args) {
            TEST test = new TEST();
            String[] words = {"e", "a", "b"};
            int[] groups = {0, 0, 1};

            List<String> result = test.getLongestSubsequence(words, groups);
            System.out.println("Longest Subsequence: " + result);
    }
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        if (words.length == 1 && groups.length == 1) return Arrays.asList(words[0]);
        List<String> ans = new ArrayList(), temp = new ArrayList();
        int len = 0;
        for (int i = 1; i < groups.length; i++) {
            if (groups[i - 1] != groups[i]) {
                temp.add(words[i - 1]);
                temp.add(words[i]);
                if (temp.size() > len) {
                    len = temp.size();
                    ans = temp;
                }
            } else {
                temp = new ArrayList();
            }
        }
        return ans;
    }
}
