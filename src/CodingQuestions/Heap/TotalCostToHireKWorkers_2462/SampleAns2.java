package CodingQuestions.Heap.TotalCostToHireKWorkers_2462;

import java.util.PriorityQueue;

public class SampleAns2 {
    public static void main(String[] args) {

    }
    public long totalCost(int[] costs, int k, int candidates) {
        int i = 0, j = costs.length -1;
        PriorityQueue<Integer> forward = new PriorityQueue();
        PriorityQueue<Integer> backward = new PriorityQueue();
        long ans = 0;

        while (k-- > 0) {
            while (forward.size() < candidates && i <= j) {
                forward.offer(costs[i++]);
            }
            while (backward.size() < candidates && i <= j) {
                backward.offer(costs[j--]);
            }
            int t1 = forward.size() > 0 ? forward.peek() : Integer.MAX_VALUE;
            int t2 = backward.size() > 0 ? backward.peek() : Integer.MAX_VALUE;

            if (t1 <= t2) {
                ans += t1;
                forward.poll();
            } else {
                ans += t2;
                backward.poll();
            }
        }
        return ans;
    }
}
