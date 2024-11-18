package LC_Questions.LC_75.ArrayString;

public class IncreasingTripletSubsequence_334_med {
    public static void main(String[] args) {
        IncreasingTripletSubsequence_334_med it = new IncreasingTripletSubsequence_334_med();
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
