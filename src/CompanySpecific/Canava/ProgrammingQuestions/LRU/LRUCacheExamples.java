package CompanySpecific.Canava.ProgrammingQuestions.LRU;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCacheExamples {

    // --- LRU Cache with ConcurrentHashMap and externally synchronized LinkedHashMap ---
    // Note: This approach is less common because LinkedHashMap operations are synchronized
    // while ConcurrentHashMap operations are not directly tied to the LRU order management.
    // A more typical approach would be to use a single synchronized LinkedHashMap
    // or a more advanced custom structure.
    // However, for educational purposes, demonstrating how ConcurrentHashMap's
    // presence doesn't inherently make LinkedHashMap thread-safe for LRU order.

    static class LRUCacheWithConcurrentMapAndSyncLinkedHashMap<K, V> {
        private final int capacity;
        // ConcurrentHashMap for fast key lookups, but doesn't handle LRU order
        private final ConcurrentHashMap<K, V> cache;
        // LinkedHashMap to maintain LRU order, requires external synchronization
        private final LinkedHashMap<K, V> lruOrderMap;

        // An explicit lock to protect the lruOrderMap
        private final Object lock = new Object(); // Can also be ReentrantLock

        public LRUCacheWithConcurrentMapAndSyncLinkedHashMap(int capacity) {
            this.capacity = capacity;
            this.cache = new ConcurrentHashMap<>(capacity);
            this.lruOrderMap = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    if (size() > LRUCacheWithConcurrentMapAndSyncLinkedHashMap.this.capacity) {
                        // Remove from ConcurrentHashMap as well
                        cache.remove(eldest.getKey());
                        return true;
                    }
                    return false;
                }
            };
        }

        public V get(K key) {
            synchronized (lock) {
                V value = cache.get(key); // Get from ConcurrentHashMap first
                if (value != null) {
                    lruOrderMap.get(key); // Access to update LRU order
                }
                return value;
            }
        }

        public void put(K key, V value) {
            synchronized (lock) {
                // Put into ConcurrentHashMap
                cache.put(key, value);
                // Put into LinkedHashMap to maintain order (this will trigger removeEldestEntry if needed)
                lruOrderMap.put(key, value);
            }
        }

        public int size() {
            synchronized (lock) {
                return lruOrderMap.size(); // Reflects the actual cached size
            }
        }
    }

    // --- A more standard and efficient LRU Cache using a single Synchronized LinkedHashMap ---
    // This is often the simplest and most performant approach for moderate concurrency.
    static class LRUCacheWithSynchronizedLinkedHashMap<K, V> {
        private final int capacity;
        private final Map<K, V> cache;

        public LRUCacheWithSynchronizedLinkedHashMap(int capacity) {
            this.capacity = capacity;
            this.cache = Collections.synchronizedMap(new LinkedHashMap<K, V>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    return size() > LRUCacheWithSynchronizedLinkedHashMap.this.capacity;
                }
            });
        }

        public V get(K key) {
            return cache.get(key); // SynchronizedMap handles internal locking for get
        }

        public void put(K key, V value) {
            cache.put(key, value); // SynchronizedMap handles internal locking for put
        }

        public int size() {
            return cache.size();
        }
    }

    // --- LRU Cache with ReentrantLock ---
    // Provides more control than synchronized blocks, but still exclusive access.
    static class LRUCacheWithReentrantLock<K, V> {
        private final int capacity;
        private final LinkedHashMap<K, V> cache;
        private final ReentrantLock lock = new ReentrantLock();

        public LRUCacheWithReentrantLock(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    return size() > LRUCacheWithReentrantLock.this.capacity;
                }
            };
        }

        public V get(K key) {
            lock.lock(); // Acquire the lock
            try {
                return cache.get(key);
            } finally {
                lock.unlock(); // Always release the lock
            }
        }

        public void put(K key, V value) {
            lock.lock(); // Acquire the lock
            try {
                cache.put(key, value);
            } finally {
                lock.unlock(); // Always release the lock
            }
        }

        public int size() {
            lock.lock();
            try {
                return cache.size();
            } finally {
                lock.unlock();
            }
        }
    }

    // --- LRU Cache with ReentrantReadWriteLock ---
    // Allows multiple concurrent reads, but only one write at a time.
    static class LRUCacheWithReadWriteLock<K, V> {
        private final int capacity;
        private final LinkedHashMap<K, V> cache;
        private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
        private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

        public LRUCacheWithReadWriteLock(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    return size() > LRUCacheWithReadWriteLock.this.capacity;
                }
            };
        }

        public V get(K key) {
            readLock.lock(); // Acquire read lock
            try {
                // Even though it's a read, accessing updates the LRU order,
                // which is a structural modification to LinkedHashMap's internal list.
                // Therefore, if we want strict LRU order maintenance, 'get' also needs a write lock.
                // This is a common subtle point in LRU with ReadWriteLock.
                // For a true read-only access that doesn't affect LRU, a read lock would suffice.
                // But for LRU, 'get' modifies the order.
                // Option 1: Treat 'get' as a write operation (simplest but less concurrent for reads).
                // Option 2: Optimize with StampedLock or more complex logic to move nodes.
                // For LinkedHashMap's 'accessOrder=true', 'get' _does_ modify internal structure.
                // Thus, 'get' *must* acquire the write lock to be fully thread-safe for LRU.
                // If 'get' only read and didn't affect LRU order, readLock would be fine.

                // Corrected for LinkedHashMap's accessOrder=true behavior:
                readLock.unlock(); // Release read lock to acquire write lock
                writeLock.lock();  // Acquire write lock for LRU update
                try {
                    V value = cache.get(key);
                    return value;
                } finally {
                    writeLock.unlock(); // Release write lock
                    readLock.lock(); // Re-acquire read lock for a consistent block structure (optional but good practice)
                }
            } finally {
                readLock.unlock(); // Ensure final release of read lock (even if re-acquired above)
            }
        }

        public void put(K key, V value) {
            writeLock.lock(); // Acquire write lock
            try {
                cache.put(key, value);
            } finally {
                writeLock.unlock(); // Always release the write lock
            }
        }

        public int size() {
            readLock.lock();
            try {
                return cache.size();
            } finally {
                readLock.unlock();
            }
        }
    }

    // --- LRU Cache with StampedLock ---
    // Advanced option for very high read concurrency
    static class LRUCacheWithStampedLock<K, V> {
        private final int capacity;
        private final LinkedHashMap<K, V> cache; // LinkedHashMap requires external sync
        private final StampedLock lock = new StampedLock();

        public LRUCacheWithStampedLock(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    return size() > LRUCacheWithStampedLock.this.capacity;
                }
            };
        }

        public V get(K key) {
            long stamp = lock.tryOptimisticRead(); // Try optimistic read
            V value = cache.get(key); // Read the value
            // Even an optimistic read on LinkedHashMap with accessOrder=true
            // will *attempt* to modify the list, which is not thread-safe without an exclusive lock.
            // So, for LRU's 'get' operation, an optimistic read is generally not suitable *unless*
            // you decouple the LRU list management from the map itself.
            // For this LinkedHashMap based LRU, 'get' is a write operation for LRU order.

            // If we strictly want to use StampedLock's benefits with LinkedHashMap for LRU,
            // 'get' must also be a write operation (acquiring a write lock).
            // A truly optimized StampedLock LRU would involve custom data structures (e.g., doubly linked list + ConcurrentHashMap).

            if (!lock.validate(stamp) || value == null) {
                // If optimistic read failed or key not found (or for LRU update)
                stamp = lock.writeLock(); // Acquire write lock (pessimistic)
                try {
                    value = cache.get(key); // Re-read under write lock
                } finally {
                    lock.unlockWrite(stamp);
                }
            }
            return value;
        }

        public void put(K key, V value) {
            long stamp = lock.writeLock(); // Acquire write lock
            try {
                cache.put(key, value);
            } finally {
                lock.unlockWrite(stamp); // Always release the write lock
            }
        }

        public int size() {
            long stamp = lock.readLock(); // Acquire read lock
            try {
                return cache.size();
            } finally {
                lock.unlockRead(stamp);
            }
        }
    }

    // --- Example Usage with Executors, Callable, and Future ---
    public static void main(String[] args) throws Exception {
        System.out.println("--- LRUCacheWithSynchronizedLinkedHashMap ---");
        testLRUCache(new LRUCacheWithSynchronizedLinkedHashMap<>(3));

        System.out.println("\n--- LRUCacheWithReentrantLock ---");
        testLRUCache(new LRUCacheWithReentrantLock<>(3));

        System.out.println("\n--- LRUCacheWithReadWriteLock ---");
        // Due to LinkedHashMap's accessOrder=true, 'get' is also a write.
        // This example will behave similar to ReentrantLock due to 'get' needing a write lock.
        // For actual ReadWriteLock benefits with LRU, a custom data structure would be needed.
        testLRUCache(new LRUCacheWithReadWriteLock<>(3));

        System.out.println("\n--- LRUCacheWithStampedLock ---");
        // Similar to ReadWriteLock, 'get' on LinkedHashMap requires a write lock for LRU.
        testLRUCache(new LRUCacheWithStampedLock<>(3));
    }

    // Generic test method for LRU caches
    private static void testLRUCache(Object lruCache) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5); // Thread pool of 5 threads
        Future<?> future1 = null;
        Future<?> future2 = null;
        Future<Integer> future3 = null;

        if (lruCache instanceof LRUCacheWithSynchronizedLinkedHashMap) {
            LRUCacheWithSynchronizedLinkedHashMap<Integer, String> cache = (LRUCacheWithSynchronizedLinkedHashMap<Integer, String>) lruCache;
            future1 = executor.submit(() -> {
                System.out.println("Thread 1: Putting (1, A)");
                cache.put(1, "A");
                System.out.println("Thread 1: Putting (2, B)");
                cache.put(2, "B");
            });

            future2 = executor.submit(() -> {
                try {
                    Thread.sleep(50); // Give Thread 1 a head start
                    System.out.println("Thread 2: Getting 1 -> " + cache.get(1)); // Access 1 to make it most recent
                    System.out.println("Thread 2: Putting (3, C)");
                    cache.put(3, "C");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            future3 = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(100); // Wait for puts to finish
                    System.out.println("Thread 3: Getting 2 -> " + cache.get(2)); // Access 2
                    System.out.println("Thread 3: Putting (4, D) - Should evict 3");
                    cache.put(4, "D"); // 3 should be evicted
                    System.out.println("Thread 3: Getting 3 -> " + cache.get(3)); // Should be null
                    return cache.size();
                }
            });

        } else if (lruCache instanceof LRUCacheWithReentrantLock) {
            LRUCacheWithReentrantLock<Integer, String> cache = (LRUCacheWithReentrantLock<Integer, String>) lruCache;
            // Same logic as above for demonstration
            future1 = executor.submit(() -> {
                System.out.println("Thread 1: Putting (1, A)");
                cache.put(1, "A");
                System.out.println("Thread 1: Putting (2, B)");
                cache.put(2, "B");
            });

            future2 = executor.submit(() -> {
                try {
                    Thread.sleep(50);
                    System.out.println("Thread 2: Getting 1 -> " + cache.get(1));
                    System.out.println("Thread 2: Putting (3, C)");
                    cache.put(3, "C");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            future3 = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(100);
                    System.out.println("Thread 3: Getting 2 -> " + cache.get(2));
                    System.out.println("Thread 3: Putting (4, D) - Should evict 3");
                    cache.put(4, "D");
                    System.out.println("Thread 3: Getting 3 -> " + cache.get(3));
                    return cache.size();
                }
            });
        }
        else if (lruCache instanceof LRUCacheWithReadWriteLock) {
            LRUCacheWithReadWriteLock<Integer, String> cache = (LRUCacheWithReadWriteLock<Integer, String>) lruCache;
            // Same logic
            future1 = executor.submit(() -> {
                System.out.println("Thread 1: Putting (1, A)");
                cache.put(1, "A");
                System.out.println("Thread 1: Putting (2, B)");
                cache.put(2, "B");
            });

            future2 = executor.submit(() -> {
                try {
                    Thread.sleep(50);
                    System.out.println("Thread 2: Getting 1 -> " + cache.get(1));
                    System.out.println("Thread 2: Putting (3, C)");
                    cache.put(3, "C");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            future3 = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(100);
                    System.out.println("Thread 3: Getting 2 -> " + cache.get(2));
                    System.out.println("Thread 3: Putting (4, D) - Should evict 3");
                    cache.put(4, "D");
                    System.out.println("Thread 3: Getting 3 -> " + cache.get(3));
                    return cache.size();
                }
            });
        }
        else if (lruCache instanceof LRUCacheWithStampedLock) {
            LRUCacheWithStampedLock<Integer, String> cache = (LRUCacheWithStampedLock<Integer, String>) lruCache;
            // Same logic
            future1 = executor.submit(() -> {
                System.out.println("Thread 1: Putting (1, A)");
                cache.put(1, "A");
                System.out.println("Thread 1: Putting (2, B)");
                cache.put(2, "B");
            });

            future2 = executor.submit(() -> {
                try {
                    Thread.sleep(50);
                    System.out.println("Thread 2: Getting 1 -> " + cache.get(1));
                    System.out.println("Thread 2: Putting (3, C)");
                    cache.put(3, "C");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            future3 = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(100);
                    System.out.println("Thread 3: Getting 2 -> " + cache.get(2));
                    System.out.println("Thread 3: Putting (4, D) - Should evict 3");
                    cache.put(4, "D");
                    System.out.println("Thread 3: Getting 3 -> " + cache.get(3));
                    return cache.size();
                }
            });
        }


        // Wait for tasks to complete
        if (future1 != null) future1.get();
        if (future2 != null) future2.get();
        if (future3 != null) {
            Integer finalSize = future3.get();
            System.out.println("Final cache size: " + finalSize);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        if (lruCache instanceof LRUCacheWithSynchronizedLinkedHashMap) {
            LRUCacheWithSynchronizedLinkedHashMap<Integer, String> cache = (LRUCacheWithSynchronizedLinkedHashMap<Integer, String>) lruCache;
            System.out.println("Cache content (expected: 1, 2, 4): " + cache.cache); // Using cache.cache to peek at the underlying map
        } else if (lruCache instanceof LRUCacheWithReentrantLock) {
            LRUCacheWithReentrantLock<Integer, String> cache = (LRUCacheWithReentrantLock<Integer, String>) lruCache;
            // For testing, access the internal LinkedHashMap directly (not ideal in real code)
            cache.lock.lock();
            try {
                System.out.println("Cache content (expected: 1, 2, 4): " + cache.cache);
            } finally {
                cache.lock.unlock();
            }
        }
        else if (lruCache instanceof LRUCacheWithReadWriteLock) {
            LRUCacheWithReadWriteLock<Integer, String> cache = (LRUCacheWithReadWriteLock<Integer, String>) lruCache;
            cache.readLock.lock();
            try {
                System.out.println("Cache content (expected: 1, 2, 4): " + cache.cache);
            } finally {
                cache.readLock.unlock();
            }
        }
        else if (lruCache instanceof LRUCacheWithStampedLock) {
            LRUCacheWithStampedLock<Integer, String> cache = (LRUCacheWithStampedLock<Integer, String>) lruCache;
            long stamp = cache.lock.readLock();
            try {
                System.out.println("Cache content (expected: 1, 2, 4): " + cache.cache);
            } finally {
                cache.lock.unlockRead(stamp);
            }
        }
    }
}