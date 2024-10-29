package LC_Questions.LC_150.GraphGeneral;

import java.util.LinkedList;
import java.util.List;

public class SurrondedRegions_130 {
    class Pair<U, V> {
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }
    Integer ROWS = 0;
    Integer COLS = 0;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        this.ROWS = board.length;
        this.COLS = board[0].length;
        List<Pair<Integer, Integer>> borders = new LinkedList<Pair<Integer, Integer>>();

        for (int r = 0; r < this.ROWS; ++r) {
            borders.add(new Pair(r, 0));
            borders.add(new Pair(r, this.COLS - 1));
        }
        for (int c = 0; c < this.COLS; ++c) {
            borders.add(new Pair(0, c));
            borders.add(new Pair(this.ROWS - 1, c));
        }
        for (Pair<Integer, Integer> pair : borders) {
            this.DFS(board, pair.first, pair.second);
        }
        for (int r = 0; r < this.ROWS; ++r) {
            for (int c = 0; c < this.COLS; ++c) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'E') board[r][c] = 'O';
            }
        }
    }
    protected void DFS(char[][] board, int row, int col) {
        if (board[row][col] != 'O') return;
        board[row][col] = 'E';
        if (col < this.COLS - 1) this.DFS(board, row, col + 1);
        if (row < this.ROWS - 1) this.DFS(board, row + 1, col);
        if (col > 0) this.DFS(board, row, col - 1);
        if (row > 0) this.DFS(board, row - 1, col);
    }
    protected void BFS(char[][] board, int r, int c) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.offer(new Pair<>(r, c));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.pollFirst();
            int row = pair.first, col = pair.second;
            if (board[row][col] != 'O') continue;
            board[row][col] = 'E';
            if (col < this.COLS - 1) queue.offer(new Pair<>(row, col + 1));
            if (row < this.ROWS - 1) queue.offer(new Pair<>(row + 1, col));
            if (col > 0) queue.offer(new Pair<>(row, col - 1));
            if (row > 0) queue.offer(new Pair<>(row - 1, col));
        }
    }
}




