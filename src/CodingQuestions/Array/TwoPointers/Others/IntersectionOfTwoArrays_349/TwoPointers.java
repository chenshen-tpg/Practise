package CodingQuestions.Array.TwoPointers.Others.IntersectionOfTwoArrays_349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoPointers {
    public static void main(String[] args) {
        TwoPointers solution = new TwoPointers();
        solution.intersection(new int [] {1,2,2,1}, new int [] {2,2});
    }

    private int[] intersection(int[] nums1 , int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        Set<Integer> set = new HashSet<>();
        while (p1 < nums1.length && p2 <  nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                set.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if (nums1[p1] < nums2[p2]) p1++;
            else p2++;
        }
        int[] result = new int[set.size()];
        int curr = 0;
        for (int x: set) result[curr++] = x;
        return result;
    }
}
