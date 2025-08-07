package CodingQuestions.LinkedList.PlusOne_369;

import CodingQuestions.Lib.ListNode;

public class TEST {

    public static void main(String[] args) {

    }

    public ListNode plusOne(ListNode head) {
        ListNode before = new ListNode(0);
        before.next = head;
        ListNode cur = before;

        while (head != null) {
            if (head.val != 9)  cur = head;
            head = head.next;
        }
        cur.val++;
        cur = cur.next;
        while (cur != null) {
            cur.val = 0;
            cur = cur.next;
        }
        return before.val != 0 ? before : before.next;
    }
}
