package CodingQuestions.DP.SovlingQuestionsWithSkip_2140;

public class DPsolution {
    public static void main(String[] args) {

    }
    public long mostPoints(int[][] questions) {
        long [] memo = new long [questions.length];
        memo[questions.length - 1] = questions[questions.length-1][0];
        for (int i = questions.length - 2; i >= 0; i--) {
            memo[i] = questions[i][0];
            int skip = questions[i][1];
            if (i + skip + 1 < questions.length) memo[i] += memo[i + skip + 1];
            memo[i] = Math.max(memo[i], memo[i + 1]);
        }
        return memo[0];
    }
}
