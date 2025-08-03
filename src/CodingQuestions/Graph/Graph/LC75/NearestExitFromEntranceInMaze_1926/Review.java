package CodingQuestions.Graph.Graph.LC75.NearestExitFromEntranceInMaze_1926;

import java.util.LinkedList;
import java.util.Queue;

public class Review {
    public static void main(String[] args) {

    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int [][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int []> q = new LinkedList();
        q.offer(new int[] {entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                int [] temp = q.poll();
                for (int [] dir : dirs) {
                    int x = dir[0] + temp[0];
                    int y = dir[1] + temp[1];
                    if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == '.') {
                        if (x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1) {
                            return count;
                        }
                        maze[x][y] = '+';
                        q.offer(new int [] {x, y});
                    }
                }
            }
        }
        return -1;
    }
}
