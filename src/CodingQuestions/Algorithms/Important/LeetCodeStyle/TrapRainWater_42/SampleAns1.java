package CodingQuestions.Algorithms.Important.LeetCodeStyle.TrapRainWater_42;

public class SampleAns1 {
    public static void main(String[] args) {

    }

    public int trap(int[] h) {
        int n = h.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = h[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], h[i]);
        }

        rightMax[n - 1] = h[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], h[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - h[i];
        }
        return ans;
    }
}
