package Preparation.General.LeetCodeStyle.MergeTwoSortedLists_21;

import CodingQuestions.Lib.ListNode;

import java.util.ArrayList;
import java.util.Collections;

public class SampleAns2 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> li = new ArrayList<>();
        ListNode temp = list1;
        while (temp != null) {
            li.add(temp.val);
            temp = temp.next;

        }
        temp = list2;
        while (temp != null) {
            li.add(temp.val);
            temp = temp.next;

        }
        Collections.sort(li);
        ListNode head = null;
        ListNode tail = null;
        for (int val : li) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }
}
