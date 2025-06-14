package LC_Questions.Graph.Graph.LC150.SnakesAndLadders_909;


import Lib.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ModelAns {


    public static void main(String[] args) {
        ModelAns s = new ModelAns();
        System.out.println(s.snakesAndLadders(new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}));
    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n * n + 1];
        int label = 1;
        Integer[] columns = new Integer[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }
        for (int row = n - 1; row >= 0; row--) {
            for (int column : columns) {
                cells[label++] = new Pair<>(row, column);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<Integer>();
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int next = cur + 1; next <= Math.min(cur + 6, n * n); next++) {
                int row = cells[next].getKey(), column = cells[next].getValue();
                int dest = board[row][column] != -1 ? board[row][column] : next;
                if (dist[dest] == -1) {
                    dist[dest] = dist[cur] + 1;
                    q.add(dest);
                }
            }
        }
        return dist[n * n];
    }
}
