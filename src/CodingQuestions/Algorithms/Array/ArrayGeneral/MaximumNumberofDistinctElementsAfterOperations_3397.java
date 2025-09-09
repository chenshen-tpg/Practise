package CodingQuestions.Algorithms.Array.ArrayGeneral;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumNumberofDistinctElementsAfterOperations_3397 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4};
        int k = 2;
        MaximumNumberofDistinctElementsAfterOperations_3397 obj = new MaximumNumberofDistinctElementsAfterOperations_3397();
        System.out.println(obj.maxDistinctElements(nums, k));
    }

    public int maxDistinctElements(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0, last = Integer.MIN_VALUE; i < nums.length; i++) {
            int mn = nums[i] - k;
            int mx = nums[i] + k;
            if (last < mn) {
                last = mn;
                ans++;
            }
            else if (last < mx) {
                last++;
                ans++;
            }
        }
        return ans;
    }
    public int maxDistinctElementsNEXT(int[] arr, int diff) {
        int prev = Integer.MIN_VALUE;
        Set<Integer> ans = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int selectNum = Math.max(prev + 1, arr[i] - diff);
            if (selectNum <= arr[i] + diff) {
                prev = selectNum;
                ans.add(selectNum);
            }
        }

        return ans.size();
    }
}
