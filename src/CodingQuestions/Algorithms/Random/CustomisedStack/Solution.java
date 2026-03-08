package CodingQuestions.Algorithms.Random.CustomisedStack;


import java.util.LinkedList;

public class Solution {
    static class Stack {
        LinkedList<Integer> stack = new LinkedList<>();
        public void push(int x) {
            stack.add(x);
        }

        public Integer pop() {
            if (!stack.isEmpty()) {
                return stack.pollLast();
            } else {
                return null;
            }
        }

        public boolean empty() {
            return stack.size() > 0;
        }

        public Integer peek() {
            if (!stack.isEmpty()) {
                return (int) stack.peekLast();
            }
            return null;
        }

        public int size() {
            return stack.size();
        }
    }
    public static void main(String[] args) {
        Solution.Stack stack = new Solution.Stack();
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
