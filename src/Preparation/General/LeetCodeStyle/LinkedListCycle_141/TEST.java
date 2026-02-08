package Preparation.General.LeetCodeStyle.LinkedListCycle_141;

import CodingQuestions.Lib.ListNode;

public class TEST {
    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
