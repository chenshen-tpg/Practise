package LC_Questions.CollectionAll.DP.Others;

public class MinimumPathSum_64_Med {
    public static void main(String[] args) {
        MinimumPathSum_64_Med m = new MinimumPathSum_64_Med();
        System.out.println(m.minPathSum1D(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

    private int minPathSum1D(int[][] grid) {
        int [][] memo = new int [grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    memo[i][j] = grid[i][j] + memo[i][j+1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    memo[i][j] = grid[i][j] + memo[i+1][j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    memo[i][j] = grid[i][j] + Math.min(memo[i + 1][j], memo[i][j + 1]);
                } else {
                    memo[i][j] = grid[i][j];
                }
            }
        }
        return memo[0][0];
    }

    private int minPathSum2D(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) dp[j] = grid[i][j] + dp[j + 1];
                else if (j == grid[0].length - 1 && i != grid.length - 1) dp[j] = grid[i][j] + dp[j];
                else if (j != grid[0].length - 1 && i != grid.length - 1) dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }

    private int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) grid[i][j] = grid[i][j] + grid[i][j + 1];
                else if (j == grid[0].length - 1 && i != grid.length - 1) grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if (j != grid[0].length - 1 && i != grid.length - 1) grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }
}
