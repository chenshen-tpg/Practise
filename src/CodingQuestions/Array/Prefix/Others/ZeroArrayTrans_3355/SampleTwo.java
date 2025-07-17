package CodingQuestions.Array.Prefix.Others.ZeroArrayTrans_3355;

public class SampleTwo {
    public static void main(String[] args) {

    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] arr = new int[nums.length + 1];
        for (int[] q : queries) {
            arr[q[0]] += 1;
            arr[q[1] + 1] -= 1;
        }
        // The sum is to identify the correct position, from start to end + 1
        // within a range.

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += arr[i];
            arr[i] = sum;
            if (arr[i] < nums[i]) {
                return false;
            }
        }

        return true;
    }
}
