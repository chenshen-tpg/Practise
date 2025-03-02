package LC_Questions.Graph.Others;

import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak_1765 {
    /***
     * 001
     * 100
     * 000
     *
     * 110
     * 011
     * 122
     */
    static int[][] DIRECTION = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    int rows;
    int cols;
    int[][] isWater;
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0},
                {2, 1}
        };
        MapOfHighestPeak_1765 m = new MapOfHighestPeak_1765();
        m.highestPeak(mat);
    }
    public int[][] highestPeak(int[][] isWater) {
        this.isWater = isWater;
        rows = isWater.length;
        cols = isWater[0].length;
        int[][] heightCells = new int[rows][cols];
        Queue<int[]> q = new LinkedList();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isWater[r][c] == 1) {
                    heightCells[r][c] = 0;
                    q.add(new int[] { r, c });
                } else {
                    heightCells[r][c] = -1;
                }
            }
        }
        bfs(q, heightCells);
        return heightCells;
    }

    private void bfs(Queue<int[]> q, int[][] heightCells) {
        while (!q.isEmpty()) {
            int[] cell = q.remove();
            for (int[] dir : DIRECTION) {
                int curRow = cell[0] + dir[0];
                int curCol = cell[1] + dir[1];
                if (!isValid(curRow, curCol) || heightCells[curRow][curCol] != -1) continue;
                heightCells[curRow][curCol] = heightCells[cell[0]][cell[1]] + 1;
                q.add(new int[] { curRow, curCol });
            }
        }
    }
    private boolean isValid (int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
