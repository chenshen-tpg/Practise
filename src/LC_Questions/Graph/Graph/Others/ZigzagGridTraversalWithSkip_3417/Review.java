package LC_Questions.Graph.Graph.Others.ZigzagGridTraversalWithSkip_3417;

import java.util.ArrayList;
import java.util.List;

public class Review {
    public static void main(String[] args) {
        int[][] grid3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Review solution = new Review();
        solution.method(grid3);
    }

    public List<Integer> method (int [][] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    if ((i + j) % 2 == 0) {
                        res.add(arr[i][j]);
                    }
                }
            } else {
                for (int j = 0; j < arr[i].length; j++) {
                    if ((i + j) % 2 == 0) {
                        res.add(arr[i][j]);
                    }
                }
            }
        }
        return res;
    }
}
