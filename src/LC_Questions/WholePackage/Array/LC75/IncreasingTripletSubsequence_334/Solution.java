package LC_Questions.WholePackage.Array.LC75.IncreasingTripletSubsequence_334;

public class Solution {
    public static void main(String[] args) {
        Solution it = new Solution();
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(it.increasingTriplet(nums));
    }
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= first) {
                first = nums[i];
            }else if (nums[i] <= second) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
