package CodingQuestions.Algorithms.Graph.Matrix.GridGame_2017;

public class Linear_TwoPass {
    public static void main(String[] args) {

    }
    public long gridGame(int[][] grid) {
        long first = 0;
        long second = 0;
        long min = Long.MAX_VALUE;
        for (int num : grid[0]) first += num;
        for (int i = 0; i < grid[0].length; i++) {
            first -= grid[0][i];
            min = Math.min(min, Math.max(first, second));
            second += grid[1][i];
        }
        return min;
    }

}
