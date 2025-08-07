package CodingQuestions.Array.TwoPointers.MaxNumberOfKSumPairs_1679;

import java.util.Arrays;

public class TwoPointers {
    public static void main(String[] args) {
        TwoPointers mn = new TwoPointers();
        System.out.println(mn.maxOperationsTwoPointers(new int[]{4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4}, 2));
    }

    private int maxOperationsTwoPointers(int[] ints, int i) {
        Arrays.sort(ints);
        int l = 0, r = ints.length - 1;
        int count = 0;
        while (l < r) {
            if (ints[l] + ints[r] == i) {
                l++;
                count++;
                r--;
            } else if (ints[l] + ints[r] < i) {
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}
