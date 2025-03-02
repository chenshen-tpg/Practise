package LC_Questions.SlidingWindow.LC75.LongestSubarrayOf1sAfterDeletingOneElement_1493;


public class ModelAnswer {
    public static void main(String[] args) {
        ModelAnswer solution = new ModelAnswer();
        int [] nums = {1,1,0,0,0,1,1,1,0,1};
        int k = 2;
        System.out.println(solution.longestSubarray(nums, k));
    }
    public int longestSubarray(int[] nums, int k) {
        int index = 0, count = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count += 1;
            }
            while(count > k) {
                if (nums[index] == 0) {
                    count -= 1;
                }
                index++;
            }
            ans = Math.max(ans,i - index);
        }
        return ans;
    }



}
