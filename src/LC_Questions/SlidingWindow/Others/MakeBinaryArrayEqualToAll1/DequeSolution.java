package LC_Questions.SlidingWindow.Others.MakeBinaryArrayEqualToAll1;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeSolution {
    public static void main(String[] args) {
        int [] test = {0,1,1,1,0,0};
        DequeSolution solution = new DequeSolution();
        solution.minOperations(test);
    }
    public int minOperations(int[] nums) {
        Deque<Integer> q = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && i > q.peekFirst() + 2) q.pollFirst();
            if ((nums[i] + q.size()) % 2 == 0) {
                if (i + 2 >= nums.length) {
                    return -1;
                }
                count++;
                q.offerLast(i);
            }
        }
        return count;
    }
}
