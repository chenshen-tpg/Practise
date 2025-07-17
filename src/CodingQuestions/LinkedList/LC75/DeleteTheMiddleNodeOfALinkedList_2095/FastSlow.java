package CodingQuestions.LinkedList.LC75.DeleteTheMiddleNodeOfALinkedList_2095;

import CodingQuestions.Lib.ListNode;

public class FastSlow {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);
        FastSlow solution = new FastSlow();
        solution.deleteMiddle(head);
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
