package CodingQuestions.Array.ArrayGeneral.Others.WordSubsets_916;

import java.util.ArrayList;
import java.util.List;

public class MemoIteration {
    public static void main(String[] args) {
        MemoIteration solution = new MemoIteration();
        System.out.println(solution.wordSubsets(new String [] {"acaac","cccbb","aacbb","caacc","bcbbb","bcc","ccccbae"}, new String [] {"c","cc","b"}));
    }
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> ans = new ArrayList<>();
        int [] memo = new int [26];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length(); j++) {
                memo[B[i].charAt(j) - 'a']++;
            }
        }
        int [] count = new int [A.length];
        for (int i = 0; i < A.length; i++) {
            int [] temp = memo.clone();
            for (int j = 0; j < A[i].length(); j++) {
                if (--temp[A[i].charAt(j) - 'a'] < -1) {
                    count[i] = 1;
                    break;
                }
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 1) {
                ans.add(A[i]);
            }
        }
        return ans;
    }
}
