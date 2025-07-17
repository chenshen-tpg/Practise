package CodingQuestions.Graph.Graph.Others.ZigzagGridTraversalWithSkip_3417;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 2}, {3, 4}};
        int[][] grid2 = {{2, 1}, {2, 1}, {2, 1}};
        int[][] grid3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//
        System.out.println(zigzag(grid1));
        System.out.println(zigzag(grid2));
        System.out.println(zigzag(grid3));
    }
    public static List<Integer> zigzag(int [][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) return result;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean goingRight = true;

        for (int row = 0; row < rows; row++) {
            if (goingRight) {
                for (int col = 0; col < cols; col ++) {
                    if ((row + col) % 2 == 0) {
                        result.add(grid[row][col]);
                    }
                }
            } else {
                for (int col = cols - 1; col >= 0; col--) {
                    if ((row + col) % 2 == 0) {
                        result.add(grid[row][col]);
                    }
                }
            }
            goingRight = !goingRight;
        }
        return result;
    }
}
