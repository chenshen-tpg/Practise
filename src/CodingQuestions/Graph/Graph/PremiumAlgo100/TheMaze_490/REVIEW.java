package CodingQuestions.Graph.Graph.PremiumAlgo100.TheMaze_490;

public class REVIEW {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start, destination, new boolean [maze.length][maze[0].length]);
    }

    private boolean dfs(int[][] maze, int[] cur, int[] destination, boolean[][] visits) {
        if (visits[cur[0]][cur[1]]) return false;
        if (cur[0] == destination[0] && cur[1] == destination[1]) return true;
        visits[cur[0]][cur[1]] = true;
        int [] x = {0,1,0,-1};
        int [] y = {-1,0,1,0};
        for (int i = 0; i < 4; i++) {
            int row = cur[0], col = cur[1];
            while (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 0) {
                row += x[i];
                col += y[i];
            }
            if (dfs(maze, new int [] {row-x[i], col - y[i]}, destination, visits)) return true;
        }
        return false;
    }
}
