package CodingQuestions.Algorithms.Array.ArrayGeneral.LongestBalancedSubarray_3719;

import java.util.Arrays;
import java.util.HashSet;

public class TEST {
    //You are given an integer array nums.
// A subarray is called balanced if the number of distinct even numbers in the
//subarray is equal to the number of distinct odd numbers.
// Return the length of the longest balanced subarray.
// Example 1:
// Input: nums = [2,5,4,3]
// Output: 4
// Explanation:
// The longest balanced subarray is [2, 5, 4, 3].
// It has 2 distinct even numbers [2, 4] and 2 distinct odd numbers [5, 3].
//Thus, the answer is 4.
// Example 2:
// Input: nums = [3,2,2,5,4]
// Output: 5
// Explanation:
// The longest balanced subarray is [3, 2, 2, 5, 4].
// It has 2 distinct even numbers [2, 4] and 2 distinct odd numbers [3, 5].
//Thus, the answer is 5.
// Example 3:
// Input: nums = [1,2,3,2]
// Output: 3
//
// Explanation:
// The longest balanced subarray is [2, 3, 2].
// It has 1 distinct even number [2] and 1 distinct odd number [3]. Thus, the
//answer is 3.
// Constraints:
// 1 <= nums.length <= 1500
// 1 <= nums[i] <= 10⁵

    public static void main(String[] args) {
        TEST solution = new TEST();
        int[] nums1 = {2, 5, 4, 3}; // Expected: 4
        System.out.println(solution.helper(nums1));
        // Test case 2: Repeated evens, balanced
        int[] nums2 = {3, 2, 2, 5, 4}; // Expected: 5
        System.out.println(solution.helper(nums2));
        // Test case 3: Only one balanced subarray
        int[] nums3 = {1, 2, 3, 2}; // Expected: 3
        System.out.println(solution.helper(nums3));
        // Test case 4: No balanced subarray
        int[] nums4 = {2, 2, 2, 2}; // Expected: 0
        System.out.println(solution.helper(nums4));
        // Test case 5: Multiple balanced subarrays
        int[] nums5 = {1, 2, 3, 4, 5, 6}; // Expected: 6
        System.out.println(solution.helper(nums5));
    }

    public int helper (int [] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j <= arr.length; j++) {
                int[] sub = Arrays.copyOfRange(arr, i, j);
                if (check(sub)) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
    public boolean check (int [] arr) {
        HashSet<Integer> hs = new HashSet<>();
        int even = 0, odd = 0;
        for (int a : arr) {
            hs.add(a);
        }
        for (int s : hs) {
            if (s % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return even == odd;
    }
}
