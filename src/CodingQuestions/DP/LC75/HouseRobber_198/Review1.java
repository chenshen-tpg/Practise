package CodingQuestions.DP.LC75.HouseRobber_198;

public class Review1 {
    public static void main(String[] args) {

    }

    public int helper (int [] arr) {
        int [] memo = new int [arr.length];
        memo[0] = arr[0];
        memo[1] = arr[1];
        for (int i = 2; i < arr.length; i++) {
            memo[i] = Math.max(memo[i-1], memo[i-2] + arr[i]);
        }
        return memo[arr.length -1];
    }
}
