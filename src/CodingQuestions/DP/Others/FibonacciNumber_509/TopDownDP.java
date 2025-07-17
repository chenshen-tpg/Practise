package CodingQuestions.DP.Others.FibonacciNumber_509;

public class TopDownDP {
    private static int[] memo;

    public static void main(String[] args) {
        int n = 10;
        memo = new int[n + 1];
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }
}