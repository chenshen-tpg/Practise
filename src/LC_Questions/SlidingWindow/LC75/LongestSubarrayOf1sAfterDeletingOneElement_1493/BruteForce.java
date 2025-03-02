package LC_Questions.SlidingWindow.LC75.LongestSubarrayOf1sAfterDeletingOneElement_1493;

public class BruteForce {
    public static void main(String[] args) {

    }
    public int longestOnesMySolutionTEL(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0, cur = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    if(temp == k) {
                        break;
                    }
                    temp++;
                    cur++;
                } else {
                    cur++;
                }
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
