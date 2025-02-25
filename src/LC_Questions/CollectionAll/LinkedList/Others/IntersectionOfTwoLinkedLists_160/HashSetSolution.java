package LC_Questions.CollectionAll.LinkedList.Others.IntersectionOfTwoLinkedLists_160;

import Lib.ListNode;

import java.util.HashSet;

public class HashSetSolution {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> li = new HashSet<>();
        while (headA != null) {
            li.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (li.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
