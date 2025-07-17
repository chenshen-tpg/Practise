package CodingQuestions.OOP.PremiumAlgo100.FirstUniqueNumber_1429;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class TEST {
    private Queue<Integer> queue = new ArrayDeque<>();
    private Map<Integer, Boolean> hm = new HashMap<>();

    public TEST(int[] nums) {
        for (int num : nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && !hm.get(queue.peek())) {
            queue.remove();
        }
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return -1;
    }

    public void add(int value) {

        if (!hm.containsKey(value)) {
            hm.put(value, true);
            queue.add(value);
        } else {
            hm.put(value, false);
        }
    }
}
