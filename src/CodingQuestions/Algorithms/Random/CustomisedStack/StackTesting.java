package CodingQuestions.Algorithms.Random.CustomisedStack;


public class StackTesting {
    static class Stack {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
//  This won't work since we are using the same name according to the question
//  We call java.util to differentiate the Stack stack = new Stack();

        public void push(int x) {
            stack.push(x);
        }

        public Integer pop() {
            if (!stack.empty()) {
                return stack.pop();
            } else {
                return null;
            }
        }

        public boolean empty() {
            return stack.empty();
        }

        public Integer peek() {
            if (!stack.empty()) {
                return (int) stack.peek();
            }
            return null;
        }

        public int size() {
            return stack.size();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
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
