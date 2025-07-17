package CodingQuestions.Graph.Graph.LC75.RottingOrganges_994;

public class DFS {
    public static void main(String[] args) {

    }
    class Solution {

        public int orangesRotting(int[][] grid) {
            int min = 2;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        helper(grid, i, j, min);
                    }
                }
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) return -1;
                    min = Math.max(grid[i][j], min);
                }
            }
            return min - 2;
        }
        public void helper(int [][] grid, int i, int j, int min) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || (grid[i][j] > 1 && grid[i][j] < min)) return;
            grid[i][j] = min;
            min++;
            helper(grid, i - 1, j, min);
            helper(grid, i + 1, j, min);
            helper(grid, i, j + 1, min);
            helper(grid, i, j - 1, min);
        }
    }
}
