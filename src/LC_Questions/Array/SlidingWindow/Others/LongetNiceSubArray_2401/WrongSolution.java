package LC_Questions.Array.SlidingWindow.Others.LongetNiceSubArray_2401;

public class WrongSolution {
    public static void main(String[] args) {
       int [] nums = {1,3,8,48,10};
        int count = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] & nums[i - 1]) == 0) {
                count++;
            } else {
                count = 0;
            }
            res = Math.max(res, count);
        }
        System.out.println(res);
    }
}
