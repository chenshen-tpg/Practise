package CodingQuestions.Algorithms.LinkedList.PartitionsList_86;

import CodingQuestions.Lib.ListNode;

public class Dummy {
    public ListNode partition1(ListNode head, int x) {
        ListNode dummyl = new ListNode(0);
        ListNode before = dummyl;
        ListNode dummys = new ListNode(0);
        ListNode after = dummys;
        while (head != null) {
            if (head.val >= x) {
                after.next = head;
                after = after.next;
            } else {
                before.next = head;
                before = before.next;
            }
            head = head.next;
            after.next = null;
        }
        before.next = dummys.next;
        return dummyl.next;
    }
}
