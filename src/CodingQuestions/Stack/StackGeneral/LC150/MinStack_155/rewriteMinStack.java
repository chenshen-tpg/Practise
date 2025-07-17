package CodingQuestions.Stack.StackGeneral.LC150.MinStack_155;

import java.util.Stack;

public class rewriteMinStack {

    Stack<int []> stack;

    public static void main(String[] args) {
        rewriteMinStack minStack = new rewriteMinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Expected output: -3

        // Test case 2: Pop element and get minimum
        minStack.pop();
        minStack.top();
        System.out.println(minStack.top());    // Expected output: 0
        System.out.println(minStack.getMin()); // Expected output: -2
        System.out.println(minStack.getMin());
    }

    public rewriteMinStack() {
       stack = new Stack<>();
    }

    public void push(int val) {
       if (stack.isEmpty()) stack.add(new int [] {val,val});
       int curMin = stack.peek()[1];
       stack.push(new int [] {val,Math.min(curMin,val)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
