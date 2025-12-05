package CodingQuestions.Algorithms.Array.ArrayGeneral.CountPartitionWithEvenSumDiff_3432;

public class InitialAttemp {
    public static void main(String[] args) {

    }
    public int countPartitions(int[] nums) {
        int curadd = 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curadd += nums[i];
            int curleft= 0;
            for (int j = i + 1; j < nums.length; j++) {
                curleft += nums[j];
            }
            if (Math.abs(curadd-curleft) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
