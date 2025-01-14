package LC_Questions.WholePackage.SlidingWindow.LC75.LongestSubarrayOf1sAfterDeletingOneElement_1493;

public class MyTrying {
    public static void main(String[] args) {
        int [] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(method(nums));
    }
    public static int method (int [] nums) {
        int ans = 0, indexZero = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
            // seems like a standard solution to achieve finding two same value
            // instead of having something not reduce the count in the loop
            // if (count > 1) {
            //   while (nums[indexZero] !=0) {
            //     indexZero++;
            //   }
            //  count--
            // }
             while (count > 1) {
                if (nums[indexZero] == 0) count--;
                indexZero ++;
            }
            ans = Math.max(ans, i - indexZero);
        }
        return ans;
    }
}
