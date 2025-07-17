package CodingQuestions.LinkedList.PremiumAlgo100.PlusOne_369;

import CodingQuestions.Lib.ListNode;

public class Recursive {
    public static void main(String[] args) {

    }
    public ListNode plusOne(ListNode head) {
        if (head == null) return new ListNode(1);
        ListNode plused = plusOne(head.next);
        if (plused != head.next) head.val++;
        if (head.val <= 9) return head;
        head.val = 0;
        plused.next = head;
        return plused;
    }
}
