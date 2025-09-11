package CodingQuestions.Algorithms.Graph.Matrix.FindMissingAndRepeatedValues_2956;

public class Array {
    public static void main(String[] args) {
        Array solution = new Array();
        int[][] grid = {
                {9, 1, 7},
                {8, 9, 2},
                {3, 4, 6}
        };
        int[] result = solution.findMissingAndRepeatedValues(grid);
        System.out.println("Repeated: " + result[0] + ", Missing: " + result[1]);
    }
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] freq = new int[size + 1];
        int repeated = -1, missing = -1;

        for (int[] row : grid) {
            for (int num : row) {
                freq[num]++;
            }
        }

        for (int num = 1; num <= size; num++) {
            if (freq[num] == 2) repeated = num;
            if (freq[num] == 0) missing = num;
        }

        return new int[]{repeated, missing};
    }
}
