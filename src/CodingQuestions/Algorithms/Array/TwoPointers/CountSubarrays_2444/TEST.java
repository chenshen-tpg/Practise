package CodingQuestions.Algorithms.Array.TwoPointers.CountSubarrays_2444;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.countSubarrays(new int [] {1,3,5,2,7,5}, 1, 5);
    }
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long answer = 0;
        int minPosition = -1, maxPosition = -1, leftBound = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) leftBound = i;
            if (nums[i] == minK) minPosition = i;
            if (nums[i] == maxK) maxPosition = i;
            answer += Math.max(0, Math.min(maxPosition, minPosition) - leftBound);
        }
        return answer;
    }
}
