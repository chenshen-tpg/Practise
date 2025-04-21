package LC_Questions.OOP.PremiumAlgo100.FirstUniqueNumber_1429;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class HashMapQueue {
    HashMap<Integer, Integer> hm = new HashMap();
    Queue<Integer> q = new LinkedList();
    public HashMapQueue(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
            hm.put(nums[i],hm.getOrDefault(nums[i], 0) + 1);
        }
    }

    public int showFirstUnique() {
        while (!q.isEmpty() && hm.get(q.peek()) > 1) q.remove();
        if (!q.isEmpty()) {
            return q.peek();
        }
        return -1;
    }

    public void add(int value) {
        if (!hm.containsKey(value)) q.add(value);
        hm.put(value,hm.getOrDefault(value, 0) + 1);
    }
}
