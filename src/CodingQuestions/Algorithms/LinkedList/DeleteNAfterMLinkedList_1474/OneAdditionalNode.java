package CodingQuestions.Algorithms.LinkedList.DeleteNAfterMLinkedList_1474;

import CodingQuestions.Lib.ListNode;

public class OneAdditionalNode {
    public static void main(String[] args) {

    }
    public ListNode deleteNodes(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode current = head;
        while (current != null) {
            for (int i = 1; i < m && current !=null; i++) current = current.next;
            if (current == null) break;
            ListNode temp = current.next;
            for (int i = 0; i < n && temp != null; i++) temp = temp.next;
            current.next = temp;
            current = temp;
        }
        return head;
    }
}
