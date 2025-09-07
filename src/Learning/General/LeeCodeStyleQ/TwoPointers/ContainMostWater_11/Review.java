package Learning.General.LeeCodeStyleQ.TwoPointers.ContainMostWater_11;

public class Review {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int currentMax = 0;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int currentArea = width * height;

            currentMax = Math.max(currentMax, currentArea);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return currentMax;
    }
}
