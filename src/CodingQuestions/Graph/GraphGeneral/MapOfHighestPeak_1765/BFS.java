package CodingQuestions.Graph.GraphGeneral.MapOfHighestPeak_1765;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        int[][] mat = {{1, 0}, {2, 1}};
        BFS m = new BFS();
        m.HighestPeak(mat);
    }
    Queue<int[]> q = new LinkedList<>();

    public int[][] HighestPeak(int[][] isWater) {
        int[][] heightCells = new int[isWater.length][isWater[0].length];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    heightCells[i][j] = 0;
                    q.add(new int[] {i, j});
                } else {
                    heightCells[i][j] = -1;
                }
            }
        }
        bfs(heightCells);
        return heightCells;
    }

    private void bfs(int[][] heightCells) {
        int[][] DIRECTION = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        while (!q.isEmpty()) {
            int[] cell = q.remove();
            for (int[] dir : DIRECTION) {
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];
                if ((row >= 0 && row < heightCells.length - 1 && col >= 0 && col <= heightCells[0].length - 1) ||
                        heightCells[row][col] != -1) continue;
                heightCells[row][col] = heightCells[cell[0]][cell[1]] + 1;
                q.add(new int[] {row, col});
            }
        }
    }
}
