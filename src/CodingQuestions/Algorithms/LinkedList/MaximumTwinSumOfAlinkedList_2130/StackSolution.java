package CodingQuestions.Algorithms.LinkedList.MaximumTwinSumOfAlinkedList_2130;

import CodingQuestions.Lib.ListNode;

import java.util.Stack;

public class StackSolution {
    public static void main(String[] args) {
        StackSolution solution = new StackSolution();
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(solution.helper(head));
    }

    private int helper(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode dummy = head;
        while (dummy != null) {
            stack.push(dummy.val);
            dummy = dummy.next;
        }
        int count = 1;
        int max = 0;
        while (count <= stack.size() / 2) {
            max = Math.max(max, head.val + stack.peek());
            head = head.next;
            stack.pop();
            count++;
        }
        return max;
    }
    private int model (ListNode head) {
        ListNode current = head;
        Stack<Integer> st = new Stack<Integer>();
        while (current != null) {
            st.push(current.val);
            current = current.next;
        }
        current = head;
        int size = st.size(), count = 1;
        int maximumSum = 0;
        while (count <= size / 2) {
            maximumSum = Math.max(maximumSum, current.val + st.peek());
            current = current.next;
            st.pop();
            count++;
        }
        return maximumSum;
    }
}
