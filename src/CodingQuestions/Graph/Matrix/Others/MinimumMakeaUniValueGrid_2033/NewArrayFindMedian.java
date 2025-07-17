package CodingQuestions.Graph.Matrix.Others.MinimumMakeaUniValueGrid_2033;

import java.util.Arrays;

public class NewArrayFindMedian {
    public static void main(String[] args) {
        NewArrayFindMedian solution = new NewArrayFindMedian();
        solution.minOperations(new int [][] {{2,4}, {6,8}}, 2);
    }

    public int minOperations(int[][] grid, int x) {
        int res = 0;
        int index = 0;
        int [] memo = new int [grid.length * grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                memo[index++] = grid[i][j];
            }
        }
        Arrays.sort(memo);
        int intermediate = memo[memo.length / 2];
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] % x != intermediate % x) return -1;
            res += Math.abs(intermediate- memo[i]) / x;
        }
        return res;
    }
}
