package CodingQuestions.Heap.KthLargestElementInAnArray_215;

import java.util.PriorityQueue;

public class PQMeTrying {
    public static void main(String[] args) {
        PQMeTrying k = new PQMeTrying();
        int [] nums = {3,2,1,5,6,4};
        int k1 = 2;
        System.out.println(k.helper(nums,k1));
    }

    public int helper(int [] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b- a);
        for (Integer num : nums) {
            pq.add(num);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.poll();
    }
}
