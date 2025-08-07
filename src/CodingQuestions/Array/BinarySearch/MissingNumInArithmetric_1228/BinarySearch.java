package CodingQuestions.Array.BinarySearch.MissingNumInArithmetric_1228;

public class BinarySearch {
    public static void main(String[] args) {

    }

    public int missingNumber(int arr[]) {
        int n = arr.length;
        int difference = (arr[n - 1] - arr[0]) / n;
        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == arr[0] + mid * difference) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return arr[0] + difference * lo;
    }
}
