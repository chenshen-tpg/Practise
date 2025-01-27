package LC_Questions.CollectionAll.Graph.LC75.RottingOrganges_994;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBFS {


    public static void main(String[] args) {
        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(helper(grid1)); // Expected output: 4

        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println(helper(grid2)); // Expected output: -1

        int[][] grid3 = {
                {0, 2}
        };
        System.out.println(helper(grid3)); // Expected output: 0

        int[][] grid4 = {
                {2, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        System.out.println(helper(grid4)); // Expected output: 3
    }

    public static int initialTry (int[][] grid) {
        int fresh = 0;
        int [] start = new int [2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                } else {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;

        int ans = 0;
        int [][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {

            int[] temp = q.poll();
            for (int [] dir : dirs) {
                int row = temp[0] + dir[0];
                int col = temp[1] + dir[1];
                if (temp[0] + dir[0] < grid.length && temp[0] + dir[0] >= 0 && temp[1] + dir[1] < grid[0].length && temp[1] + dir[1] >= 0) {
                    grid[row][col] = 2;
                    q.offer(new int[]{row, col});
                    fresh--;

                }
            }
            ans++;
        }
        return fresh == 0? ans : -1;
    }
    public static int helper (int [][] grid){
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int ans = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                for (int[] dir : dirs) {
                    int row = temp[0] + dir[0];
                    int col = temp[1] + dir[1];
                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            ans++;
        }
        return fresh == 0 ? ans - 1 : -1;
    }
}
