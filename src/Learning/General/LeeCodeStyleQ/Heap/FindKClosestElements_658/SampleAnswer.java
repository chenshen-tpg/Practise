package Learning.General.LeeCodeStyleQ.Heap.FindKClosestElements_658;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SampleAnswer {
    public static void main(String[] args) {

    }
    public List<Integer> kClosest(int[] nums, int k, int target) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int num : nums) {
            int distance = Math.abs(num - target);
            if (heap.size() < k) {
                heap.offer(new int[]{-distance, num});
            } else if (distance < -heap.peek()[0]) {
                heap.poll();
                heap.offer(new int[]{-distance, num});
            }
        }

        List<Integer> distances = new ArrayList<>();
        for (int[] pair : heap) {
            distances.add(pair[1]);
        }
        Collections.sort(distances);
        return distances;
    }
}
