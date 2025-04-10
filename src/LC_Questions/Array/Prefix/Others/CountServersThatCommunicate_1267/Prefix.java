package LC_Questions.Array.Prefix.Others.CountServersThatCommunicate_1267;

public class Prefix  {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        System.out.println(countServers(grid)); // Expected output: 0
    }

    public static int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}
