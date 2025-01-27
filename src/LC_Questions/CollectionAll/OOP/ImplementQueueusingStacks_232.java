package LC_Questions.CollectionAll.OOP;

import java.util.Stack;

public class ImplementQueueusingStacks_232 {
    public static void main(String[] args) {
        ImplementQueueusingStacks_232 queue = new ImplementQueueusingStacks_232();
        // Test case 1: Push elements and check the order
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // Expected output: 1
        System.out.println(queue.pop());  // Expected output: 1
        System.out.println(queue.empty()); // Expected output: false

        // Test case 2: Push more elements and check the order
        queue.push(3);
        queue.push(4);
        System.out.println(queue.peek()); // Expected output: 2
        System.out.println(queue.pop());  // Expected output: 2
        System.out.println(queue.pop());  // Expected output: 3
        System.out.println(queue.pop());  // Expected output: 4
        System.out.println(queue.empty()); // Expected output: true

        // Test case 3: Check empty queue
        System.out.println(queue.pop());  // Expected output: -1
        System.out.println(queue.peek()); // Expected output: -1
    }
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    public ImplementQueueusingStacks_232() {
       stackIn = new Stack();
       stackOut = new Stack();
    }

    public void push(int x) {
        stackIn.add(x);
    }

    public int pop() {
        if (stackOut.isEmpty()) {
            while (stackIn.isEmpty()) {
                stackOut.add(stackIn.pop());
            }
        }
        return stackOut.isEmpty() ? -1 : stackOut.pop();
    }

    public int peek() {
        if (!stackOut.isEmpty()) {
            return stackOut.peek();
        } else {
            while (!stackIn.isEmpty()) {
                stackOut.add(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
