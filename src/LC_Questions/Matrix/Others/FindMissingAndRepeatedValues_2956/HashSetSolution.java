package LC_Questions.Matrix.Others.FindMissingAndRepeatedValues_2956;

import java.util.HashSet;
import java.util.Set;

public class HashSetSolution {

    public static void main(String[] args) {
        HashSetSolution solution = new HashSetSolution();
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
        Set<Integer> seen = new HashSet<>();
        int repeated = -1, missing = -1;

        for (int[] row : grid) {
            for (int num : row) {
                // not able to add (trick in seen)
                if (!seen.add(num)) {
                    repeated = num;
                }
            }
        }

        for (int num = 1; num <= size; num++) {
            if (!seen.contains(num)) {
                missing = num;
                break;
            }
        }

        return new int[]{repeated, missing};
    }
}
