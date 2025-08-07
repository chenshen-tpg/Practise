package CodingQuestions.LinkedList.ReverseNodesInKgroup_25;

import CodingQuestions.Lib.ListNode;

public class reverseNodesInKGroup_25 {
    public static void main(String[] args) {

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode new_head = null;
        ListNode ptr = head;

        while (k > 0) {
            ListNode next_node = ptr.next;
            ptr.next = new_head;
            new_head = ptr;
            ptr = next_node;
            k--;
        }
        return new_head;
    }

    public ListNode reverseKGroup_W(ListNode head, int k) {
        ListNode ptr = head;
        ListNode ktail = null;
        ListNode new_head = null;
        while (ptr != null) {
            int count = 0;
            ptr = head;
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count += 1;
            }
            if (count == k) {
                ListNode revHead = this.reverseLinkedList(head, k);
                if (new_head == null) new_head = revHead;
                if (ktail != null) ktail.next = revHead;
                ktail = head;
                head = ptr;
            }
        }
        if (ktail != null) ktail.next = head;
        return new_head == null ? head : new_head;
    }
}
