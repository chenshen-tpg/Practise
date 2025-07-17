package CodingQuestions.Array.Prefix.Others.ZeroArrayTrans_3355;

public class TLE {

    public static void main(String[] args) {

    }


    public boolean isZeroArray(int[] nums, int[][] queries) {
        int [] memo = new int [nums.length];
        for (int [] query : queries) {
            int start = query[0], end = query[1];
            while (start <= end) {
                nums[start]--;
                start++;
            }
        }
        for (int num : nums) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }
}
