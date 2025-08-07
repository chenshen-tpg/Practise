package CodingQuestions.LinkedList.DeleteTheMiddleNodeOfALinkedList_2095;

import CodingQuestions.Lib.ListNode;

public class TwoPasses {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);
        TwoPasses solution = new TwoPasses();
        solution.deleteMiddle(head);
    }
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        int len = 0;
        ListNode dummy = head;
        while (dummy !=null) {
            dummy = dummy.next;
            len++;
        }
        ListNode cur = head;
        for (int i = 0; i < len / 2 - 1; i++) {
            cur= cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}
