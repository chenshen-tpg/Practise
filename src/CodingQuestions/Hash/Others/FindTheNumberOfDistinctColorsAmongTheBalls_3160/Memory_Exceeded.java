package CodingQuestions.Hash.Others.FindTheNumberOfDistinctColorsAmongTheBalls_3160;

import java.util.HashSet;

public class Memory_Exceeded {
    public static void main(String[] args) {
        Memory_Exceeded solution = new Memory_Exceeded();
        int limit = 4;
        int [][] queries = {{1,4},{2,5},{1,3},{3,4}};
        int limit2 = 4;
        int queries2 [][]= {{0,1},{1,2},{2,2},{3,4},{4,5}}; //[1,2,2,3,4]
        int limit1 = 1;
        int[][] queries1 = {{0, 1}, {0, 4}, {0, 4}, {0, 1}, {1, 2}};
        int [] ans = solution.queryResults(limit1,queries1);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
    public int[] queryResults(int limit, int[][] queries) {
        int n = 0;
        for (int i = 0; i < queries.length; i++) {
            n = Math.max(n, queries[i][0]);
        }
        int[] memo = new int[n + 1];
        int[] res = new int[queries.length];
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < queries.length; i++) {
            int curNum = queries[i][0];
            int curColour = queries[i][1];
            memo[curNum] = curColour;
            hs.clear();
            for (int j = 0; j <= n; j++) {
                if (memo[j] != 0) hs.add(memo[j]);
            }
            res[i] = hs.size();
        }
        return res;
    }
}
