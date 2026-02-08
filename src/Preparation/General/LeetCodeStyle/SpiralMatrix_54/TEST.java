package Preparation.General.LeetCodeStyle.SpiralMatrix_54;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> li = new ArrayList();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bot = matrix.length - 1;
        while (left <= right && top <= bot) {
            for (int i = left; i <= right; i++) {
                li.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i  <= bot; i++) {
                li.add(matrix[i][right]);
            }
            right--;
            if (top <= bot) {
                for (int i = right; i >= left; i--) {
                    li.add(matrix[bot][i]);
                }
                bot--;
            }
            if (left <= right) {
                for (int i = bot; i >= top; i--) {
                    li.add(matrix[i][left]);
                }
                left++;
            }
        }
        return li;
    }
}
