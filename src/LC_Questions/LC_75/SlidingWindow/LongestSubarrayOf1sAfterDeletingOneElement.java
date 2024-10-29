package LC_Questions.LC_75.SlidingWindow;

/***
 * Given a binary array nums, you should delete one element from it.
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 Example 1:
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 Example 2:
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 Example 3:
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 */
public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int index = 0, count = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count += 1;
            }
            while(count > 1) {
                if(nums[index] == 0) {
                    count -= 1;
                }
                index++;
            }
            ans = Math.max(ans,i-index);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubarrayOf1sAfterDeletingOneElement l = new LongestSubarrayOf1sAfterDeletingOneElement();
        int [] nums = {1,1,0,0,1,1,1,0,1};
        System.out.println(l.longestSubarray(nums));
    }
}
