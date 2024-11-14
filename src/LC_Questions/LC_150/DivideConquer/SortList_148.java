package LC_Questions.LC_150.DivideConquer;

public class SortList_148 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        SortList_148 sl = new SortList_148();
        ListNode head = sl.new ListNode(4);
        head.next = sl.new ListNode(2);
        head.next.next = sl.new ListNode(1);
        head.next.next.next = sl.new ListNode(3);
        ListNode res = sl.sortList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
    ListNode getMid(ListNode head) {
        ListNode midpre = null;
        while (head !=null && head.next != null) {
            midpre = (midpre == null) ? head : midpre.next;
            head = head.next.next;
        }
        ListNode mid = midpre.next;
        midpre.next = null;
        return mid;
    }
}
