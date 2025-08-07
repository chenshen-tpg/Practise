package CodingQuestions.Math.CountPrime_204;

public class TEST {
    public static void main(String[] args) {

    }
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] nums = new boolean[n];
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (!nums[i]) {
                for (int j = i * i; j < n; j += i) {
                    nums[j] = true;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] == false) res++;
        }
        return res;
    }
}
