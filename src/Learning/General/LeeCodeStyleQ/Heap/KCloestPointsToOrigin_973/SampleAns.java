package Learning.General.LeeCodeStyleQ.Heap.KCloestPointsToOrigin_973;

import java.util.PriorityQueue;

public class SampleAns {
    public static void main(String[] args) {

    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int[] temp = { x * x + y * y, i };
            if (pq.size() < k) {
                pq.offer(temp);
            } else if (temp[0] < pq.peek()[0]) {
                pq.poll();
                pq.offer(temp);
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = points[pq.poll()[1]];
        }
        return res;
    }
}
