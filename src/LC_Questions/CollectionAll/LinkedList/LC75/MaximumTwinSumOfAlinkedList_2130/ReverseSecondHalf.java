package LC_Questions.CollectionAll.LinkedList.LC75.MaximumTwinSumOfAlinkedList_2130;

import Lib.ListNode;

public class ReverseSecondHalf {
    public static void main(String[] args) {

    }
    public int pariSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast !=null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nextNode, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        int max = 0;
        while (prev != null) {
            max = Math.max(max, head.val + prev.val);
            prev = prev.next;
            head = head.next;
        }
        return max;
    }
}
