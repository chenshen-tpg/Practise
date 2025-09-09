package CodingQuestions.Algorithms.DP.MinCostClimbgingStairs_746;

public class SampleAns1 {
    public static void main(String[] args) {
        int [] cost = {1,100,1,1,1,100,1,1,100,1};
        SampleAns1 solution = new SampleAns1();
        System.out.println(solution.minCostClimbingStairs(cost));
    }
    public int minCostClimbingStairs(int[] cost) {
        int [] memo = new int [cost.length + 1];
        for (int i = 2; i < cost.length; i++) {
            memo[i] = Math.min(cost[i-2] + memo[i-2],cost[i - 1] + memo [i - 1]);
        }
        return memo[memo.length - 1];
    }
}
