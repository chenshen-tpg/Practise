package CodingQuestions.DP.LC75.MinCostClimbgingStairs_746;

public class SampleAns2 {
    public static void main(String[] args) {

    }
    public int minCostClimbingStairs(int[] cost) {
        int [] memo = new int [cost.length + 1];
        for (int i = 2; i < memo.length; i++) {
            int one = cost[i-1] + memo[i-1];
            int two = cost[i-2] + memo[i-2];
            memo[i] = Math.min(one, two);
        }
        return memo[memo.length - 1];
    }
}
