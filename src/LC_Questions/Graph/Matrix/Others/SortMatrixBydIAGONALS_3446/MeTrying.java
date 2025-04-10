package LC_Questions.Graph.Matrix.Others.SortMatrixBydIAGONALS_3446;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeTrying {
    public static void main(String[] args) {
        int [][] matrix = {{1,7,3},{9,8,2},{4,5,6}};
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int key = i - j;
                diagonalMap.putIfAbsent(key, new ArrayList<>());
                diagonalMap.get(key).add(matrix[i][j]);
            }
        }
        System.out.println();
    }
}
