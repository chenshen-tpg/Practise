package CodingQuestions.Graph.Graph.PremiumAlgo100.TheMaze_490;

public class DFS {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze.length, maze[0].length, maze, start, destination, new boolean[maze.length][maze[0].length]);
    }

    public boolean dfs(int m, int n, int[][] maze, int[] curr, int[] destination, boolean[][] visit) {
        if (visit[curr[0]][curr[1]]) return false;
        if (curr[0] == destination[0] && curr[1] == destination[1]) return true;
        visit[curr[0]][curr[1]] = true;
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {-1, 0, 1, 0};
        for (int i = 0; i < 4; i++) {
            int r = curr[0], c = curr[1];
            while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0) {
                r += dirX[i];
                c += dirY[i];
            }
            if (dfs(m, n, maze, new int[]{r - dirX[i], c - dirY[i]}, destination, visit)) return true;
        }
        return false;
    }
}
