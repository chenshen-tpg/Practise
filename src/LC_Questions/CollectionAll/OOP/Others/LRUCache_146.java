package LC_Questions.CollectionAll.OOP.Others;

import java.util.LinkedHashMap;

public class LRUCache_146 {
    private LinkedHashMap<Integer, Integer> map;
    private int size;

    public static void main(String[] args) {
            LRUCache_146 cache = new LRUCache_146(2);
            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println(cache.get(1)); // returns 1
            cache.put(3, 3); // evicts key 2
            System.out.println(cache.get(2)); // returns -1 (not found)
            cache.put(4, 4); // evicts key 1
            System.out.println(cache.get(1)); // returns -1 (not found)
            System.out.println(cache.get(3)); // returns 3
            System.out.println(cache.get(4)); // returns 4
    }
    public LRUCache_146(int capacity) {
        map = new LinkedHashMap<>();
        size = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() + 1 > size) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }
}
