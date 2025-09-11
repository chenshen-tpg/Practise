package CodingQuestions.Algorithms.Graph.GraphGeneral.SnakesAndLadders_909;

import java.util.LinkedList;
import java.util.Queue;

public class ModelAnsOne {
    public static void main(String[] args) {
        System.out.println(1 & 1);
    }

    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        int r = board.length, c = board[0].length;
        int n = r * c;
        int i = r - 1, j = 0;
        int even = 0, counter = 0;
        int [] moves = new int[n];
        while (i >= 0 && j >= 0) {
            if (board[i][j] != -1) {
                moves[counter] = board[i][j] - 1;
            } else {
                moves[counter] = -1;
            }
            counter++;
            if (even % 2 == 0) {
                j += 1;
            } else {
                j -= 1;
            }
            if (j >= c) {
                i--;
                even += 1;
                j -= 1;
            } else if (j < 0) {
                i--;
                even += 1;
                j += 1;
            }
        }
        int min = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        moves[0] = -2;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int curr = q.poll();
                if (curr == n - 1) return min;
                for (int l = 1; l < 7; l++) {
                    int child = l + curr;
                    if (child < n && moves[child] != -2) {
                        if (moves[child] > -1) {
                            q.add(moves[child]);
                        } else {
                            q.add(child);
                        }
                        moves[child] = -2;
                    }
                }
            }
            min++;
        }
        return -1;
    }
}
