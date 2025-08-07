package CodingQuestions.Array.BackTracking.NumberOfSubArrayWithOddSum_1524;

import java.util.ArrayList;

public class bruteForce {

    static ArrayList<Integer> li = new ArrayList<>();
    public static void main(String[] args) {
        numOfSubarrays(new int [] {1,3,5});
        System.out.println("Done");
    }

    public static int numOfSubarrays(int[] arr) {
        final int MOD = (int) (1e9 + 7);
        int n = arr.length;
        int count = 0;
        for (int startIndex = 0; startIndex < n; startIndex++) {
            int currentSum = 0;
            for (int endIndex = startIndex; endIndex < n; endIndex++) {
                currentSum += arr[endIndex];
                if (currentSum % 2 != 0) {
                    count++;
                }
            }
        }
        return count % MOD;
    }
}
