package LC_Questions.LinkedList.PremiumAlgo100.DeleteNAfterMLinkedList_1474;

import Lib.ListNode;

public class Two {
    public static void main(String[] args) {

    }
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode currentNode = head;
        ListNode lastMNode = head;
        while (currentNode != null) {
            int mCount = m, nCount = n;
            while (currentNode != null && mCount != 0) {
                lastMNode = currentNode;
                currentNode = currentNode.next;
                mCount--;
            }
            while (currentNode != null && nCount != 0) {
                currentNode = currentNode.next;
                nCount--;
            }
            lastMNode.next = currentNode;
        }
        return head;
    }
}
