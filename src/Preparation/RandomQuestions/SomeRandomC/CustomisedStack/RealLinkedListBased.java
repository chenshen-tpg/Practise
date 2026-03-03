package Preparation.RandomQuestions.SomeRandomC.CustomisedStack;

public class RealLinkedListBased {
    class Stack {
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
}
