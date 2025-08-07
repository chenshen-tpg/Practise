package CodingQuestions.Queue.KthLarget_703;

import java.util.PriorityQueue;

public class SampleAnswer {
    private final int k;
    private final PriorityQueue<Integer> minHeap;

    public SampleAnswer(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k || minHeap.peek() < val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}
