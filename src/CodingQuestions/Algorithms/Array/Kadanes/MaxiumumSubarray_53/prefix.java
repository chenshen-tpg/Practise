package CodingQuestions.Algorithms.Array.Kadanes.MaxiumumSubarray_53;

public class prefix {
    public static void main(String[] args) {

        System.out.println(helper(new int [] {-2,1,-3,4,-1,2,1,-5,4}));

    }
    public static int helper (int [] nums){
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSubarray = Math.max(nums[i], currentSubarray + nums[i]);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        return maxSubarray;
    }
}
