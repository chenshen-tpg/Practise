package LC_Questions.Array.ArrayGeneral.Others.IntersectionOfTwoArray_350;

import java.util.Arrays;

public class SampleAns {
    public static void main(String[] args) {

    }
    private int[] usingArrays(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        int[] res = new int[1000];
        for (int n : nums1) {
            freq[n]++;
        }
        int i = 0;
        for (int n : nums2) {
            if (freq[n] > 0) {
                res[i++] = n;
                freq[n]--;
            }
        }
        return Arrays.copyOf(res, i);
    }
}
