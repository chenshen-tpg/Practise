package CodingQuestions.Algorithms.DP.FindThePunishmentNumberOfAnInteger_2698;

public class Recursive {
    public static void main(String[] args) {


    }

    public boolean canPartition(String num, int target) {
        if (num.isEmpty() && target == 0) return true;
        if (target < 0) return false;
        for (int i = 0; i < num.length(); i++) {
            String l = num.substring(0, i + 1);
            String r = num.substring(i + 1);
            int leftNum = Integer.parseInt(l);
            if (canPartition(r, target - leftNum)) return true;
        }
        return false;
    }

    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int mul = i * i;
            if (canPartition(Integer.toString(mul), i)) res += mul;
        }
        return res;
    }
}
