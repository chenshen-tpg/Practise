package CodingQuestions.Math.KthMissingNum_1539;

public class ModelAns {
    public static void main(String[] args) {

    }

    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int ans = 0;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int a = arr[mid] - (mid + 1);
            if (a < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high + 1 + k;
    }
}
