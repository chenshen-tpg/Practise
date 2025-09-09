package CodingQuestions.Algorithms.Heap.KthLargestElementInAnArray_215;

import java.util.PriorityQueue;

public class PQ {
    public static void main(String[] args) {
        PQ k = new PQ();
        int [] nums = {3,2,3,1,2,4,5,5,6};
        int k1 = 4;
        System.out.println(k.helper(nums,k1));
    }

    public int helper(int [] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue();
        for (int num:nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        return heap.peek();
    }
}
