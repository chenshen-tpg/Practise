package CodingQuestions.Algorithms.Math.FindMedianFromDataStream_295;

import java.util.PriorityQueue;

public class FingMedianFromDataStream {
    private PriorityQueue<Integer> small = new PriorityQueue<>((a,b) -> (b - a));
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;

    public static void main(String[] args) {
        FingMedianFromDataStream medianFinder = new FingMedianFromDataStream();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // Output: 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);// Output: 2.0
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
    }
    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
}
