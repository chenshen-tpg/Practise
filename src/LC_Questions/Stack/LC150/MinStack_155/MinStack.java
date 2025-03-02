package LC_Questions.Stack.LC150.MinStack_155;

import java.util.Stack;

public class MinStack {


    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.add(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int small = Integer.MAX_VALUE;
        for (Integer i : stack) {
            small = Math.min(small, i);
        }
        return small;
    }
}
