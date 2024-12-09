package LC_Questions.LC_75.SlidingWindow;


public class LongestSubarrayOf1sAfterDeletingOneElement_1004_med {

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

    public static void main(String[] args) {
        LongestSubarrayOf1sAfterDeletingOneElement_1004_med l = new LongestSubarrayOf1sAfterDeletingOneElement_1004_med();
        int [] nums = {1,1,0,0,0,1,1,1,0,1};
        int k = 2;
        System.out.println(l.longestOnesMySolutionTEL(nums, k));
    }
}
