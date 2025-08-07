package CodingQuestions.LinkedList.MaximumTwinSumOfAlinkedList_2130;

import CodingQuestions.Lib.ListNode;

public class Review {
    public static void main(String[] args) {

    }

    public int pairSum(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        ListNode slow = head;
        for (int i = 0; i < n / 2; i++) {
            slow = slow.next;
        }
        ListNode prev = null, cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        int max = 0;
        ListNode forward = head, backward = prev;
        for (int i = 0; i < n / 2; i++) {
            max = Math.max(max, forward.val + backward.val);
            forward = forward.next;
            backward = backward.next;
        }
        return max;
    }
}
