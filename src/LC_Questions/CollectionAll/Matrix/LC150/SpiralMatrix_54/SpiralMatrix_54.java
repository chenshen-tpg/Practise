package LC_Questions.CollectionAll.Matrix.LC150.SpiralMatrix_54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    public static void main(String[] args) {
        SpiralMatrix_54 sm = new SpiralMatrix_54();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        sm.spiralOrder(matrix2);

    }

    private void spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0, bottom = row - 1, left = 0, right = col - 1;
        List<Integer> ans = new ArrayList<>();
        while (top <= bottom && left <= right) {
           for (int i = left; i < right; i++) {
               ans.add(matrix[top][i]);
           }
           top++;
           for (int i = top; i < bottom; i++) {
               ans.add(matrix[i][right]);
           }
           right--;
           if (top <= bottom) {
               for (int i = right; i >= left; i--) {
                   ans.add(matrix[bottom][i]);
               }
               bottom--;
           }
           if (left <= right) {
               for (int i = bottom; i >= top; i--) {
                   ans.add(matrix[i][left]);
               }
               left++;
           }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+ "");
        }
    }
}
