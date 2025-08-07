package CodingQuestions.LinkedList.DeleteTheMiddleNodeOfALinkedList_2095;

import CodingQuestions.Lib.ListNode;

public class Review {
    public static void main(String[] args) {

    }
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        int count = 0;
        ListNode dummy = head;
        while (dummy != null) {
            dummy = dummy.next;
            count++;
        }
        ListNode dummy1 = head;
        for (int i = 0; i < count /2 -1; i++) {
            dummy1 = dummy1.next;
        }
        dummy1.next = dummy1.next.next;
        return head;
    }
}
