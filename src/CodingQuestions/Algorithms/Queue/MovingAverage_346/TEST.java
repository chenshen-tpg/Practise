package CodingQuestions.Algorithms.Queue.MovingAverage_346;

import java.util.LinkedList;
import java.util.Queue;

public class TEST {
    Queue<Integer> q;
    int k;

    public static void main(String[] args) {

    }
    public TEST(int size) {
        q = new LinkedList();
        k = size;
    }

    public double next(int val) {
        int temp = 0;
        if (q.size() < k) {
            q.add(val);
            for (int i : q) temp += i;
            return (double) temp / q.size();
        } else {
            q.poll();
            q.add(val);
            for (int i : q) temp += i;
            return (double) temp / q.size();
        }
    }
}
