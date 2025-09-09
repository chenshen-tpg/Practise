package CodingQuestions.Algorithms.Math.FindNUnique_1304;

public class SampleAns {
    public static void main(String[] args) {
        SampleAns solution = new SampleAns();
        solution.sumZero(5);
    }
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int index = 0;
        for (int i = 1; i <= n / 2; ++i) {
            ans[index++] = i;
            ans[index++] = -i;
        }
        if (n % 2 == 1) {
            ans[index] = 0;
        }
        return ans;
    }
}
