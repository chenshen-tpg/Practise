package CodingQuestions.Algorithms.LinkedList.MaximumTwinSumOfAlinkedList_2130;

import CodingQuestions.Lib.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ListTwoPointers {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(10000);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(3);
        ListTwoPointers solution = new ListTwoPointers();
        System.out.println(solution.helper(head));
    }

    public int helper (ListNode head) {
        List<Integer> li = new ArrayList<>();
        while(head != null) {
            li.add(head.val);
            head = head.next;
        }
        int left = 0, right = li.size() - 1;
        int max = 0;
        while (left < right) {
            int sum = li.get(left) + li.get(right);
            max = Math.max(max,sum);
            left++;
            right--;
        }
        return max;
    }
}
