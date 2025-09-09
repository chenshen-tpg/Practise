package CodingQuestions.Algorithms.Array.ArrayGeneral.MergeSortedArray_88;

public class Linear {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge1(nums1,m,nums2,n);

    }

    private static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = m + n - 1; i >= 0 ; i--) {
            if (p2 < 0) break;
            if (p1 >= 0 && nums1[p1] > nums1[p2]) {
                nums1[i] = nums1[p1--];
            } else {
                nums1[i] = nums2[p2--];
            }
        }
        System.out.println("done");
    }
}
