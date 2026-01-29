package CodingQuestions.Algorithms.Array.ArrayGeneral.MaximumDistinceEle_3397;

import java.util.Arrays;

/***
 *
 * Given an array of integers and an integer ( k ),
 * select as many distinct integers as possible such that for each selected integer ( x ),
 * there exists an element in the array within the range ([x - k, x + k]),
 * and no two selected integers are the same
 * return the maximum number of such distinct integers you can select.
 */
public class LinearSolution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4};
        int k = 2;
        LinearSolution obj = new LinearSolution();
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

}
