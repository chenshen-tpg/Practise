package CodingQuestions.LinkedList.MaximumPoints_1423;

import java.util.LinkedList;

public class Wrong {
    public static void main(String[] args) {
        int [] point = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        helper(point, k);
    }
    public static int helper (int [] arr, int k) {
        int ans = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            linkedList.add(arr[i]);
        }
        while(!linkedList.isEmpty()) {
            if (linkedList.getFirst() > linkedList.getLast()) {
                ans += linkedList.pollFirst();
                k--;
            } else {
                ans += linkedList.pollLast();
                k--;
            }
            if (k == 0) break;
        }
        return ans;
    }
}
