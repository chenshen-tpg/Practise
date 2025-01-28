package LC_Questions.CollectionAll.Graph.Others.MaximumNumberofFishinaGrid_2658;

public class DFS {
    public static void main(String[] args) {
        DFS solution = new DFS();

        int[][] grid = {
                {0, 2, 1, 0},
                {4, 0, 0, 3},
                {1, 0, 0, 4},
                {0, 3, 2, 0}
        };
        System.out.println(solution.findMaxFish(grid));
    }

    public int findMaxFish(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
    public int dfs (int [][] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 0) {
            return 0;
        }
        int temp = arr[i][j];
        arr[i][j] = 0;
        int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        for (int [] dir : dirs) {
            int col = i + dir[0];
            int row = j + dir[1];
            temp += dfs(arr, col, row);
        }
        return temp;
    }
}
