package LC_Questions.WholePackage.Array.Others;

import java.util.Arrays;

public class ZigzagConversion_6_med {
    public static void main(String[] args) {

    }
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int n = s.length();
        int numSec = (int) Math.ceil(n / (2 * numRows - 2.0));
        int numCol = numSec * (numRows - 1);
        char[][] tem = new char[numRows][numCol];
        for (char[] row : tem) {
            Arrays.fill(row, ' ');
        }
        int currRow = 0, currCol = 0;
        int curIndex = 0;
        while (curIndex < n) {
            while (currRow < numRows && curIndex < n) {
                tem[currRow][currCol] = s.charAt(curIndex);
                currRow++;
                curIndex++;
            }
            currRow -= 2;
            currCol++;
            while (currRow > 0 && currCol < numCol && curIndex < n) {
                tem[currRow][currCol] = s.charAt(curIndex);
                currRow--;
                currCol++;
                curIndex++;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (char[] row : tem) {
            for (char character : row) {
                if (character != ' ') {
                    answer.append(character);
                }
            }
        }
        return answer.toString();
    }
}
