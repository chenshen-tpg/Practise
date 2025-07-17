package CodingQuestions.DP.LC75.NthTribonacci_1137;

public class NthTribonacciNumber_1137 {
    public static void main(String[] args) {
        NthTribonacciNumber_1137 solution = new NthTribonacciNumber_1137();
        System.out.println(solution.helper(25));
    }

    public int helper (int n) {
        if (n == 0) return 0;
        if (n== 1 || n == 2) return 1;
        int [] memo = new int [n + 1];
        memo [0] = 0;
        memo [1] = 1;
        memo [2] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i] += memo[i-1] + memo [i-2] + memo [i-3];
        }
        return memo[n];
    }
}
