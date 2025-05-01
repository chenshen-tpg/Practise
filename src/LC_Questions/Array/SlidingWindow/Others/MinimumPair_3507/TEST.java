package LC_Questions.Array.SlidingWindow.Others.MinimumPair_3507;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.minimumPairRemoval(new int[]{5, 2, 3, 1});
    }

    public int minimumPairRemoval(int[] nums) {
        int length = nums.length - 1, count = 0;
        while (length > 0) {
            boolean increase = true;
            int minSum = Integer.MAX_VALUE, minIndex = -1;
            for (int i = 0; i < length; i++) {
                if (nums[i] > nums[i + 1]) increase = false;
                if (nums[i] + nums[i + 1] < minSum) {
                    minSum = nums[i] + nums[i + 1];
                    minIndex = i;
                }
            }
            if (increase) break;
            nums[minIndex] = minSum;
            for (int i = minIndex + 1; i < length; i++) nums[i] = nums[i + 1];
            length--;
            count++;
        }
        return count;
    }
}
