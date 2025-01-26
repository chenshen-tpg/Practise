package LC_Questions.WholePackage.Graph.LC150.SurroundedRegions_130;

import Lib.Pair;

import java.util.LinkedList;
import java.util.List;

public class SurrondedRegions_130 {
    public static void main(String[] args) {
        SurrondedRegions_130 s = new SurrondedRegions_130();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        s.sur(board);
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
    public void sur(char[][] board) {
        if (board.length < 3 || board[0].length < 3) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            // first and last row
            if (board[i][0] == 'O') helper(board, i, 0);
            if (board[i][n - 1] == 'O') helper(board, i, n - 1);
        }
        // first and last column
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') helper(board, 0, j);
            if (board[m - 1][j] == 'O') helper(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }
    private void helper(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') return;
        board[r][c] = '*';
        helper(board, r + 1, c);
        helper(board, r - 1, c);
        helper(board, r, c + 1);
        helper(board, r, c - 1);
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
            this.DFS(board, pair.getKey(), pair.getValue());
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
            int row = pair.getKey(), col = pair.getValue();
            if (board[row][col] != 'O') continue;
            board[row][col] = 'E';
            if (col < this.COLS - 1) queue.offer(new Pair<>(row, col + 1));
            if (row < this.ROWS - 1) queue.offer(new Pair<>(row + 1, col));
            if (col > 0) queue.offer(new Pair<>(row, col - 1));
            if (row > 0) queue.offer(new Pair<>(row - 1, col));
        }
    }
}




