package CodingQuestions.Math.Others.KthMissingNum_1539;

public class TEST {
    public static void main(String[] args) {
        findKthPositive(new int [] {2,3,4,7,11},5);
    }

    public static int findKthPositive(int[] arr, int k) {
        int [] memo = new int [1000];
        for (int a : arr) {
            memo[a]++;
        }
        for (int i = 1; i <= 1000; i++) {
            if (memo[i] == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        return 0;
    }
}
