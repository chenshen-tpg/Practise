package CodingQuestions.Algorithms.Hard.TrappingRainwater_42;

public class FindLeftRightForEach {
    public static void main(String[] args) {

    }

    public int trap (int [] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int left = 0, right= 0;
            for (int j = i; j >= 0; j++) {
                left = Math.max(left, height[j]);
            }
            for (int j = 0; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }
            ans += Math.min(left, right) - height[i];
        }
        return ans;
    }
}
