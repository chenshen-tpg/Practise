package LC_Questions.WholePackage.DP.LC150.ClibingStaris_70;

public class ClimbingStairs_70_easy {
    public static void main(String[] args) {
        ClimbingStairs_70_easy cs = new ClimbingStairs_70_easy();
        System.out.println(cs.climbStairs(3));
    }
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int [] dp = new int [n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
