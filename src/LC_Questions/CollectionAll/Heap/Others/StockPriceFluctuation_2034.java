package LC_Questions.CollectionAll.Heap.Others;

import java.util.HashMap;
import java.util.PriorityQueue;

public class StockPriceFluctuation_2034 {

    PriorityQueue<int[]> minHeap;
    PriorityQueue<int[]> maxHeap;
    HashMap<Integer, Integer> hm;
    int currentTime;

    public StockPriceFluctuation_2034() {
        currentTime = 0;
        hm = new HashMap<>();
        minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    }

    public void update(int timestamp, int price) {
        currentTime = Math.max(currentTime, timestamp);;
        hm = new HashMap<>();
        minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    }

    public int current() {
        return hm.get(currentTime);
    }

    public int maximum() {
        while (!maxHeap.isEmpty() && hm.get(maxHeap.peek()[0]) != maxHeap.peek()[1]) {
            maxHeap.poll();
        }
        return maxHeap.peek()[1];
    }

    public int minimum() {
        while (!minHeap.isEmpty() && hm.get(minHeap.peek()[0]) != minHeap.peek()[1]) {
            minHeap.poll();
        }
        return minHeap.peek()[1];
    }
    public static void main(String[] args) {
        StockPriceFluctuation_2034 stockPrice = new StockPriceFluctuation_2034();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        System.out.println(stockPrice.current()); // Output: 5
        System.out.println(stockPrice.maximum()); // Output: 10
        stockPrice.update(1, 3);
        System.out.println(stockPrice.maximum()); // Output: 5
        stockPrice.update(4, 2);
        System.out.println(stockPrice.minimum()); // Ou
    }
}
