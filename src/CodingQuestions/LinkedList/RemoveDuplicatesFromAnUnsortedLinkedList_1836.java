package CodingQuestions.LinkedList;

import CodingQuestions.Lib.ListNode;

import java.util.HashMap;

public class RemoveDuplicatesFromAnUnsortedLinkedList_1836 {

    public static void main(String[] args) {

    }
    public ListNode method(){
        ListNode dummy = new ListNode(-1, new ListNode());
        ListNode h = new ListNode(), cur = dummy.next, pre = dummy;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (h != null) {
            hm.put(h.val, hm.getOrDefault(h.val, 0) + 1);
            h = h.next;
        }
        while (cur !=null) {
            if (hm.get(cur.val) > 1) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
