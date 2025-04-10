package LC_Questions.Array.BackTracking.Others.NumberOfSubArrayWithOddSum_1524;

public class DP {
    public static void main(String[] args) {
        numOfSubarrays(new int [] {1,3,5});
        System.out.println("Done");
    }
    public static int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        for (int num = 0; num < n; num++) arr[num] %= 2;
        int[] dpEven = new int[n], dpOdd = new int[n];
        if (arr[n - 1] == 0) dpEven[n - 1] = 1;
        else dpOdd[n - 1] = 1;
        for (int num = n - 2; num >= 0; num--) {
            if (arr[num] == 1) {
                dpOdd[num] = (1 + dpEven[num + 1]) % MOD;
                dpEven[num] = dpOdd[num + 1];
            } else {
                dpEven[num] = (1 + dpEven[num + 1]) % MOD;
                dpOdd[num] = dpOdd[num + 1];
            }
        }
        int count = 0;
        for (int oddCount : dpOdd) {
            count += oddCount;
            count %= MOD;
        }
        return count;
    }
}
