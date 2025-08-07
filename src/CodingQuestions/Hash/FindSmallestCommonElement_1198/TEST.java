package CodingQuestions.Hash.FindSmallestCommonElement_1198;

import java.util.HashMap;
import java.util.Map;

public class TEST {

    public static void main(String[] args) {

    }

    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                hm.put(mat[i][j], hm.getOrDefault(mat[i][j], 0) + 1);
            }
        }
        int count = Integer.MAX_VALUE;
        for (Integer m : hm.keySet()) {
            if (hm.get(m) >= mat.length) count = Math.min(count, m);
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }
}
