package LC_Questions.WholePackage.TwoPointers.LC75;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        ContainerWithMostWater_11 cw = new ContainerWithMostWater_11();
        System.out.println(cw.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    private int maxArea(int[] height) {

            int left = 0, right = height.length - 1;
            int max = 0;
            while (left < right) {
                max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
                if (height[left] < height[right]) left++;
                else right--;
            }
            return max;

    }
}
