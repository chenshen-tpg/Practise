package LC_Questions.LinkedList.Others.LRUcache_146;

import java.util.LinkedHashMap;
import java.util.Map;

public class TEST {
    LinkedHashMap<Integer, Integer> lru;
    int capacity;

    public static void main(String[] args) {
        TEST lruCache = new TEST(2);
        lruCache.put(1, 1); // Cache: {1=1}
        lruCache.put(2, 2); // Cache: {1=1, 2=2}
        System.out.println(lruCache.get(1)); // Output: 1, Cache: {2=2, 1=1}
        lruCache.put(3, 3); // Cache: {1=1, 3=3} (2 is evicted)
        System.out.println(lruCache.get(2)); // Output: -1 (not found)
        lruCache.put(4, 4); // Cache: {3=3, 4=4} (1 is evicted)
        System.out.println(lruCache.get(1)); // Output: -1 (not found)
        System.out.println(lruCache.get(3)); // Output: 3, Cache: {4=4, 3=3}
        System.out.println(lruCache.get(4)); // Output: 4, Cache: {3=3, 4=4}
    }
    public TEST(int capacity) {
        lru = new LinkedHashMap();
        this.capacity = capacity;
    }
    public int get(int key) {
        int val = lru.getOrDefault(key, -1);
        if (val == -1) {return - 1;}
        else {
            lru.remove(key);
            lru.put(key, val);
        }
        return val;
    }

    public void put(int key, int value) {
        if (lru.get(key) == null) {
            lru.put(key, value);
        } else {
            lru.remove(key);
            lru.put(key, value);
        }
        if (lru.size() > capacity) {
            Map.Entry<Integer, Integer> entry = lru.entrySet().iterator().next();
            lru.remove(entry.getKey());
        }
    }
}
