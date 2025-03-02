package LC_Questions.CollectionAll.Hash.Others.LengthOfLongestFibonacci_873;

import java.util.HashSet;
import java.util.Set;

public class HashSetSolution {
    public static void main(String[] args) {
        helper(new int [] {1, 3, 7, 11, 12, 14, 18});
    }

    public static int helper (int [] arr) {
        int n = arr.length;
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) numSet.add(num);

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prev = arr[j];
                int curr = arr[i] + arr[j];
                int len = 2;
                while (numSet.contains(curr)) {
                    int temp = curr;
                    curr += prev;
                    prev = temp;
                    maxLen = Math.max(maxLen, len++);
                }
            }
        }
        return maxLen;
    }
}
