package CodingQuestions.Algorithms.Heap.MaximumSubsequenceScore_2542;

import java.util.Arrays;
import java.util.PriorityQueue;

public class meTrying {
    public static void main(String[] args) {
        int [] nums1 = {4,2,3,1,1};
        int [] nums2 = {7,5,10,9,6};
        int k = 3;
        meTrying ds = new meTrying();
        System.out.println(ds.helper(nums1, nums2, k));
    }

    public int meTrying (int [] arr, int [] arr1, int k) {
        //can not double sort, need to iterate nums2
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        Arrays.sort(arr);
        Arrays.sort(arr1);
        int len = arr.length;
        int countNum1 = 0;
        for (int i = len - 1; i > k - 1; i--) {
            countNum1 += arr[i];
            pq.add(countNum1 * arr1[i]);
        }
        return pq.peek();
    }
    public long helper (int [] arr, int [] arr1, int k) {
        long res = 0;
        int [][] temp = new int [arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            temp[i][0] = arr[i];
            temp[i][1] = arr1[i];
        }
        Arrays.sort(temp,(int a[],int b[]) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += temp[i][0];
            pq.add(temp[i][0]);
        }
        res = sum * temp[k-1][1];

        for (int i = k; i < arr.length; i++) {
            sum += temp[i][0] - pq.poll();
            pq.add(temp[i][0]);
            res = Math.max(res, sum * temp[i][1]);
        }
        return res;
    }
}
