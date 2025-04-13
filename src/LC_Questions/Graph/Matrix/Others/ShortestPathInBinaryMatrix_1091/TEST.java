package LC_Questions.Graph.Matrix.Others.ShortestPathInBinaryMatrix_1091;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TEST {

    int[][] dire = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

    public static void main(String[] args) {

    }

    public int shortestPathBinaryMatrix(int[][] arr) {
        if (arr[0][0] != 0 || arr[arr.length - 1][arr[0].length - 1] != 0) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        arr[0][0] = 1;
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int row = cur[0], col = cur[1];
            int distance = arr[row][col];
            if (row == arr.length - 1 && col == arr[0].length - 1)
                return distance;
            for (int[] around : getAround(cur[0], cur[1], arr)) {
                q.add(new int[]{around[0], around[1]});
                arr[around[0]][around[1]] = distance + 1;
            }
        }
        return -1;
    }

    public List<int[]> getAround(int row, int col, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int i = 0; i < dire.length; i++) {
            int newRow = row + dire[i][0];
            int newCol = col + dire[i][1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 0)
                continue;
            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours;
    }
}
