package LC_Questions.ContestQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumPositiveSumSubarray_3364 {
    public static void main(String[] args) {
        MinimumPositiveSumSubarray_3364 mps = new MinimumPositiveSumSubarray_3364();

        List<Integer> nums1 = Arrays.asList(3, -2, 1, 4);
        int l1 = 2, r1 = 3;
        System.out.println(mps.helper(nums1, l1, r1));
    }
    public int helper(List<Integer> nums, int l, int r) {
        int res = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            for (int j = 0; j <= nums.size() - i; j++) {
                int temp = 0;
                for (int k = j; k < j + i; k++) {
                    temp += nums.get(k);
                }
                if (temp > 0) res = Math.min(res, temp);

            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }











    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int size = nums.size(), res = -1;
        for (int s = l; s <= r; s++) {
            for (int i = 0; i <= size - s; i++) {
                int sum = 0;
                for (int j = i; j < i + s; j++) {
                    sum += nums.get(j);
                }
                if (sum > 0) {
                    if (res == -1 || res > sum) res = sum;
                }
            }
        }
        return res;
    }
    public int minimumSumSubarray_PreSum(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] preSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums.get(i - 1);
        }

        int res = Integer.MAX_VALUE;

        for (int range = l; range <= r; range++) {
            for (int i = range; i <= n; i++) {
                int v = preSum[i] - preSum[i - range];
                if (v > 0) {
                    res = Math.min(res, v);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
