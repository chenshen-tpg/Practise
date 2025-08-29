package Preparation.Specific.C.Programming.ThreadSync.DeadLock;

class Resource {
    private final String name;
    public Resource(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

public class TEST {
    private static final Resource resourceA = new Resource("A");
    private static final Resource resourceB = new Resource("B");

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("Thread 1: Locked resource A");
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting to lock resource B");
                synchronized (resourceB) {
                    System.out.println("Thread 1: Locked resource B");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resourceB) { // Order of locks is reversed
                System.out.println("Thread 2: Locked resource B");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting to lock resource A");
                synchronized (resourceA) {
                    System.out.println("Thread 2: Locked resource A");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}