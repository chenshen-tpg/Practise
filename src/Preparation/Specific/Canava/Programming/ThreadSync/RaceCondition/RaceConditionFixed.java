package Preparation.Specific.Canava.Programming.ThreadSync.RaceCondition;


class SynchronizedCounter {
    int count = 0;
    public synchronized void increment() {
        count++;
    }
}
class SynchronizedWorker implements Runnable {
    SynchronizedCounter counter;
    public SynchronizedWorker(SynchronizedCounter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}
public class RaceConditionFixed {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        Thread[] synchronizedThreads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            synchronizedThreads[i] = new Thread(new SynchronizedWorker(synchronizedCounter));
            synchronizedThreads[i].start();
        }
        for (Thread synchronizedThread : synchronizedThreads) {
            synchronizedThread.join();
        }

        System.out.println("Final count: " + synchronizedCounter.count);
    }

}
