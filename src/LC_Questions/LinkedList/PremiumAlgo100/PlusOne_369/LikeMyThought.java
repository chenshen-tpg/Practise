package LC_Questions.LinkedList.PremiumAlgo100.PlusOne_369;

import Lib.ListNode;

public class LikeMyThought {
    public static void main(String[] args) {

    }


    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy, j = dummy;

        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }

        if (j.val != 9) {
            j.val++;
        } else {
            i.val++;
            i = i.next;
            while (i != null) {
                i.val = 0;
                i = i.next;
            }
        }

        return dummy.val == 0 ? dummy.next : dummy;
    }
}
