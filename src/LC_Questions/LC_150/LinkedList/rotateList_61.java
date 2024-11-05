package LC_Questions.LC_150.LinkedList;

public class rotateList_61 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        rotateList_61 obj = new rotateList_61();
        ListNode head = obj.new ListNode(1);
        head.next = obj.new ListNode(2);
        head.next.next = obj.new ListNode(3);
        head.next.next.next = obj.new ListNode(4);
        head.next.next.next.next = obj.new ListNode(5);
        ListNode res = obj.rotateRight(head, 2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        int len = 0;
        while (fast.next != null) {
            fast = fast.next;
            len++;
        }
        for (int i = len - k % len; i > 0; i--) {
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
