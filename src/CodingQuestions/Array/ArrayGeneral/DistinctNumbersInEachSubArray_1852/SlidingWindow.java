package CodingQuestions.Array.ArrayGeneral.DistinctNumbersInEachSubArray_1852;

import java.util.HashMap;

public class SlidingWindow {
    public static void main(String[] args) {
        int [] nums = {1,2,3,2,2,1,3};
        int k = 3;
        int [] res = helper(nums,k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int [] helper (int [] nums, int k) {
        int [] res = new int [nums.length - k + 1];
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < k; i++) {
           hm.put(nums[i], hm.getOrDefault(nums[i],0) + 1);
           if (hm.get(nums[i]) ==  1) count++;
        }
        res[0] = count;
        for (int i = k; i < nums.length; i++) {
            int left = nums[i - k];
            hm.put(left, hm.get(left) - 1);
            if (hm.get(left) == 0) count--;
            hm.put(nums[i], hm.getOrDefault(nums[i],0) + 1);
            if (hm.get(nums[i]) == 1) count++;
            res[i - k + 1] = count;
        }
        return res;
    }
}
