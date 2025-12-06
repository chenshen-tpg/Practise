package CodingQuestions.Algorithms.Array.ArrayGeneral.CountPartitionWithEvenSumDiff_3432;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.countPartitions(new int [] {10,10,3,7,6});
    }
    public int countPartitions(int[] nums) {
        int ans = 0;
        int [] forward = new int [nums.length];
        forward[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            forward[i] = nums[i] + forward[i+1];
        }
        int cur = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            cur += nums[i];
            if ((nums[i] - forward[i + 1]) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
