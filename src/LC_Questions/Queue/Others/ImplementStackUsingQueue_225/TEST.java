package LC_Questions.Queue.Others.ImplementStackUsingQueue_225;

import java.util.LinkedList;
import java.util.Queue;

public class TEST {
    LinkedList<Integer> queue;
    public static void main(String[] args) {
        System.out.println();
    }


    public void push(int x) {
        // queue.addFirst(x);
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
