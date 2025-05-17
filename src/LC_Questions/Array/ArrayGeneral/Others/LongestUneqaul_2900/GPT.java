package LC_Questions.Array.ArrayGeneral.Others.LongestUneqaul_2900;

import java.util.ArrayList;
import java.util.List;

public class GPT {
    public static void main(String[] args) {

    }
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        if (words.length == 0) {
            return ans;
        }

        List<String> cur = new ArrayList<>();
        cur.add(words[0]);
        ans.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (groups[i] != groups[i - 1]) {
                cur.add(words[i]);
                if (cur.size() > ans.size()) {
                    ans = new ArrayList<>(cur);
                }
            } else {
                cur = new ArrayList<>();
                cur.add(words[i]);
                if (cur.size() > ans.size()) {
                    ans = new ArrayList<>(cur);
                }
            }
        }
        return ans;
    }

}
