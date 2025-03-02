package LC_Questions.DP.LC75.MinCostClimbgingStairs_746;

public class MinCostClimbingStairs_746 {
    public static void main(String[] args) {
        int [] cost = {1,100,1,1,1,100,1,1,100,1};
        MinCostClimbingStairs_746 solution = new MinCostClimbingStairs_746();
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
