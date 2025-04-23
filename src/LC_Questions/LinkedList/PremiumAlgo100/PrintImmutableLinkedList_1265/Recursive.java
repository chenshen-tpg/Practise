package LC_Questions.LinkedList.PremiumAlgo100.PrintImmutableLinkedList_1265;

import Lib.ImmutableListNode;




public class Recursive {

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head != null) {
            printLinkedListInReverse(head.getNext());
            head.printValue();
        }
    }
}
