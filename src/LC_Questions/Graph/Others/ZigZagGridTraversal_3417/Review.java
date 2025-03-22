package LC_Questions.Graph.Others.ZigZagGridTraversal_3417;

import java.util.ArrayList;
import java.util.List;

public class Review {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 2}, {3, 4}};
        int[][] grid2 = {{2, 1}, {2, 1}, {2, 1}};
        int[][] grid3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(zigzag(grid1));
        System.out.println(zigzag(grid2));
        System.out.println(zigzag(grid3));
    }
    public static List<Integer> zigzag(int [][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) return result;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j ++) {
                    if ((i + j) % 2 == 0) {
                        result.add(grid[i][j]);
                    }
                }
            } else {
                for (int j = cols - 1; j >= 0; j--) {
                    if ((i + j) % 2 == 0) {
                        result.add(grid[i][j]);
                    }
                }
            }
        }
        return result;
    }
}
