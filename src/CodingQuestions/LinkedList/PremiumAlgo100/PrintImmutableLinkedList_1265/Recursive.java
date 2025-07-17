package CodingQuestions.LinkedList.PremiumAlgo100.PrintImmutableLinkedList_1265;

import CodingQuestions.Lib.ImmutableListNode;




public class Recursive {

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head != null) {
            printLinkedListInReverse(head.getNext());
            head.printValue();
        }
    }
}
