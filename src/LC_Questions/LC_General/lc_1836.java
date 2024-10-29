package LC_Questions.LC_General;

import java.util.HashMap;

public class lc_1836 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {

    }
    public  ListNode method(){
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
