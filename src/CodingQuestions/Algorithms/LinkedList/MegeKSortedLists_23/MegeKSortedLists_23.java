package CodingQuestions.Algorithms.LinkedList.MegeKSortedLists_23;

import CodingQuestions.Lib.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MegeKSortedLists_23 {
    public static void main(String[] args) {
        MegeKSortedLists_23 solution = new MegeKSortedLists_23();
        ListNode[] lists1 = {
                createList(new int[]{1,4,5}),
                createList(new int[]{1,3,4}),
                createList(new int[]{2,6})
        };
        printList(solution.mergeKLists(lists1));
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        PriorityQueue<ListNode> q = new PriorityQueue<>(
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
                q.add(node);
            }
        }
        while (!q.isEmpty()) {
            point.next = q.poll();
            point = point.next;
            if (point.next != null) {
                q.add(point.next);
            }
        }
        return head.next;
    }
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
