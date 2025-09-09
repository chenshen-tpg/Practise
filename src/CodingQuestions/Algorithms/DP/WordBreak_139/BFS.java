package CodingQuestions.Algorithms.DP.WordBreak_139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        BFS wb = new BFS();
        System.out.println(wb.wordBreakBFS(s, wordDict));
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
