package CodingQuestions.Array.ArrayGeneral.PartitionLabels_763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        helper("ababcbacadefegdehijhklij");
    }

    public static List<Integer> helper (String s) {
        List<Integer> res = new ArrayList<>();
        int[] second = new int[26];
        int[] first = new int[26];
        Arrays.fill(first, -1);
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) second[s.charAt(i) - 'a'] = i;
        for (int i = 0; i < s.length(); i++) {
            // filled up the first  with -1
            if (first[s.charAt(i) - 'a'] == -1) {
                first[s.charAt(i) - 'a'] = i;
            }
            if (end < first[s.charAt(i) - 'a']) {
                res.add(end - start + 1);
                start = i;
                end = i;
            }
            end = Math.max(end, second[s.charAt(i) - 'a']);
        }
        if (end - start > 1) {
            res.add(end - start + 1);
        }
        return res;
    }
}
