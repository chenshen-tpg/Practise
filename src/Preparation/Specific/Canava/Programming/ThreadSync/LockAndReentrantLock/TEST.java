package Preparation.Specific.Canava.Programming.ThreadSync.LockAndReentrantLock;
import java.util.concurrent.locks.ReentrantLock;

public class TEST {

        private int count = 0;
        private final ReentrantLock lock = new ReentrantLock();

        public void increment() {
            lock.lock(); // Acquire the lock
            try {
                count++;
            } finally {
                lock.unlock(); // Always release the lock in a finally block
            }
        }

        public int getCount() {
            lock.lock();
            try {
                return count;
            } finally {
                lock.unlock();
            }
        }

    public static void main(String[] args) {
        TEST solution = new TEST();
        for (int i = 0; i < 99999; i++) {
            solution.increment();
        }
        System.out.println(solution.getCount());

    }
}
