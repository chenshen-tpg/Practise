package CodingQuestions.Hash.EqualRowAndColumnPairs_2352;

import java.util.Arrays;
import java.util.HashMap;

public class HashMapSolution {
    public static void main(String[] args) {
        HashMapSolution solution = new HashMapSolution();
        int [][] arr = new int [][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        solution.helper(arr);
    }
    public int  helper (int [][] grid) {
        int count = 0;
        int n = grid.length;
        HashMap<String, Integer> hm = new HashMap();
        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            hm.put(rowString, hm.getOrDefault(rowString, 0) + 1);
        }
        for (int c = 0; c < n; c++) {
            int[] colArray = new int[n];
            for (int r = 0; r < n; ++r) {
                colArray[r] = grid[r][c];
            }
            count += hm.getOrDefault(Arrays.toString(colArray), 0);
        }

        return count;
    }
}
