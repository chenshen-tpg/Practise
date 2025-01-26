package LC_Questions.WholePackage.LinkedList;

import Lib.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MegeKSortedLists_23 {
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        if (o1.val > o2.val) {
                            return 1;
                        } else if (o1.val == o2.val) {
                            return 0;
                        } else {
                            return -1;
                        }
                    }
                }
        );
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            point.next = queue.poll();
            point = point.next;
            if (point.next != null) {
                queue.add(point.next);
            }
        }
        return head.next;
    }
}
