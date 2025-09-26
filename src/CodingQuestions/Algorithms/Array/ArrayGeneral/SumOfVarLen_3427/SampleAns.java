package CodingQuestions.Algorithms.Array.ArrayGeneral.SumOfVarLen_3427;

public class SampleAns {
    public static void main(String[] args) {
        int [] nums = {2,3,1};
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = Math.max(0, i-nums[i]); j <= i; j++) {
                temp += nums[j];
            }
            ans += temp;
        }
        System.out.println(ans);

    }
}
