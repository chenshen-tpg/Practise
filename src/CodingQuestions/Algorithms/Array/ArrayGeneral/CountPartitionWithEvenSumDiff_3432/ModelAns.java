package CodingQuestions.Algorithms.Array.ArrayGeneral.CountPartitionWithEvenSumDiff_3432;

public class ModelAns {
    public static void main(String[] args) {

    }
    public int countPartitions(int[] nums) {
        int cnt = 0;
        for(int j = 1; j < nums.length ; ++j){
            nums[j] += nums[j-1];
        }
        int sum = nums[nums.length - 1];
        for(int j = 0 ; j < nums.length - 1 ; ++j){
            int diff = sum - 2 * nums[j];
            if (diff % 2 == 0) {
                ++cnt;
            }
        }
        return cnt;
    }
}
