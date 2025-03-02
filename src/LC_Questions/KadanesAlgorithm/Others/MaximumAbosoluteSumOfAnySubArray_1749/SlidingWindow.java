package LC_Questions.KadanesAlgorithm.Others.MaximumAbosoluteSumOfAnySubArray_1749;

public class SlidingWindow {
    public static void main(String[] args) {
        SlidingWindow solution = new SlidingWindow();
        System.out.println(solution.helper(new int [] {1, -3, 2, 3, -4}));
    }
    public int helper (int [] arr) {
        int maxSoFar = arr[0];
        int currentMax = arr[0];
        int minSoFar = arr[0];
        int currentMin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minSoFar = Math.min(minSoFar, currentMin);
        }
        return Math.max(Math.abs(maxSoFar), Math.abs(minSoFar));
    }
}
