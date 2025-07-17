package CodingQuestions.Array.ArrayGeneral.LC100.PartitionLabels_763;

import java.util.ArrayList;
import java.util.List;

public class TwoPointers {
    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklij");
    }
    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            last[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
