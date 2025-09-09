package CodingQuestions.Algorithms.Hash.MaxEarserValue_1695;

import java.util.HashSet;

public class SampleAnswer {
    public static void main(String[] args) {

    }
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        int sum = 0;
        int j = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (hs.contains(nums[i])) {
                hs.remove(nums[j]);
                sum -= nums[j];
                j++;
            }
            sum += nums[i];
            hs.add(nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
}
