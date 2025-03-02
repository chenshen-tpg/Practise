package LC_Questions.Prefix.Others.CountServersThatCommunicate_1267;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BruteForceNotWorking {
    public static void main(String[] args) {

            int[][] grid = {
                    {1, 1, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 1}
            };
        System.out.println(seemCorrect(grid));
    }
    //please read the question it's in the same row not together...

    public static int seemCorrect(int [][] grid) {
        int cols = grid[0].length;
        int rows = grid.length;
        int [][] dirs = {{1,0},{0,1},{-1,0}, {0, -1}};
        Set<List<Integer>> hs = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    for (int [] dir : dirs) {
                        int newR = i + dir[0];
                        int newC = j + dir[1];
                        if (newR  < rows && newR >= 0 && newC < cols && newC >= 0 && grid[newR][newC] == 1) {
                            List<Integer> temp = Arrays.asList(i, j);
                            if (!hs.contains(temp)) hs.add(temp);
                        }
                    }
                }
            }
        }
        return hs.size();
    }
}
