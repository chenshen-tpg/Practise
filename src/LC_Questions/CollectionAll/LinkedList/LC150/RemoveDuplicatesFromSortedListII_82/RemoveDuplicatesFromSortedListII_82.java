package LC_Questions.CollectionAll.LinkedList.LC150.RemoveDuplicatesFromSortedListII_82;


import Lib.ListNode;

public class RemoveDuplicatesFromSortedListII_82 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode res = deleteDuplicates(head);
        while (res != null) {
            System.out.print(res.val + "");
            res = res.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode s = new ListNode(0, head);
        ListNode pred = s;

        while (head != null) {
            if(head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pred.next = head.next;

            } else {
                pred = pred.next;
            }
            head = head.next;
        }
        return s.next;
    }
}
