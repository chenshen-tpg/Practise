package LC_Questions.WholePackage.Queue.LC100.SlidingWindowMaximum_329;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ModelAnswer {
    public static void main(String[] args) {
        int [] num = {1,3,-1,-3,5,3,6,7};
        int k = 3;
//        int [] num = {1,-1};
        maxSlidingWindow(num, k);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        res.add(nums[dq.peekFirst()]);

        for (int i = k; i < nums.length; i++) {
            if (dq.peekFirst() == i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            res.add(nums[dq.peekFirst()]);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
