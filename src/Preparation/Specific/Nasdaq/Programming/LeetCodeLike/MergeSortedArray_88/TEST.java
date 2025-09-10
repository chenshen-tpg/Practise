package Preparation.Specific.Nasdaq.Programming.LeetCodeLike.MergeSortedArray_88;

import java.util.Arrays;

public class TEST {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        while (m < nums1.length && i < n) nums1[m++] = nums2[i++];
        Arrays.sort(nums1);
    }
}
