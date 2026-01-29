package CodingQuestions.Algorithms.Array.ArrayGeneral.MinimalOpsForInscresingcolumn_3402;

public class ColumnIncreasing {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 5},
                {2, 2, 6},
                {3, 4, 7}
        };
        System.out.println(minimumOperations(grid));
    }

    static int minimumOperations(int[][] grid) {
        int ans = 0;
        for (int c = 0; c < grid[0].length; ++c) {
            for (int r = 1; r < grid.length; ++r) {
                if (grid[r][c] <= grid[r - 1][c]) {
                    ans += grid[r - 1][c] + 1 - grid[r][c];
                    grid[r][c] = grid[r - 1][c] + 1;
                }
            }
        }
        return ans;
    }
}
