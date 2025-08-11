package CodingQuestions.Math.RangeProductQueries_2438;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }
    private static final int MOD = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        int index = 1;
        List<Integer> li = new ArrayList();
        while (n > 0) {
            if (n % 2 == 1) {
                li.add(index);
            }
            n /= 2;
            index *= 2;
        }
        int [] res = new int [queries.length];
        for (int i = 0; i < queries.length; i++) {
            int f = queries[i][0];
            int l = queries[i][1];
            long cur = 1;
            for (int j = f; j <= l; j++) {
                cur = (cur * li.get(j)) % MOD;
            }
            res[i] = (int)cur;
        }
        return res;
    }
}
