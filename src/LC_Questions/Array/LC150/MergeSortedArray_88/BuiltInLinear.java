package LC_Questions.Array.LC150.MergeSortedArray_88;

import java.util.Arrays;

public class BuiltInLinear {
    public static void main(String[] args) {
        int [] nums1 = {1, 2, 3, 0, 0, 0};
        int [] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        BuiltInLinear solution = new BuiltInLinear();
        solution.merge(nums1,m,nums2,n);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m++] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
