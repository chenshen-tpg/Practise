package CodingQuestions.Array.ArrayGeneral;

public class MinimumOperationsToMakeColumnsStrictlyIncreasing_3402 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 5},
                {2, 2, 6},
                {3, 4, 7}
        };
        System.out.println(minimumOperations(grid));
        helper(grid);
    }

    public static void helper (int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 1; j < grid.length; j++) {
                if (grid[j][i] < grid[j-1][i]) {
                    ans += grid[j][i] - grid[j-1][i] + 1;
                    grid[j][i] = grid[j-1][i] + 1;
                }
            }
        }
        System.out.println(ans);
    }

    static int minimumOperations(int[][] grid) {
        int ans = 0;
        for(int c = 0; c < grid[0].length; ++c){
            for(int r = 1; r < grid.length; ++r){
                if(grid[r][c] <= grid[r-1][c]) {
                    ans += grid[r-1][c] + 1 - grid[r][c];
                    grid[r][c] = grid[r-1][c] + 1;
                }
            }
        }
        return ans;
    }
}
