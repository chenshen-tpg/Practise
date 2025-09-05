
package Preparation.General.LeeCodeStyleQ.SlidingWindow.MaxDistinctSubArrays_2461;


import java.util.HashMap;

public class SampleAns {

    public static void main(String[] args) {
        SampleAns solution = new SampleAns();
        solution.maxSum(new int [] {1,1,1,7,8,9}, 3);
    }

    public long maxSum(int[] nums, int k) {
        long max = 0;
        int j = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        long currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            if (i - j + 1 == k) {
                if (hm.size() == k) {
                    max = Math.max(max, currentSum);
                }
                currentSum -= nums[j];
                hm.put(nums[j], hm.get(nums[j]) - 1);
                if (hm.get(nums[j]) == 0) {
                    hm.remove(nums[j]);
                }
                j++;
            }
        }
        return max;
    }
}
