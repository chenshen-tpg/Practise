package LC_Questions.CollectionAll.LinkedList;

import Lib.ListNode;

public class ParititionList_86 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(2);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ParititionList_86 pl = new ParititionList_86();
        ListNode res = pl.partition(head, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    private ListNode partition(ListNode head, int i) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode pre1 = dummy;
        ListNode cur1 = head;
        while (cur != null) {
            if (cur.val < i) {
                if (pre == cur) {
                    pre = pre.next;
                    cur = cur.next;
                } else {
                    pre.next = cur.next;
                    cur.next = cur1;
                    pre1.next = cur;
                    pre1 = cur;
                    cur = pre.next;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode dummyl = new ListNode(0);
        ListNode before = dummyl;
        ListNode dummys = new ListNode(0);
        ListNode after = dummys;
        while (head != null) {
            if (head.val >= x) {
                after.next = head;
                after = after.next;
            } else {
                before.next = head;
                before = before.next;
            }
            head = head.next;
            after.next = null;
        }
        before.next = dummys.next;
        return dummyl.next;
    }
}
