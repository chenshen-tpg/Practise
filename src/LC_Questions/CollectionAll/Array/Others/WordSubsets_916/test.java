package LC_Questions.CollectionAll.Array.Others.WordSubsets_916;

import java.util.ArrayList;
import java.util.List;

public class test {
//    Input: words1 = ["acaac","cccbb","aacbb","caacc","bcbbb"], words2 = ["c","cc","b"]
    public static void main(String[] args) {
        test solution = new test();
        System.out.println(solution.wordSubsets(new String [] {"acaac","cccbb","aacbb","caacc","bcbbb","bcc","ccccbae"}, new String [] {"c","cc","b"}));
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int [] count = new int [26];
        int [] temp;
        int i;
        ArrayList<String> res = new ArrayList();
        for (String word2 : words2) {
            temp = helper(word2);
            for (i = 0; i < 26; i++) count[i] = Math.max(count[i], temp[i]);
        }
        for (String word1 : words1) {
            temp = helper(word1);
            for (i = 0; i < 26; i++) {
                if (temp[i] < count[i]) break;
            }
            if (i == 26) res.add(word1);
        }
        return res;
    }
    public int [] helper (String s) {
        int [] temp = new int [26];
        for (char c : s.toCharArray()) temp[c - 'a'] ++;
        return temp;
    }
}
