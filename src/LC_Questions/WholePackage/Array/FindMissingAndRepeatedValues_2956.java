package LC_Questions.WholePackage.Array;

import java.util.HashMap;

public class FindMissingAndRepeatedValues_2956 {
    public static void main(String[] args) {
        int[][] grid = {{1,3}, {2, 2}};
        helper(grid);
    }

    public static int[] helper (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int [] res = new int [2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                hm.put(matrix[i][j], hm.getOrDefault(matrix[i][j], 0) + 1);
            }
        }
        for (int i = 1; i <= rows * cols; i++) {
            int temp = hm.getOrDefault(i, 0);
                if (temp == 2) res[1] = i;
                if (temp == 0) res[0] = i;

        }
        return res;
    }

}
