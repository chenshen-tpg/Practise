package Preparation.RandomQuestions.SomeRandomC.CustomisedStack;

import java.util.ArrayDeque;
import java.util.Deque;


public class DoubleLinkedList_Deque_Version {
    static class Stack {
        Deque<Integer> queue = new ArrayDeque<>();
        public void push(int x) {
            queue.add(x);
        }

        public Integer pop() {
            if (!queue.isEmpty()) {
                return queue.pollLast();
            } else {
                return null;
            }
        }

        public boolean empty() {
            return queue.size() > 0;
        }

        public Integer peek() {
            if (!queue.isEmpty()) {
                return (int) queue.peekLast();
            }
            return null;
        }

        public int size() {
            return queue.size();
        }
    }

    public static void main(String[] args) {
        StackTesting.Stack stack = new StackTesting.Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.empty());
    }
}
