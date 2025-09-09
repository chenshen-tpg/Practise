package CodingQuestions.Algorithms.Math.MaximumAreaOfLongestDiagonalRectangle_3000;

public class TEST {
    public static void main(String[] args) {

    }
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max = 0;
        int temp = 0;
        int res = 0;
        for (int [] dimension : dimensions) {
            temp = dimension[0] * dimension[0] + dimension[1] * dimension[1];
            if (temp > max) {
                max = temp;
                res = dimension[0] * dimension[1];
            } else if (temp == max) {
                if (dimension[0] * dimension[1] > res) {
                    res = dimension[0] * dimension[1];
                }
            }
        }
        return res;
    }
}
