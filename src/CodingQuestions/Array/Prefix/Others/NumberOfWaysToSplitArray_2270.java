package CodingQuestions.Array.Prefix.Others;

public class NumberOfWaysToSplitArray_2270 {
    public static void main(String[] args) {
        int [] arr = {10,4,-8,7};
        System.out.println(helper(arr));
    }
    public int waysToSplitArray(int[] arr) {
        if (arr.length == 1 || arr.length == 0) return 0;
        if (arr.length == 2) return arr[0] >= arr[1] ? 1 : 0;
        int ans = 0;
        int left = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            left += arr[i];
            int right = 0;
            for (int j = i + 1; j < arr.length; j++) {
                right += arr[j];
            }
            if (left >= right) {
                ans++;
            }
        }
        return ans;
    }
    public static int helper (int [] arr) {
        int ans = 0;
        if (arr.length == 1 || arr.length == 0) return 0;
        if (arr.length == 2) return arr[0] >= arr[1] ? 1 : 0;
        int [] prefSum = new int [arr.length];
        prefSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefSum[i] = prefSum[i - 1] + arr[i];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            long leftSum = prefSum[i];
            long rightSum = prefSum[arr.length - 1] - prefSum[i];
            if (leftSum >= rightSum) ans++;
        }
        return ans;
    }
}
