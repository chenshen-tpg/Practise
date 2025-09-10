package Preparation.Specific.Nasdaq.Programming.LeetCodeLike.TrapRainWater_42;

public class SampleAns {
    public static void main(String[] args) {

    }
    public int trap(int[] height) {
        int max = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = 0;
            for (int j = i; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }
            int right = 0;
            for (int j =i; j < height.length; j++){
                right = Math.max(right, height[j]);
            }
            max += Math.min(left, right) - height[i];
        }
        return max;
    }
}
