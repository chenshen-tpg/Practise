package CodingQuestions.Graph.Graph.PremiumAlgo100.TheMaze_490;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {

    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visit = new boolean[m][n];
        int[] x = {0, 1, 0, -1};
        int[] y = {-1, 0, 1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visit[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int r = curr[0];
                int c = curr[1];
                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0) {
                    r += x[i];
                    c += y[i];
                }
                r -= x[i];
                c -= y[i];
                if (!visit[r][c]) {
                    queue.offer(new int[]{r, c});
                    visit[r][c] = true;
                }
            }
        }
        return false;
    }
}
