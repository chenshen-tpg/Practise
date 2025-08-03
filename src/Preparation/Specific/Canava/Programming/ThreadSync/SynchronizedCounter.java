package Preparation.Specific.Canava.Programming.ThreadSync;

public class SynchronizedCounter {

    private int count = 0;

    public static void main(String[] args) {

    }

    // 'synchronized' ensures only one thread can execute this method at a time
    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }


}


