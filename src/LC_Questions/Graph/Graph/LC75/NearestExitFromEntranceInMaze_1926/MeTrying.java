package LC_Questions.Graph.Graph.LC75.NearestExitFromEntranceInMaze_1926;

import java.util.LinkedList;
import java.util.Queue;

public class MeTrying {
    public static void main(String[] args) {
        MeTrying solver = new MeTrying();

        char[][] maze1 = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };
        int[] entrance1 = {1, 2};
        System.out.println(solver.nearestExit(maze1, entrance1));
        char[][] maze2 = {
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}
        };
        int[] entrance2 = {1, 0};
        System.out.println(solver.nearestExit(maze2, entrance2)); // Expected output: 2

        char[][] maze3 = {
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}
        };
        int[] entrance3 = {1, 2};
        System.out.println(solver.nearestExit(maze3, entrance3)); // Expected output: 2

        char[][] maze4 = {
                {'+', '.', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}
        };
        int[] entrance4 = {1, 1};
        System.out.println(solver.nearestExit(maze4, entrance4)); // Expected output: 1
    }

    private int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length;
        int [][] dirs = new int [][] {{1, 0}, {0 , 1},{-1, 0}, {0, -1}};
        int startRow = entrance[0], startCol = entrance[1];
        maze[startRow][startCol] = '+';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int []{startRow, startCol, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0], curCol = cur[1],curLen = cur[2];
            for (int [] dir:dirs) {
                int nextRow = curRow + dir[0], nextCol = curCol + dir[1];
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && maze[nextRow][nextCol] == '.') {
                    if (nextRow == 0 || nextCol == 0|| nextCol == cols -1 || nextRow == rows -1) {
                        return curLen + 1;
                    }
                    maze[nextRow][nextCol] = '+';
                    queue.offer(new int[] {nextRow, nextCol, curLen + 1});
                }
            }
        }
        return -1;
    }

}
