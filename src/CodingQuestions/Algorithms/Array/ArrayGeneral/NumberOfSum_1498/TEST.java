package CodingQuestions.Algorithms.Array.ArrayGeneral.NumberOfSum_1498;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        numSubseq(new int [] {2,3,3,4,6,7}, 12);
    }
    public static int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        int answer = 0;
        int left = 0, right = n - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                answer += power[right - left];
                answer %= mod;
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }
}
