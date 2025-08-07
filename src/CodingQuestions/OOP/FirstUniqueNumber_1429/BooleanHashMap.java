package CodingQuestions.OOP.FirstUniqueNumber_1429;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class BooleanHashMap {
    private Set<Integer> q = new LinkedHashSet<>();
    private Map<Integer, Boolean> hm = new HashMap<>();

    public BooleanHashMap(int[] nums) {
        for (int num : nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        if (!q.isEmpty()) {
            return q.iterator().next();
        }
        return -1;
    }

    public void add(int value) {
        if (!hm.containsKey(value)) {
            hm.put(value, true);
            q.add(value);
        } else if (hm.get(value)) {
            hm.put(value, false);
            q.remove(value);
        }
    }

}
