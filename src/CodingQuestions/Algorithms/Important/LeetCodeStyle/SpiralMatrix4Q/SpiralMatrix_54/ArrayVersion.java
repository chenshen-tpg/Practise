package CodingQuestions.Algorithms.Important.LeetCodeStyle.SpiralMatrix4Q.SpiralMatrix_54;

public class ArrayVersion {
    public static void main(String[] args) {

    }
    public int[] spiral_order(int[][] matrix) {
        int index = 0;
        int [] ans = new int [matrix.length * matrix[0].length];
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bot = matrix.length - 1;
        while (left <= right) {
            for (int i = left; i <= right; i++) {
                ans[index++] = matrix[top][i];
            }
            top++;
            for (int i = top; i  <= bot; i++) {
                ans[index++] = matrix[i][right];
            }
            right--;
            if (top <= bot) {
                for (int i = right; i >= left; i--) {
                    ans[index++] = matrix[bot][i];
                }
                bot--;
            }
            if (left <= right) {
                for (int i = bot; i >= top; i--) {
                    ans[index++] = matrix[i][left];
                }
                left++;
            }
        }
        return ans;
    }
}
