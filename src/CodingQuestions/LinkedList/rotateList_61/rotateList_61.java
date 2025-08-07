package CodingQuestions.LinkedList.rotateList_61;

import CodingQuestions.Lib.ListNode;

public class rotateList_61 {

    public static void main(String[] args) {
        rotateList_61 obj = new rotateList_61();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = obj.rotateRight(head, 2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        int len = 0;
        while (fast.next != null) {
            fast = fast.next;
            len++;
        }
        for (int i = len - k % len; i > 0; i--) {
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
