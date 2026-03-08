package CodingQuestions.Algorithms.Random.CustomisedStack;

public class RealLinkedListBased {

    static class Stack {
        private Node head;

        private class Node {
            int val;
            Node next;
            Node(int v) { val = v; }
        }

        public void push(int x) {
            Node node = new Node(x);
            node.next = head;
            head = node;
        }
        public int size() {
            int count = 0;
            Node node = head;
            while (node != null) {
                count++;
                node = node.next;
            }
            return count;
        }
        public Integer pop() {
            if (head == null) return null;
            int val = head.val;
            head = head.next;
            return val;
        }

        public boolean empty() {
            return head == null;
        }

        public Integer peek() {
            if (head == null) return null;
            return head.val;
        }
    }
    public static void main(String[] args) {
        RealLinkedListBased.Stack stack = new RealLinkedListBased.Stack();
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
