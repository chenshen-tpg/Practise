package CodingQuestions.Hash.AllOneDataStructure_432;

import CodingQuestions.Lib.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class HashMapAndSet {
    private Map<String, Integer> count;
    private TreeSet<Pair<Integer, String>> set;

    public static void main(String[] args) {

    }
    public HashMapAndSet() {
        count = new HashMap<>();
        set = new TreeSet<>((a, b) -> a.getKey().equals(b.getKey()) ? a.getValue().compareTo(b.getValue()) : a.getKey().compareTo(b.getKey()));
    }

    public void inc(String key) {
        int n = count.getOrDefault(key , 0);
        count.put(key, n + 1);
        set.remove(new Pair<>(n, key));
        set.add(new Pair<>(n + 1, key));
    }

    public void dec(String key) {
        int n = count.get(key);
        set.remove(new Pair<>(n, key));
        if (n == 1) {
            count.remove(key);
        } else {
            count.put(key, n - 1);
            set.add(new Pair<>(n - 1, key));
        }
    }

    public String getMaxKey() {
        return set.isEmpty() ? "" : set.last().getValue();
    }

    public String getMinKey() {
        return set.isEmpty()? "" : set.first().getValue();
    }
}
