package LC_Questions.CollectionAll.KadanesAlgorithm.LC150.MaxiumumSubarray_53;

public class MaximumSubarray_53 {
    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSubarray = Math.max(nums[i], currentSubarray + nums[i]);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }

        System.out.println(maxSubarray);

    }

}
