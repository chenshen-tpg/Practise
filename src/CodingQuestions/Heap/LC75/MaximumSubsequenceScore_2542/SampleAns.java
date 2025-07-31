package CodingQuestions.Heap.LC75.MaximumSubsequenceScore_2542;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SampleAns {
    public static void main(String[] args) {
        int[] nums1 = {1,3,3,2};
        int[] nums2 = {2,1,3,4};
        int k = 3;
        maxScore(nums1,nums2,k);
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
        int[][] nums = new int[len][2];
        PriorityQueue<Integer> p = new PriorityQueue<>();
        long sum = 0, max = 0;
        for (int i = 0; i < len; i++) {
            nums[i][0] = nums2[i];
            nums[i][1] = nums1[i];
        }
        Arrays.sort(nums, (a, b) -> b[0] - a[0]);
        for (int j = 0; j < len; j++) {

            p.offer(nums[j][1]);
            sum += nums[j][1];

            if (p.size() > k) {
                sum -= p.poll();
            }

            if (p.size() == k) {
                max = Math.max(max, sum * nums[j][0]);
            }
        }

        return max;
    }
}
