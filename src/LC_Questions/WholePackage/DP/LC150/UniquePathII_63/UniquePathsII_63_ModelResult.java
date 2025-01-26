package LC_Questions.WholePackage.DP.LC150.UniquePathII_63;

public class UniquePathsII_63_ModelResult {
    public static void main(String[] args) {

    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (grid[0][0] == 1) return 0;
        grid[0][0] = 1;
        for (int i = 1; i < row; i++) {
            if (grid[i][0] == 0 && grid[i-1][0] == 1) grid[i][0] = 1;
            else grid[i][0] = 0;
        }
        for (int i = 1; i < col; i++) {
            if (grid[0][i] == 0 && grid[0][i-1] == 1) grid[0][i] = 1;
            else grid[0][i] = 0;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (grid[i][j] == 0) grid[i][j] = grid[i-1][j] + grid[i][j-1];
                else grid[i][j] = 0;
            }
        }
        return grid[row-1][col-1];
    }
}
