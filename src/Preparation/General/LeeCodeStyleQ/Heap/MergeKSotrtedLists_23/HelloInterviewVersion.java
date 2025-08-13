package Preparation.General.LeeCodeStyleQ.Heap.MergeKSotrtedLists_23;

import java.util.PriorityQueue;

public class HelloInterviewVersion {
    public static void main(String[] args) {

    }
    public int[] mergeKLists(int[][] lists) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            for (int j = 0; j < lists[i].length; j++) {
                q.offer(lists[i][j]);
            }
        }
        int k = q.size(), index = 0;
        int [] res = new int [k];
        while (k > 0) {
            res[index++] = q.poll();
            k--;
        }
        return res;
    }
}
