package LC_Questions.CollectionAll.LinkedList.LC75.ReverseLinkedList_206;

import Lib.ListNode;

public class SlowFast {
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
