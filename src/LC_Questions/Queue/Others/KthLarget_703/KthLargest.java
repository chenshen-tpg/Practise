package LC_Questions.Queue.Others.KthLarget_703;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> pq;
    int size;

    public static void main(String[] args) {
        String[] operations = {"KthLargest", "add", "add", "add", "add", "add"};
        Object[][] inputs = {
                {3, new int[]{4, 5, 8, 2}},
                {3},
                {5},
                {10},
                {9},
                {4}
        };

        KthLargest kthLargest = null;

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "KthLargest":
                    int k = (int) inputs[i][0];
                    int[] nums = (int[]) inputs[i][1];
                    kthLargest = new KthLargest(k, nums);
                    System.out.println("KthLargest initialized");
                    break;
                case "add":
                    int val = (int) inputs[i][0];
                    System.out.println("add(" + val + ") -> " + kthLargest.add(val));
                    break;
            }
        }
    }

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue();
        size = k;
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        while (pq.size() > k) {
            pq.poll();
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > size) {
            pq.poll();
        }
        return pq.peek();
    }
}
