package SystemDesignQuestions.Canava.LRU;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

/***
 Mechanism	Pros	Cons	Best Use Case
 synchronized	Simple, built-in	Coarse-grained, may block threads	Small-scale or legacy code
 ReentrantLock	Fine-grained control, tryLock	More verbose	Moderate concurrency
 StampedLock	Optimistic reads, high performance	Complex, error-prone	Read-heavy workloads
 ConcurrentHashMap	Thread-safe, fast reads	No ordering (LRU needs extra logic)	Shared access without ordering
***/

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public static void main(String[] args) {
        LRUCache test = new LRUCache(2);
    }

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // accessOrder = true
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }


    private final ReentrantLock ReentrantLock = new ReentrantLock();


    private final StampedLock stampedLock = new StampedLock();

}
