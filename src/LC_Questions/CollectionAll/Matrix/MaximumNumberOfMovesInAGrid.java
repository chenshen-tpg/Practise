package LC_Questions.CollectionAll.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumNumberOfMovesInAGrid {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(maxMoves(grid));
    }


    public static final int[] dirs = {-1, 0, 1};

    public static int maxMoves(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            vis[i][0] = true;
            q.offer(new int[]{i, 0, 0});
        }
        int maxMoves = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int[] v = q.poll();
                int row = v[0], col = v[1], count = v[2];
                maxMoves = Math.max(maxMoves, count);
                for (int dir : dirs) {
                    int newRow = row + dir, newCol = col + 1;
                    if (newRow >= 0 && newCol >= 0 && newRow < M && newCol < N && !vis[newRow][newCol] && grid[row][col] < grid[newRow][newCol]) {
                        vis[newRow][newCol] = true;
                        q.offer(new int[]{newRow, newCol, count + 1});
                    }
                }
            }
        }
        return maxMoves;
    }
}