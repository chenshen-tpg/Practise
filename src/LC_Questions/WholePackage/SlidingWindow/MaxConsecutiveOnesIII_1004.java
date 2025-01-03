package LC_Questions.WholePackage.SlidingWindow;

public class MaxConsecutiveOnesIII_1004 {
    public static void main(String[] args) {
        MaxConsecutiveOnesIII_1004 m = new MaxConsecutiveOnesIII_1004();
        int[] nums = {1,1,0,0,0,1,1,1,0,1};
        int k = 2;
        System.out.println(m.correct(nums, k));
    }

    private int longestOnesMySolutionTEL(int[] nums, int k) {
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
    public int correct(int [] nums, int k) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                k--;
            }
            if (k < 0) {
                k += 1 - nums[l];
            }
            l++;
        }
        return r - l;
    }
}
