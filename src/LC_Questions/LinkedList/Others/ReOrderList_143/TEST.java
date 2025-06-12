package LC_Questions.LinkedList.Others.ReOrderList_143;

import Lib.ListNode;

public class TEST {
    public static void main(String[] args) {

    }

    //find middle, reverse second half,
    public void reorderList(ListNode head) {
        ListNode fast= head, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode dummy = null, curr = slow, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = dummy;
            dummy = curr;
            curr = temp;
        }
        ListNode first = head, second = dummy;
        while (second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;
            temp = second.next;
            second.next =first;
            second = temp;
        }
    }

}
