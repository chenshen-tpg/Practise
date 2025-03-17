package LC_Questions.BinarySearch.Others.ZeroArrayTransformationII_3356;

import java.util.Arrays;

public class Npass {


    public static void main(String[] args) {
        Npass npass = new Npass();
        int[] nums = {2, 0, 2};
        int[][] queries = {
                {0, 2, 1},
                {0, 2, 1},
                {1, 1, 3}
        };
        int result = npass.minZeroArray(nums, queries);
        System.out.println("Minimum number of operations: " + result);
        // Expected output: Minimum number of operations: 2
    }

    public int minZeroArray(int[] nums, int[][] queries) {
//        boolean allZeros = true;
//        for (int num : nums) {
//            if (num != 0) {
//                allZeros = false;
//                break;
//            }
//        }
//        if (allZeros) {
//            return 0;
//        }
        if (Arrays.stream(nums).allMatch(x -> x == 0)) return 0;
        int left = 1, right = queries.length;
        if (!canMakeZeroArray(right, nums, queries)) return -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMakeZeroArray(mid, nums, queries)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean canMakeZeroArray(int k, int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int left = queries[i][0], right = queries[i][1], val = queries[i][2];
            diff[left] += val;
            diff[right + 1] -= val;
        }
        int currVal = 0;
        for (int i = 0; i < n; i++) {
            currVal += diff[i];
            if (currVal < nums[i]) return false;
        }
        return true;
    }
}
