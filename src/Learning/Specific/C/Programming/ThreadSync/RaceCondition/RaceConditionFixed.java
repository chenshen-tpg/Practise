<<<<<<<< HEAD:src/Preparation/Specific/Canva/Programming/ThreadSync/RaceCondition/RaceConditionFixed.java
package Preparation.Specific.Canva.Programming.ThreadSync.RaceCondition;
========
package Learning.Specific.C.Programming.ThreadSync.RaceCondition;
>>>>>>>> origin/master:src/Learning/Specific/C/Programming/ThreadSync/RaceCondition/RaceConditionFixed.java


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
