package Preparation.Specific.Canava.Programming.ThreadSync.RaceCondition;

class Counter1 {
    int count = 0;
    public synchronized void increament () {
        count++;
    }
}

class Execution implements Runnable {
    Counter1 counter;
    Execution(Counter1 counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increament();
        }
    }
}

public class review {

    public static void main(String[] args) throws InterruptedException {
        Counter1 counter = new Counter1();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Execution(counter));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Count: " + counter.count);
    }



}
