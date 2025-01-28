package LC_Questions.CollectionAll.Matrix.Others;

public class GridGame_2017 {
    public static void main(String[] args) {
        
    }
    public long gridGame(int[][] grid) {
        long f = 0;
        long s = 0;
        long min = Long.MAX_VALUE;
        for (int num : grid[0]) f += num;
        for (int i = 0; i < grid[0].length; i++) {
            f -= grid[0][i];
            min = Math.min(min, Math.max(f, s));
            s += grid[1][i];
        }
        return min;
    }
}
