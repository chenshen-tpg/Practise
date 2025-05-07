package LC_Questions.Graph.Matrix.Others.FillASpecialGrid_3537;

public class RECURSIVE {
    public static void main(String[] args) {

    }

    public int[][] specialGrid(int n) {
        // 1 << n same as * Math.pow(2, 1)
        int size = 1 << n;
        int[][] grid = new int[size][size];
        solve(grid, 0, 0, size);
        return grid;
    }
    private int val = 0;

    private void solve(int[][] grid, int r, int c, int size){
        if (size == 1){
            grid[r][c] = val++;
            return;
        }
        int s = size / 2;
        solve(grid, r, c + s, s);
        solve(grid, r + s, c + s, s);
        solve(grid, r + s, c, s);
        solve(grid, r, c, s);
    }
}
