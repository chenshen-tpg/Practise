package CodingQuestions.Heap.FindSubSequence_2099;

import java.util.PriorityQueue;

public class PQSolution {
    public static void main(String[] args) {
        maxSubsequence(new int [] {2,1,3,3},2);
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int res[] = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        PriorityQueue<int[]> maxSum = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < k; i++) {
            maxSum.offer(pq.poll());
        }
        for (int i = 0; i < k; i++) {
            res[i] = maxSum.poll()[0];
        }
        return res;
    }
}
