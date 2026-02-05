package CodingQuestions.Algorithms.Important.LeetCodeStyle.ReverseLinkedList_206;

import CodingQuestions.Lib.ListNode;

public class TEST {
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy;
            dummy = cur;
            cur = next;
        }
        return dummy;
    }
}
