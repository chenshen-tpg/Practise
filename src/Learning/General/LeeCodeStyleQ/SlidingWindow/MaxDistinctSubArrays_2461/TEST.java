
package Learning.General.LeeCodeStyleQ.SlidingWindow.MaxDistinctSubArrays_2461;


import java.util.HashMap;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.maxSum(new int [] {1,1,1,7,8,9}, 3);
    }
    public Long maxSum(int[] nums, Integer k) {
        HashMap<Integer, Integer> hm = new HashMap();
        long temp = 0;

        // don't need to initialise the first window.
//        for (int i = 0; i < k; i++) {
//            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
//            temp += nums[i];
//        }
        long max = 0;
        int j = 0;
        for (int i = k; i < nums.length; i++) {
            if (hm.size() == k) {
                max = Math.max(max, temp);
            }
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            if (hm.get(nums[j]) == 1) {
                hm.remove(nums[j]);
            } else {
                hm.put(nums[j], hm.get(nums[j]) - 1);
            }
            temp -= nums[j];
            temp += nums[i];
            j++;
        }
        if (hm.size() == k) {
            max = Math.max(max, temp);
        }
        return max;
    }
}
