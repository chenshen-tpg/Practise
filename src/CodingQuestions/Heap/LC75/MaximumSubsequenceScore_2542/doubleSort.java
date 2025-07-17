package CodingQuestions.Heap.LC75.MaximumSubsequenceScore_2542;

import java.util.Arrays;
import java.util.PriorityQueue;

public class doubleSort {

    public static void main(String[] args) {
        int [] nums1 = {4,2,3,1,1};
        int [] nums2 = {7,5,10,9,6};
        int k = 3;
        doubleSort ds = new doubleSort();
        System.out.println(ds.maxScore(nums1, nums2, k));
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] p = new int[nums1.length][2];
        for (int i = 0;i < nums1.length; i++) {
            p[i] = new int[] {nums1[i], nums2[i]};
        }
        Arrays.sort(p, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> a - b);
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += p[i][0];
            heap.add(p[i][0]);
        }
        long ans = sum * p[k-1][1];
        for (int i = k; i < nums1.length; i++) {
            sum += p[i][0] - heap.poll();
            heap.add(p[i][0]);
            ans = Math.max(ans, sum * p[i][1]);
        }
        return ans;
    }


}
