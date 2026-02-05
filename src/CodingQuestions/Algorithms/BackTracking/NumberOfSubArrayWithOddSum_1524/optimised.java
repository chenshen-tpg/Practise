package CodingQuestions.Algorithms.BackTracking.NumberOfSubArrayWithOddSum_1524;

public class optimised {
    public static void main(String[] args) {
        numOfSubarrays(new int [] {1,3,5});
        System.out.println("Done");
    }

    public static int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int count = 0, prefixSum = 0;
        int oddCount = 0, evenCount = 1;
        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                count += oddCount;
                evenCount++;
            } else {
                count += evenCount;
                oddCount++;
            }
            count %= MOD;
        }
        return count;
    }
}
