package CodingQuestions.LinkedList.ReverseLinkedList_206;

import CodingQuestions.Lib.ListNode;

public class SlowFast {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        SlowFast solution = new SlowFast();
        solution.reverseList(head);
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
