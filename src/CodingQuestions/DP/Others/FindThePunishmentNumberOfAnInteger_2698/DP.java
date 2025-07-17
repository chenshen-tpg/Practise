package CodingQuestions.DP.Others.FindThePunishmentNumberOfAnInteger_2698;

import java.util.Arrays;

public class DP {
    public static void main(String[] args) {

    }
    public boolean findPartitions(int i, int sum, String stringNum, int target, int[][] memo) {
        if (sum > target) return false;
        if (i == stringNum.length()) return sum == target;
        if (memo[i][sum] != -1) return memo[i][sum] == 1;
        boolean flag = false;
        for (int j = i; j < stringNum.length(); j++) {
            String currentString = stringNum.substring(i, j + 1);
            flag = flag || findPartitions(j + 1, sum + Integer.parseInt(currentString), stringNum, target, memo);
            if (flag) {
                memo[i][sum] = 1;
                return true;
            }
        }
        memo[i][sum] = 0;
        return false;
    }

    public int punishmentNumber(int n) {
        int punishmentNum = 0;
        for (int currentNum = 1; currentNum <= n; currentNum++) {
            int squareNum = currentNum * currentNum;
            String num = Integer.toString(squareNum);
            int[][] memoArray = new int[num.length()][currentNum + 1];
            for (int[] row : memoArray) Arrays.fill(row, -1);
            if (findPartitions(0, 0, num, currentNum, memoArray)) punishmentNum += squareNum;
        }
        return punishmentNum;
    }
}
