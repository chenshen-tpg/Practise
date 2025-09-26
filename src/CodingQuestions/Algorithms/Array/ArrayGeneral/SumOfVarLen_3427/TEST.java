package CodingQuestions.Algorithms.Array.ArrayGeneral.SumOfVarLen_3427;

public class TEST {
    public static void main(String[] args) {

    }
    public int subarraySum(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = Math.max(0, i - nums[i]); j <= i; j++) {
                sum += nums[j];
            }
            ans += sum;
        }
        return ans;
    }
}
