package LC_Questions.Stack.StackGeneral.LC150.MinStack_155;

import java.util.Stack;

public class TwoStacks {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public static void main(String[] args) {

    }

    public TwoStacks() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.add(val);
        if (minStack.isEmpty() || minStack.peek() < val) {
            minStack.push(val);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.pop();
    }
}
