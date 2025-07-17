package CodingQuestions.Hash.Others.MaxSumOfAPairWithEqualSumOfDigits_2342;

public class preFix {
    public static void main(String[] args) {
        int [] nums = {18,43,36,13,7};
        maximumSum(nums);
    }
    public static int maximumSum(int[] nums) {
        int[] max = new int[82];
        int ans = -1;
        for (int x : nums) {
            int sum = 0;
            int temp = x;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (max[sum] != 0) {
                ans = Math.max(ans, x + max[sum]);
            }
            max[sum] = Math.max(max[sum], x);
        }
        return ans;
    }
}
