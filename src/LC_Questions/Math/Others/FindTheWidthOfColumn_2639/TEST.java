package LC_Questions.Math.Others.FindTheWidthOfColumn_2639;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.findColumnWidth(new int[][] {{0}});
    }

    public int[] findColumnWidth(int[][] grid) {
        int [] ans = new int [grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                int temp = Math.abs(grid[j][i]);
                int cur = 0;
                if (temp == 0) cur = 1;
                else {
                    while (temp > 0) {
                        temp /= 10;
                        cur++;
                    }
                }
                if (grid[j][i] < 0) cur++;
                max = Math.max(max, cur);
            }
            ans[i] = max;
        }
        return ans;
    }
}
