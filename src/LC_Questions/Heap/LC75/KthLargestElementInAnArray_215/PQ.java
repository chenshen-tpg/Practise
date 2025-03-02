package LC_Questions.Heap.LC75.KthLargestElementInAnArray_215;

import java.util.PriorityQueue;

public class PQ {
    public static void main(String[] args) {
        PQMeTrying k = new PQMeTrying();
        int [] nums = {3,2,1,5,6,4};
        int k1 = 2;
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
