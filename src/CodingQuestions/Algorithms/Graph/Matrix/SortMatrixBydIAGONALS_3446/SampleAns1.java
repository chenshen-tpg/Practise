package CodingQuestions.Algorithms.Graph.Matrix.SortMatrixBydIAGONALS_3446;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SampleAns1 {
    public static void main(String[] args) {
        SampleAns1 solution = new SampleAns1();
        int[][] grid = {
                {1,7,3},
                {9,8,2},
                {4,5,6}
        };
        int[][] result = solution.sortMatrix(grid);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; i + j < n; j++) {
                tmp.add(grid[i + j][j]);
            }
            tmp.sort(Collections.reverseOrder());
            for (int j = 0; i + j < n; j++) {
                grid[i + j][j] = tmp.get(j);
            }
        }

        for (int j = 1; j < n; j++) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; j + i < n; i++) {
                tmp.add(grid[i][j + i]);
            }
            Collections.sort(tmp);
            for (int i = 0; j + i < n; i++) {
                grid[i][j + i] = tmp.get(i);
            }
        }
        return grid;
    }
}
