package LC_Questions.CollectionAll.DP.LC150.WordBreak_139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class wordBreak_139_med {
    private String s;
    private List<String> wordDict;
    private int[] memo;
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"));
        wordBreak_139_med wb = new wordBreak_139_med();
        System.out.println(wb.wordBreak(s, wordDict));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        this.memo = new int[s.length()];
        Arrays.fill(this.memo, -1);
        return helper(s.length() - 1);
    }
    private boolean helper(int i) {
        if (i < 0) return true;
        if (memo[i] != -1) return memo[i] == 1;
        for (String word : wordDict) {
            if (i - word.length() + 1 < 0) continue;
            if (s.substring(i - word.length() + 1, i + 1).equals(word) && helper(i - word.length())) {
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }
    public boolean wordBreakBFS(String s, List<String> wordDict) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>(wordDict);
        boolean[] seen = new boolean[s.length() + 1];
        q.add(0);
        while (!q.isEmpty()) {
            int start = q.remove();
            if (start == s.length()) {
                return true;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (seen[end]) {
                    continue;
                }
                if (hs.contains(s.substring(start, end))) {
                    q.add(end);
                    seen[end] = true;
                }
            }
        }
        return false;
    }
}
