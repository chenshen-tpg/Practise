package LC_Questions.WholePackage.DP1D.UnqiuePaths;

public class UniquePathII_63_HighestVote {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int result = uniquePathsWithObstacles(arr);
        System.out.println("Number of unique paths: " + result);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[] dp = new int[cols];
        dp[0] = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[c] = 0;
                } else {
                    if (c > 0) {
                        dp[c] += dp[c - 1];
                    }
                }
            }
        }

        return dp[cols - 1];
    }
}
