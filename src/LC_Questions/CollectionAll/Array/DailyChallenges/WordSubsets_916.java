package LC_Questions.CollectionAll.Array.DailyChallenges;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets_916 {
    public static void main(String[] args) {
        WordSubsets_916 ws = new WordSubsets_916();

//        String [] words1 = new String[]{"facebook"};
        String [] words1 = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
        String [] words2 = new String[]{"aa", "am", "ap"};
        System.out.println(ws.wordSubsets(words1, words2)); // Output: [google, leetcode]

//        String [] words1 = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
//        String [] words2 = new String[]{"ec", "oc", "ceo"};
//        System.out.println(ws.wordSubsets(words1, words2));
    }
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        int[] count = new int[26], temp;
        int i;
        for (String b : B) {
            temp = helper(b);
            for (i = 0; i < 26; i++)
                count[i] = Math.max(count[i], temp[i]);
        }
        for (String a : A) {
            temp = helper(a);
            for (i = 0; i < 26; i++) {
                if (temp[i] < count[i]) break;
            }
            if (i == 26) res.add(a);
        }
        return res;
    }
    public int [] helper (String word){
        int[] memo = new int[26];
            for (char c : word.toCharArray()) {
                memo[c -'a']++;
            }
        return memo;
    }
}
