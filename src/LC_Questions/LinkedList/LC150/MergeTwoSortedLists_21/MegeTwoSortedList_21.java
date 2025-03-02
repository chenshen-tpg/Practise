package LC_Questions.LinkedList.LC150.MergeTwoSortedLists_21;

import Lib.ListNode;

public class MegeTwoSortedList_21 {
    public static void main(String[] args) {
        MegeTwoSortedList_21 obj = new MegeTwoSortedList_21();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        ListNode res = obj.mergeTwoLists(head1, head2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    // since the one is sorted, we can compare the first element of each list
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = list1 == null ? list2 : list1;
        return head.next;
    }
}
