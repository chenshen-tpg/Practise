package LC_Questions.CollectionAll.LinkedList.LC150.LinkedListCycle_141;

import Lib.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCycle_141 {


    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        List<ListNode> visited = new ArrayList<>();
        while(head!=null){
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;
    }
    public boolean hasCycle1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
