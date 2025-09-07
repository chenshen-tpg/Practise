package Learning.Specific.C.Programming.ThreadSync.RaceCondition;

/***
 A race condition occurs when two or more threads access a shared resource concurrently,
 and the final outcome depends on the unpredictable timing of their execution.
 This can lead to unexpected and incorrect results.
 The synchronized keyword in Java ensures that only one thread can execute a specific block of code or method at a time,
 providing a lock on the object or class.
 This guarantees that the critical section is executed atomically, preventing race conditions.
 */
class Counter {
    int count = 0;
    public synchronized void increment () {
        count++;
    }
}
class Worker implements Runnable {
    Counter counter;
    public Worker (Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
public class RaceCondition {
    public static void main(String[] args)  throws InterruptedException{
        Counter counter = new Counter();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Worker(counter));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Final count: " + counter.count);

    }
}
