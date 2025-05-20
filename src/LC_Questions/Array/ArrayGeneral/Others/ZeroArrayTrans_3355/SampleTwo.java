package LC_Questions.Array.ArrayGeneral.Others.ZeroArrayTrans_3355;

public class SampleTwo {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] arr = new int[nums.length + 1];
        //add all queries in diff arr
        for (int[] q : queries) {
            arr[q[0]] += 1;
            arr[q[1] + 1] -= 1;
        }

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
